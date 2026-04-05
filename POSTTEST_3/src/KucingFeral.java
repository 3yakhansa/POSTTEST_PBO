public class KucingFeral extends Kucing {
    private boolean sudahSteril;

    public KucingFeral(int id, String nama, String ras, int usia, String status, boolean sudahSteril) {
        super(id, nama, ras, usia, status);
        this.sudahSteril = sudahSteril;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  >> Program TNR (Steril): " + (sudahSteril ? "Sudah" : "Belum"));
    }

    public void infoKesehatanFeral() {
        System.out.println(getNama() + " adalah kucing feral. Status steril: " +
                (sudahSteril ? "Kondisi stabil, siap adopsi lepas" : "Perlu penanganan TNR segera"));
    }
}