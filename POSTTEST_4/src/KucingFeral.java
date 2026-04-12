class KucingFeral extends Kucing {
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

    @Override
    public double hitungBiayaPerawatan(int bulan, boolean includeExtraCare) {
        double cost = super.hitungBiayaPerawatan(bulan, includeExtraCare);
        if (!sudahSteril) cost += 150_000;
        else cost *= 0.85;
        return cost;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", jenis='Feral', steril=" + sudahSteril + "}");
    }

    public void infoKesehatanFeral() {
        System.out.println(" " + getNama() + " adalah kucing feral. Status steril: " +
                (sudahSteril ? "Kondisi stabil, siap adopsi lepas" : "Perlu penanganan TNR segera"));
    }
}