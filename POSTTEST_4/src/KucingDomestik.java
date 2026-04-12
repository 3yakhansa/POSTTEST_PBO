class KucingDomestik extends Kucing {
    private boolean sudahVaksinasi;

    public KucingDomestik(int id, String nama, String ras, int usia, String status, boolean sudahVaksinasi) {
        super(id, nama, ras, usia, status);
        this.sudahVaksinasi = sudahVaksinasi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  >> Vaksinasi: " + (sudahVaksinasi ? "Sudah Lengkap" : "Belum"));
    }

    @Override
    public double hitungBiayaPerawatan(int bulan, boolean includeExtraCare) {
        double cost = super.hitungBiayaPerawatan(bulan, includeExtraCare);
        return sudahVaksinasi ? cost * 0.9 : cost;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", jenis='Domestik', vaksin=" + sudahVaksinasi + "}");
    }

    public void cekStatusVaksin() {
        System.out.println("Status Vaksin " + getNama() + ": " + (sudahVaksinasi ? "Aman" : "Perlu Penjadwalan"));
    }
}

