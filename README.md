# UAS SPK - SiDeDi : Sistem Informasi Deteksi Diabetes

## ⚠️ Disclaimer
> Repository ini merupakan project UAS mata kuliah `Sistem Pendukung Keputusan (SPK)` atau `Decision Suport System (DSS)` yang dikembangkan untuk tujuan memenuhi prasyarat mata kuliah SPK. Dataset yang digunakan sebagai acuan perhitungan diabetes disini merupakan `dataset dummy` yang digunakan untuk `tujuan edukasi`.  **⚠️ APLIKASI INI TIDAK DIGUNAKAN SEBAGAI ACUAN MEDIS ATAU TUJUAN KOMERSIAL⚠️** 

## 💬 Informasi
Pengembangan aplikasi ini didasarkan pada materi pada kelas SPK yaitu penerapan Metode [Naive Bayes Classifier (NBC)](https://towardsdatascience.com/naive-bayes-classifier-81d512f50a7c) untuk mengkasifikasi penyakit diabetes berdasarkan beberapa kriteria gejala yang ditentukan. Pengembangan aplikasi SiDeDi ini mengacu pada publikasi jurnal yang sama yaitu [JSIKA - SiDedi (Sistem Informasi Deteksi Diabetes) : Sistem Pendukung Keputusan Deteksi Dini Diabetes](https://www.dropbox.com/s/d12t67ayl5jv14e/Jurnal%20SiDeDi.pdf?dl=0).

## 👉 Petunjuk
- Uji Coba aplikasi dapat diunduh pada halaman [berikut][appURL].
- Untuk dapat menggunakan sistem deteksi diabetes, repository ini memerlukan depedensi pada sistem REST API pada [repository ini](https://github.com/apriantoa917/php-UAS_SPK-SiDeDi).
- Ubah alamat IP pada file `Constanta.java` di repository ini dengan alamat IP server REST API dijalankan (cek dengan command line `ipconfig`. Halaman file [Constanta.java][fileGradleProperties] 
    ```java
   public class Constanta {
        ..
        // ganti dengan alamat localhost kamu
        String SERVER = "ubah dengan alamat IP kamu>"; // menjadi "192.xxx.xxx.xxx"
        ..
    }
    ```

## 📱 Gambaran Aplikasi
<div>
  <img src="https://www.dropbox.com/s/sq31nmtepcsyh13/banner_mobile.png?raw=1" alt="Aplikasi SiDeDi"/>
</div>

## 🚧 Feature
- [x] Shortcut pencarian rumah sakit terdekat di Google Maps
- [x] Friendly & Interaktif User Interface untuk memilih gejala diabetes yang ada
- [x] Perhitungan risiko diabetes dengan metode Naive Bayes Classifier (REST API PHP native)
- [x] Bacaan / Informasi terkait dengan Diabetes
- [x] Daftar Artikel seputar penyakit Diabetes pada Firebase Realtime Database
- [x] Webview untuk memuat artikel dalam aplikasi

## 🤝🏻 Credits (Tim UAS)
- Aprianto (1841010002) : [Instagram](https://www.instagram.com/apriantoa917) | [Linkedin](https://www.linkedin.com/in/apriantoa917/)
- Reva Eka Prasetyo (1841010004) : [Instagram](https://www.instagram.com/revaekap/) | [Linkedin](https://www.linkedin.com/in/revaekap/)
- Onastatia Sahartian (1841010016) : [Instagram](https://www.instagram.com/onastatia_/) | [Linkedin](https://www.linkedin.com/in/onastatia-sahartian-0229081ba/)


[appURL]: <>

