class Kucing {
    private int id;
    private String nama;
    private String ras;
    private int usia;
    private String status;

    public Kucing(int id, String nama, String ras, int usia, String status) {
        this.id = id;
        this.nama = nama;
        this.ras = ras;
        setUsia(usia);
        this.status = status;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getRas() { return ras; }
    public int getUsia() { return usia; }
    public String getStatus() { return status; }

    public void setNama(String nama) { this.nama = nama; }
    public void setRas(String ras) { this.ras = ras; }
    public void setUsia(int usia) {
        if (usia > 0) { this.usia = usia; }
        else { System.out.println("Usia tidak valid. Diatur ke 1 bulan."); this.usia = 1; }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(String status, String keterangan) {
        this.status = status;
        System.out.println("[Catatan Update] " + nama + ": " + keterangan);
    }

    public double hitungBiayaPerawatan(int bulan) {
        return bulan * 75_000;
    }

    public double hitungBiayaPerawatan(int bulan, boolean includeExtraCare) {
        double cost = hitungBiayaPerawatan(bulan);
        if (includeExtraCare) cost += 50_000;
        return cost;
    }

    protected String getDetailInternal() {
        return "Detail Internal: " + id + " - " + nama + " (" + ras + ") | Usia: " + usia + "bln";
    }


    public void tampilkanInfo() {
        System.out.println("ID: " + id +
                " | Nama: " + nama +
                " | Ras: " + ras +
                " | Usia: " + usia +
                " | Status: " + status);
    }

    @Override
    public String toString() {
        return "Kucing{" + "id=" + id + ", nama='" + nama + '\'' + ", ras='" + ras + '\'' + '}';
    }
}