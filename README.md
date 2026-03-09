# POSTTEST_PBO

## POST TEST 1

## Sistem Manajemen Shelter Kucing PawPatrol 😼🙌

### A. Deskripsi Program
Program ini dibuat menggunakan bahasa pemrograman Java. Tujuan utamanya adalah untuk memudahkan pengelolaan data kucing yang ada di shelter, mulai dari pencatatan kucing baru hingga update status adopsi. Sistem ini dibangun menggunakan konsep Object-Oriented Programming (OOP) di mana data kucing dibungkus dalam sebuah Class, dan penyimpanan datanya menggunakan ArrayList agar bersifat dinamis (bisa tambah/hapus tanpa batas ukuran tetap). Program ini berjalan secara interaktif menggunakan looping menu, jadi pengguna bisa melakukan banyak operasi sampai memutuskan untuk keluar.

### B. Fitur Program
1. Menu Utama
   Pada bagian ini pengguna dapat melihat apa saja menu yang tersedia dan dapat diakses. Ada 5 opsi yang dapat dipilih oleh pengguna seperti yang terdapat pada gambar.
  
2. Create
- Fitur ini digunakan untuk menambah data kucing baru dengan cara,
  User input nama, ras, usia, status → Data disimpan ke ArrayList dengan ID otomatis.
  
3. Read
- Fitur ini digunakan untuk melihat daftar kucing yang terdapat di Shelter Pawpatrol.
  Program melakukan looping pada ArrayList dan menampilkan semua data yang tersimpan.
  
5. Update
- Fitur ini digunakan untuk mengubah atau memperbarui data kucing yang terdapat di shelter.
  User pilih ID kucing → Update nama/ras/usia/status tanpa mengubah ID.
   
6. Delete
- Fitur ini digunakan untuk menghapus data kucing yang ada.
  User pilih ID kucing → Data dihapus dari ArrayList (misal karena sudah diadopsi).

### C. Struktur Kode
Program ini terdiri dari 2 file Java utama yang saling berkaitan:

1. Kucing.java
  Class ini berfungsi sebagai blueprint atau cetakan untuk objek kucing. Di sini didefinisikan properti seperti id, nama, ras, usia, dan status. Class ini juga memiliki method getter/setter
  untuk encapsulasi data dan method untuk menampilkan info kucing.
2. Main.java
  Class ini merupakan entry point program. Berisi logika utama seperti menu interaktif, input user menggunakan Scanner, dan eksekusi fungsi CRUD menggunakan loop dan conditional statement.

### D. Output Program
1. Tampilan Menu
![Tampilan Menu](screenshots/tampilanMenu.png)
   
2. Menambahkan Data Kucing


3. Melihat Data Kucing


4. Memperbarui Data Kucing


5. Menghapus Data Kucing
