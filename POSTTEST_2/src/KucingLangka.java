public class KucingLangka extends Kucing {

    public KucingLangka(int id, String nama, String ras, int usia, String status) {
        super(id, nama, ras, usia, status);
    }

    public void tampilkanDetailKhusus() {
        System.out.println(">> [Protected Diakses] " + super.getDetailInternal());
    }
}