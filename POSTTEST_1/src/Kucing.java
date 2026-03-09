public class Kucing {
    private int id;
    private String nama;
    private String ras;
    private int usia;
    private String status;

    public Kucing(int id, String nama, String ras, int usia, String status) {
        this.id = id;
        this.nama = nama;
        this.ras = ras;
        this.usia = usia;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getRas() {
        return ras;
    }

    public int getUsia() {
        return usia;
    }

    public String getStatus() {
        return status;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + id +
                " | Nama: " + nama +
                " | Ras: " + ras +
                " | Usia: " + usia +
                " | Status: " + status);
    }
}