![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/java-17-blue)

# RepsyApp – Dosya Yükleme & İndirme API'si

Bu proje, Java Spring Boot ile geliştirilmiş bir REST API'dir. Kullanıcıdan `package.rep` ve `meta.json` dosyaları alır ve geçici klasöre kaydeder. Ardından bu dosyalar indirilebilir hale gelir.

---

## 🚀 Özellikler

- `POST /mypackage/{packageName}/{version}`  
  → 2 dosya yükler (`package.rep`, `meta.json`)
  
- `GET /mypackage/{packageName}/{version}/{fileName}`  
  → Dosya indirir (`package.rep` veya `meta.json`)

---

## 🛠 Teknolojiler

- Java 17  
- Spring Boot 3  
- Spring Web  
- Multipart File Upload  
- File System Storage

---

## 📦 Nasıl Çalıştırılır?

```bash
# Derle
./mvnw clean package

# Uygulamayı başlat
./mvnw spring-boot:run
```

Uygulama varsayılan olarak `http://localhost:8080` üzerinde çalışır.

---

## 📁 Örnek CURL Komutları

**Yükleme için:**

```bash
curl -X POST http://localhost:8080/mypackage/1.0.0 \
  -F "package.rep=@/path/to/package.rep" \
  -F "meta.json=@/path/to/meta.json"
```

**İndirme için:**

```bash
curl -O http://localhost:8080/mypackage/1.0.0/package.rep
```

---

## 👨‍💻 Geliştirici

👤 [@mykarli](https://github.com/mykarli)

