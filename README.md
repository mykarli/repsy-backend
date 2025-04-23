# RepsyApp – Dosya Yükleme & İndirme API'si

Bu proje, Java Spring Boot ile geliştirilmiş bir REST API'dir. Kullanıcıdan `package.rep` ve `meta.json` dosyaları alır ve geçici klasöre kaydeder. Ardından bu dosyalar indirilebilir hale gelir.

---

## �� Özellikler

- `POST /mypackage/{packageName}/{version}` → 2 dosya yükler (`package.rep`, `meta.json`)
- `GET /

