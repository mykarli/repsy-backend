package com.repsy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class UploadController {

    @PostMapping("/{packageName}/{version}")
    public ResponseEntity<String> uploadPackage(
            @PathVariable String packageName,
            @PathVariable String version,
            @RequestParam("package.rep") MultipartFile repFile,
            @RequestParam("meta.json") MultipartFile metaFile) {

        try {
            File uploadDir = new File(System.getProperty("java.io.tmpdir") + "/uploads/" + packageName + "/" + version);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            File savedRep = new File(uploadDir, "package.rep");
            repFile.transferTo(savedRep);

            File savedMeta = new File(uploadDir, "meta.json");
            metaFile.transferTo(savedMeta);

            return ResponseEntity.ok("Dosyalar yüklendi.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Dosya yükleme sırasında hata oluştu: " + e.getMessage());
        }
    }
@GetMapping("/{packageName}/{version}")
public ResponseEntity<?> downloadPackage(
        @PathVariable String packageName,
        @PathVariable String version) {

    try {
        File repFile = new File(System.getProperty("java.io.tmpdir") + "/uploads/" + packageName + "/" + version + "/package.rep");

        if (!repFile.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dosya bulunamadı.");
        }

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=package.rep")
                .body(new org.springframework.core.io.FileSystemResource(repFile));

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("İndirme sırasında hata oluştu: " + e.getMessage());
    }
}

}


