public class KucingLangka extends Kucing {
    private String sertifikasi;

    public KucingLangka(int id, String nama, String ras, int usia, String status, String sertifikasi) {
        super(id, nama, ras, usia, status);
        this.sertifikasi = sertifikasi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  >> Sertifikasi: " + sertifikasi);
    }

    public void tampilkanDetailKhusus() {
        System.out.println(">> [Protected Diakses] " + super.getDetailInternal());
        System.out.println("  >> Dokumen Sertifikat: " + sertifikasi);
    }
}