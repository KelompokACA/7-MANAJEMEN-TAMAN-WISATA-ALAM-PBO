class Pengunjung extends Entitas {
    private int umur;
    private String jenisTiket;

    public Pengunjung(String id, String nama, int umur, String jenisTiket) {
        super(id, nama);
        this.umur = umur;
        this.jenisTiket = jenisTiket;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(super.toString() + ", Umur: " + umur + ", Tiket: " + jenisTiket);
    }

    @Override
    public String toString() {
        return super.toString() + ", Umur: " + umur + ", Tiket: " + jenisTiket;
    }
}
