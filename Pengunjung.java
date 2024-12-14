public class Pengunjung extends Entitas {
    private int umur;
    private String jenisTiket;

    public Pengunjung(String id, String nama, int umur, String jenisTiket) {
        super(id, nama);
        this.umur = umur;
        this.jenisTiket = jenisTiket;
    }

    public int getUmur() {
        return umur;
    }

    public String getJenisTiket() {
        return jenisTiket;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId() + ", Nama: " + getNama() + ", Umur: " + umur + ", Tiket: " + jenisTiket);
    }
}
