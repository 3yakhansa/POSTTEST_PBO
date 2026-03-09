import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Kucing> dataKucing = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int idCounter = 1;

    public static void main(String[] args) {
        boolean programBerjalan = true;

        dataKucing.add(new Kucing(idCounter++, "Mochi", "Persia", 2, "Tersedia"));
        dataKucing.add(new Kucing(idCounter++, "Oren", "Domestik", 1, "Diadopsi"));

        while (programBerjalan) {
            tampilkanMenu();
            int pilihan = inputAngka("Pilih menu: ");

            if (pilihan == 1) {
                create();
            } else if (pilihan == 2) {
                read();
            } else if (pilihan == 3) {
                update();
            } else if (pilihan == 4) {
                delete();
            } else if (pilihan == 5) {
                System.out.println("trims");
                programBerjalan = false;
            } else {
                System.out.println("Pilihan ga valid");
            }
        }
        scanner.close();
    }

    static void tampilkanMenu() {
        System.out.println("\n<< Shelter Kucing PawPatrol >>");
        System.out.println("1. Tambah Kucing");
        System.out.println("2. Lihat Semua Kucing");
        System.out.println("3. Update Data Kucing");
        System.out.println("4. Hapus Kucing");
        System.out.println("5. Keluar");
    }

    static void create() {
        System.out.println("\n++ Tambah Data Kucing ++");
        System.out.print("Nama: ");
        String nama = scanner.next();
        System.out.print("Ras: ");
        String ras = scanner.next();
        System.out.print("Usia (bulan): ");
        int usia = scanner.nextInt();
        System.out.print("Status (Tersedia/Diadopsi): ");
        String status = scanner.next();

        Kucing kucingBaru = new Kucing(idCounter++, nama, ras, usia, status);
        dataKucing.add(kucingBaru);
        System.out.println("Data dah ditambah");
    }

    static void read() {
        System.out.println("\n++ Daftar Kucing ++");
        if (dataKucing.isEmpty()) {
            System.out.println("ga ada data kucing.");
        } else {
            for (int i = 0; i < dataKucing.size(); i++) {
                Kucing k = dataKucing.get(i);
                k.tampilkanInfo();
            }
        }
    }

    static void update() {
        read();

        System.out.print("\nMasukkan ID kucing yang mau diupdate: ");
        int idTarget = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < dataKucing.size(); i++) {
            if (dataKucing.get(i).getId() == idTarget) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("\nData saat ini:");
            dataKucing.get(index).tampilkanInfo();
            System.out.print("Nama baru: ");
            String namaBaru = scanner.next();
            System.out.print("Ras baru: ");
            String rasBaru = scanner.next();
            System.out.print("Usia baru: ");
            int usiaBaru = scanner.nextInt();
            System.out.print("Status baru (Tersedia/Diadopsi): ");
            String statusBaru = scanner.next();


            dataKucing.get(index).setNama(namaBaru);
            dataKucing.get(index).setRas(rasBaru);
            dataKucing.get(index).setUsia(usiaBaru);
            dataKucing.get(index).setStatus(statusBaru);
            System.out.println("Data diupdate");
        } else {
            System.out.println("ID ga ditemukan!");
        }
    }

    static void delete() {
        read();
        System.out.print("\nMasukkan ID kucing yang ingin dihapus: ");
        int idHapus = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < dataKucing.size(); i++) {
            if (dataKucing.get(i).getId() == idHapus) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            dataKucing.remove(index);
            System.out.println("Data dihapus!");
        } else {
            System.out.println("ID ga ditemukan!");
        }
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