public class KucingLangka extends Kucing implements PerawatanKucing {
    private String sertifikasi;

    public KucingLangka(int id, String nama, String ras, int usia, String status, String sertifikasi) {
        super(id, nama, ras, usia, status);
        this.sertifikasi = sertifikasi;
    }

    @Override
    public double hitungBiayaPerawatan(int bulan) {
        return bulan * 75_000 * 1.5;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  >> Sertifikasi: " + sertifikasi);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", jenis='Langka', sertifikat='" + sertifikasi + "'}");
    }

    public void tampilkanDetailKhusus() {
        System.out.println(">> [Protected Diakses] " + super.getDetailInternal());
        System.out.println("  >> Dokumen Sertifikat: " + sertifikasi);
    }

    @Override
    public void berikanPerawatanKhusus() {
        System.out.println("[Perawatan Langka] " + getNama() + " mendapat makanan import dan perawatan kulit khusus.");
    }

    @Override
    public void cekKondisiKesehatan() {
        System.out.println("[Cek Kesehatan Langka] " + getNama() + " - Kondisi prima. Sertifikasi: " + sertifikasi);
    }
}