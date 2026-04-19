import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Kucing> dataKucing = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int idCounter = 1;

    public static void main(String[] args) {
        boolean programBerjalan = true;

        dataKucing.add(new KucingDomestik(idCounter++, "Oren", "Domestik", 12, "Tersedia", true));
        dataKucing.add(new KucingLangka(idCounter++, "Mochi", "Persia", 24, "Tersedia", "CFA Certified"));
        dataKucing.add(new KucingFeral(idCounter++, "Tutul", "Domestik", 18, "Diadopsi", false));

        while (programBerjalan) {
            tampilkanMenu();
            int pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {
                case 1: create(); break;
                case 2: read(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: tesProtectedAccess(); break;
                case 6:
                    System.out.println("Trims! Program ditutup.");
                    programBerjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    static void tesProtectedAccess() {
        System.out.println("\n>> Testing Protected Access:");
        boolean ditemukan = false;
        for (Kucing k : dataKucing) {
            if (k instanceof KucingLangka) {
                ((KucingLangka) k).tampilkanDetailKhusus();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Tidak ada data KucingLangka untuk tes protected.");
    }

    static void tampilkanMenu() {
        System.out.println("\n<< Shelter Kucing PawPatrol >>");
        System.out.println("1. Tambah Kucing");
        System.out.println("2. Lihat Semua Kucing");
        System.out.println("3. Update Data Kucing");
        System.out.println("4. Hapus Kucing");
        System.out.println("5. Tes Protected Access");
        System.out.println("6. Keluar");
    }

    static void create() {
        System.out.println("\n++ Tambah Data Kucing ++");
        System.out.print("Nama: "); String nama = scanner.next();
        System.out.print("Ras: "); String ras = scanner.next();
        System.out.print("Usia (bulan): "); int usia = scanner.nextInt();
        System.out.print("Status (Tersedia/Diadopsi): "); String status = scanner.next();

        System.out.print("Pilih Jenis Kucing (1: Domestik / 2: Langka / 3: Feral): ");
        int jenis = inputAngka("");

        Kucing kucingBaru = null;
        switch (jenis) {
            case 1:
                System.out.print("Sudah Vaksin? (true/false): ");
                boolean vaksin = scanner.nextBoolean();
                kucingBaru = new KucingDomestik(idCounter++, nama, ras, usia, status, vaksin);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Sertifikasi Asal: ");
                String sertifikat = scanner.nextLine();
                kucingBaru = new KucingLangka(idCounter++, nama, ras, usia, status, sertifikat);
                break;
            case 3:
                System.out.print("Sudah Disteril/TNR? (true/false): ");
                boolean steril = scanner.nextBoolean();
                kucingBaru = new KucingFeral(idCounter++, nama, ras, usia, status, steril);
                break;
            default:
                System.out.println("Jenis tidak valid.");
                return;
        }
        if (kucingBaru != null) {
            dataKucing.add(kucingBaru);
            System.out.println("Data Kucing berhasil ditambah.");
        }
    }

    static void read() {
        System.out.println("\n++ Daftar Kucing ++");
        if (dataKucing.isEmpty()) {
            System.out.println("Tidak ada data kucing.");
        } else {
            for (Kucing k : dataKucing) {
                k.tampilkanInfo();
                double biaya = k.hitungBiayaPerawatan(1, true);
                System.out.printf("  >> Estimasi Biaya Perawatan (1 bln + ekstra): Rp %,d%n", (int)biaya);

                if (k instanceof PerawatanKucing) {
                    PerawatanKucing perawatan = (PerawatanKucing) k;
                    perawatan.cekKondisiKesehatan();
                    perawatan.berikanPerawatanKhusus();
                }
                System.out.println("--------------------");
            }
        }
    }

    static void update() {
        read();
        System.out.print("\nMasukkan ID kucing yang mau diupdate: ");
        int idTarget = inputAngka("ID: ");

        Kucing target = null;
        for (Kucing k : dataKucing) {
            if (k.getId() == idTarget) {
                target = k;
                break;
            }
        }

        if (target != null) {
            System.out.println("\nData saat ini:");
            target.tampilkanInfo();
            System.out.print("Nama baru: "); target.setNama(scanner.next());
            System.out.print("Ras baru: "); target.setRas(scanner.next());
            System.out.print("Usia baru: "); target.setUsia(scanner.nextInt());
            System.out.print("Status baru: ");
            String statusBaru = scanner.next();

            System.out.print("Sertakan alasan perubahan status? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                scanner.nextLine();
                System.out.print("Alasan: ");
                String alasan = scanner.nextLine();
                target.setStatus(statusBaru, alasan);
            } else {
                target.setStatus(statusBaru);
            }
            System.out.println("Data berhasil diupdate!");
        } else {
            System.out.println("ID tidak ditemukan!");
        }
    }

    static void delete() {
        read();
        System.out.print("\nMasukkan ID kucing yang ingin dihapus: ");
        int idHapus = inputAngka("ID: ");

        boolean dihapus = false;
        for (int i = 0; i < dataKucing.size(); i++) {
            if (dataKucing.get(i).getId() == idHapus) {
                dataKucing.remove(i);
                dihapus = true;
                break;
            }
        }
        System.out.println(dihapus ? "Data berhasil dihapus!" : "ID tidak ditemukan!");
    }

    static int inputAngka(String pesan) {
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus angka!");
            scanner.next();
            System.out.print(pesan);
        }
        return scanner.nextInt();
    }
}