# Dokumen Spesifikasi Perangkat Lunak & Proyek Akhir PBO 1
## Sistem Manajemen Informasi Akademik Terintegrasi

Proyek ini merupakan rancang bangun aplikasi penataan dan pembedahan repositori data akademik mahasiswa berbasis Java standar (*Java SE*). Proyek ini disusun dan diajukan sebagai bentuk pemenuhan Tugas Akhir komprehensif pada mata kuliah Pemrograman Berbasis Objek 1 di Universitas Islam Kalimantan Muhammad Arsyad Al Banjari Banjarmasin.

---

## 🛠️ Deskripsi Sistem: SmartCampus-Profiler

**SmartCampus-Profiler** adalah sebuah sistem pelacak cerdas (*intelligent tracking system*) sekaligus mesin manajemen repositori data profil mahasiswa yang berjalan secara lokal pada lingkungan runtime Java virtual machine (JVM). Paradigma utama dari aplikasi ini adalah sebagai entitas *decoding* string Nomor Pokok Mahasiswa (NPM) yang terstruktur sepanjang 10 digit angka. 

Sistem bekerja secara otomatis membedah struktur string (NPM) tersebut menggunakan teknik ekstraksi substring dinamis guna melacak, mendeteksi, dan memvalidasi informasi laten berupa:
1. **Tahun Masuk Angkatan**: Melakukan konversi matematis pada 2 digit awal NPM.
2. **Fakultas Penyelenggara**: Memetakan kode numerik pada digit ke-3 dan ke-4 melalui gerbang seleksi kondisional.
3. **Program Studi (Prodi)**: Memetakan variasi kode program studi pada digit ke-5 dan ke-6 menggunakan pohon keputusan switch-case.
4. **Nomor Urut Registrasi**: Memisahkan 4 digit terakhir sebagai kode unik data entitas mahasiswa.

Dengan memanfaatkan arsitektur OOP (*Object-Oriented Programming*), aplikasi ini mampu menjamin modularitas kode, skalabilitas pengembangan, serta proteksi keamanan internal data tanpa memerlukan ketergantungan pada sistem manajemen basis data eksternal (*RDBMS*) yang kompleks selama fase pengujian runtime.

---

## 📑 Penjelasan Mendalam & Implementasi 14 Komponen OOP

Berikut adalah doktrin teknis pengimplementasian konsep pemrograman berorientasi objek yang telah terintegrasi penuh di dalam kode program:

### 1. Class (Cetak Biru Arsitektur)
Class menduduki kasta tertinggi dalam OOP sebagai template, blueprint, atau spesifikasi formal yang mendefinisikan struktur data, variabel state, dan blueprint perilaku (*behavior*) dari sebuah entitas objek. Di dalam arsitektur sistem ini, dideklarasikan 3 Class modular dengan tanggung jawab terpisah (*Separation of Concerns*):
* `AcademicProfile`: Berperan sebagai representasi basis data dasar entitas mahasiswa.
* `ProfileTracker`: Berperan sebagai mesin kalkulasi, ekstraksi, dan pembedah logika NPM.
* `SmartCampusEngine`: Berperan sebagai pusat pengendali, gerbang eksekusi (*Main Class*), dan pengelola alur I/O sistem.

### 2. Object (Instansiasi Entitas Riil)
Object adalah wujud konkret atau manifestasi fisik dari sebuah Class yang dialokasikan secara nyata pada memori heap komputer pada saat fase runtime eksekusi program berlangsung. Pada aplikasi ini, pembuatan objek dilakukan secara dinamis menggunakan operator penunjuk memori `new` di dalam blok perulangan massal:
`databaseCampus[i] = new ProfileTracker(nama, npm);`

### 3. Atribut (Enkapsulasi Variabel State)
Atribut (atau field/variabel anggota) adalah variabel khusus yang melekat erat di dalam struktur tubuh Class yang merepresentasikan status data, karakteristik, ataupun properti internal dari objek. Pada superclass `AcademicProfile`, tertanam dua atribut fundamental berjenis String objek, yaitu `nama` (menyimpan identitas string nama lengkap teks) dan `npm` (menyimpan 10 digit kode identitas mahasiswa).

### 4. Method Constructor (Inisialisasi Keadaan Awal)
Constructor adalah sebuah method spesial yang memiliki nama yang identik dengan nama Class-nya dan tidak memiliki tipe data kembalian (*no return type*). Constructor otomatis dipanggil pertama kali demi mengalokasikan ruang memori dan memberikan nilai state awal saat objek diciptakan. Fungsi `public AcademicProfile(String nama, String npm)` memastikan bahwa data nama dan NPM wajib dikunci langsung ke dalam variabel *state instance* sesaat setelah instruksi `new` dijalankan.

### 5. Method Mutator (Setter)
Method Mutator, atau yang akrab disebut sebagai *Setter*, merupakan fungsi operasional yang mengemban tugas khusus untuk mengubah, memodifikasi, atau mereparasi nilai data yang disimpan di dalam atribut privat yang terisolasi dari dunia luar kampus. Ditandai dengan tipe pengembalian kosong `void` dan berparameter, seperti `setNama(String nama)` dan `setNpm(String npm)`.

### 6. Method Accessor (Getter)
Method Accessor, atau fungsi *Getter*, adalah fungsi penjemput data yang bertugas untuk membaca, mengambil, dan mengembalikan nilai data yang terkunci di dalam atribut proteksi. Method ini wajib memiliki tipe data kembalian (*return type*) yang sinkron dengan tipe data atribut asalnya. Contoh penerapannya adalah fungsi `getNama()`, `getNpm()`, `getTahunMasuk()`, `getFakultas()`, dan `getProdi()`.

### 7. Encapsulation (Mekanisme Proteksi Data)
Encapsulation adalah prinsip dasar OOP yang menyembunyikan detail implementasi internal dan melindungi variabel state dari intervensi atau modifikasi ilegal oleh kode luar secara ugal-ugalan. Pengimplementasian dilakukan dengan menyematkan hak akses `private` pada variabel `nama` dan `npm`. Dengan demikian, akses baca dan tulis wajib melewati protokol gerbang resmi, yaitu method *Accessor* dan *Mutator*.

### 8. Inheritance (Pewarisan Karakteristik Struktur)
Inheritance adalah konsep penurunan atau pewarisan properti, variabel, beserta method dari sebuah kelas induk (*Superclass*) kepada kelas anak (*Subclass*) tanpa perlu mendefinisikan ulang kode dari nol. Di sini, class `ProfileTracker` mendeklarasikan diri sebagai subordinat dari kelas induk `AcademicProfile` dengan memanfaatkan kata kunci operasional `extends`. Efeknya, semua instrumen pengenal nama dan NPM dapat didayagunakan secara penuh oleh kelas anak.

### 9. Polymorphism (Konsep Multi-Perilaku Objek)
Polymorphism menjamin bahwa satu nama method yang sama dapat melahirkan banyak bentuk perilaku output yang berlainan tergantung dari objek pemicunya:
* **Polymorphism Overloading**: Diterapkan pada method `displayInfo(String statusAkademik)` di kelas induk, di mana nama method yang sama mampu menerima parameter tambahan untuk menghasilkan variasi bentuk informasi.
* **Polymorphism Overriding**: Diimplementasikan dengan menuliskan annotation `@Override` di atas method `public String displayInfo()` pada kelas anak `ProfileTracker`, yang bertujuan menindas atau menulis ulang perilaku method bawaan induk agar menghasilkan output dekonstruksi NPM yang komprehensif.

### 10. Seleksi (Struktur Kontrol Pohon Keputusan & Validasi Kronologis)
Seleksi merupakan instruksi kontrol logika kondisional yang memaksa program memilih jalur eksekusi tertentu berdasarkan terpenuhi atau tidaknya sebuah syarat Boolean expression. Aplikasi ini menerapkan skema seleksi multi-layer:
* Kontrol `if-else` pada method `getFakultas()` untuk memvalidasi potongan substring digital "10" demi menunjuk Fakultas Teknologi Informasi.
* Kontrol `switch-case` pada method `getProdi()` untuk melakukan pencocokan pola (*pattern matching*) presisi tinggi terhadap kode prodi "01" (Teknik Informatika) dan "02" (Sistem Informasi).
* Kontrol seleksi kondisional kronologis pada `getValidasiTahunAjaran()` untuk menyaring keabsahan data angkatan historis. Jika ekstraksi tahun berada di bawah tahun berdirinya UNISKA (1981) atau secara anomali melampaui tahun berjalan saat ini (**2026**), sistem akan menjatuhkan vonis penolakan status data secara realtime.

### 11. Perulangan (Mekanisme Iterasi Blok Kode)
Perulangan memfasilitasi komputer untuk mengulang eksekusi serangkaian blok instruksi secara beruntun berdasarkan batas nilai numerik tertentu demi menghemat penulisan redundansi baris program. Aplikasi ini mengawinkan dua jenis loop:
* Loop `for` konvensional berbasis indeks pencacah variabel `i` untuk mengontrol entri data massal dari terminal, didukung fitur de-inkrementasi penunjuk (`i--`) guna memfasilitasi mekanisme *rollback processing* saat masukan data dinyatakan cacat.
* *Enhanced For-Loop* atau *For-Each* (`for (ProfileTracker profil : databaseCampus)`) untuk menyisir dan mengekstrak seluruh koleksi objek dari dalam array tanpa risiko error *out of bounds*.

### 12. Input Output (I/O) SederhanaTerminal Interface
I/O sederhana menjembatani saluran komunikasi data dua arah antara pengguna manusia (*User*) dengan sistem internal program melalui antarmuka konsol text terminal. Saluran masuk data (*input stream*) dikendalikan oleh objek dari library bawaan `java.util.Scanner` via fungsi pembacaan baris `inputScanner.nextLine()`, sedangkan aliran keluar data (*output stream*) ditembakkan langsung menggunakan perintah `System.out.println()`.

### 13. Array of Objects (Struktur Penyimpanan Linear)
Array merupakan struktur data statis linear yang berfungsi menampung sekumpulan elemen data yang bertipe homogen (sejenis) di dalam alamat memori komputer yang saling berdekatan. Pada aplikasi ini, arsitektur array dikembangkan ke tingkat lanjut berupa Array Penyimpan Objek: `ProfileTracker[] databaseCampus = new ProfileTracker[totalData]`, yang memungkinkannya mengoleksi dan mengindeks banyak klaster instansi mahasiswa sekaligus.

### 14. Error Handling & Custom Data Validation Guard
Error Handling bertindak sebagai sabuk pengaman dan dinding pertahanan sistem dari potensi kerusakan fatal (*runtime crash*) akibat kesalahan fatal data masukan atau interupsi sistem di tengah jalan. Penanganan dilakukan melalui penanaman blok pengaman komparatif `try-catch-finally` untuk menjinakkan interupsi `InputMismatchException` apabila batas kuota array dirusak oleh input non-numerik.

Sebagai **Fitur Validasi Tingkat Tinggi (Extra Feature)**, sistem dipersenjatai dengan mesin filter karakter otomatis berbasis *Regular Expression* (Regex) melalui instruksi `nama.matches(".*\\d.*")` untuk memblokir infiltrasi karakter angka pada input nama, serta penguncian panjang string NPM wajib bernilai tepat 10 digit angka (`!npm.matches("\\d+")`). Jika aturan dilanggar, mekanisme penanganan error akan melakukan *rollback* memori secara paksa demi menjamin integritas data.

---

## ⚡ Fitur Kelas Industri (Advanced Details)

Untuk membuktikan kualitas *clean-code* yang siap pakai pada level industri perangkat lunak modern, sistem ini juga ditanami 3 komponen ekstra:

1. **Terminal Visual Colorization (ANSI Codes)**: Optimalisasi visual konsol terminal menggunakan *escape codes* warna (`\u001B[32m`, dll) untuk membedakan secara tegas antara log kesuksesan proses (Hijau), log peringatan kritis (Kuning), log kegagalan fatal (Merah), dan log proses sistem (Cyan).
2. **Simulasi Anonymization Data Keamanan**: Implementasi kepatuhan privasi data tingkat tinggi yang menyadur konsep dasar regulasi perlindungan data (seperti UU PDP / GDPR Compliance) dengan cara menyensor 4 digit terakhir nomor registrasi NPM (`241001****`) pada log rekapitulasi pelaporan utama guna menghindari kebocoran identitas publik.
3. **Siklus Manajemen Memori Virtual (Garbage Collection Hint)**: Pengoptimalan memori heap secara berkala dengan memanggil perintah eksplisit `System.gc()` pada blok `finally`. Instruksi ini memberikan rekomendasi kuat kepada Java Virtual Machine (JVM) untuk segera menyapu bersih dan menghancurkan sisa-sisa objek sampah yang sudah tidak terpakai demi mengeliminasi risiko penumpukan memori (*memory leak*).

---

## 📊 Tabel Usulan Nilai Proyek Akhir

Sesuai dengan ketentuan lembar penilaian instrumen Ujian Akhir Semester (UAS) mata kuliah Pemrograman Berbasis Objek 1, berikut adalah perhitungan mandiri klaim nilai proyek:

| No  | Komponen Penilaian Materi PBO 1 | Nilai Maksimal | Target Capaian Mandiri |
| :-: | ------------------------------- | :------------: | :--------------------: |
|  1  | Class                           |       5        |           5            |
|  2  | Object                          |       5        |           5            |
|  3  | Atribut                         |       5        |           5            |
|  4  | Constructor                     |       5        |           5            |
|  5  | Mutator                         |       5        |           5            |
|  6  | Accessor                        |       5        |           5            |
|  7  | Encapsulation                   |       5        |           5            |
|  8  | Inheritance                     |       5        |           5            |
|  9  | Polymorphism                    |       10       |           10           |
| 10  | Seleksi                         |       5        |           5            |
| 11  | Perulangan                      |       5        |           5            |
| 12  | IO Sederhana                    |       10       |           10           |
| 13  | Array                           |       15       |           15           |
| 14  | Error Handling & Validation     |       15       |           15           |
|     | **TOTAL SKOR PENILAIAN**        |    **100**     |        **100**         |

---

## 👨‍💻 Profil Eksklusif Pengembang Sistem

* **Nama Lengkap Pembuat** : Sayyid Ali Dji Raajii
* **Nomor Pokok Mahasiswa** : 2410010540
* **Fakultas Terdaftar**    : Fakultas Teknologi Informasi (FTI)
* **Program Studi Aktif**   : S1 Teknik Informatika
* **Lembaga Universitas**   : Universitas Islam Kalimantan Muhammad Arsyad Al Banjari Banjarmasin