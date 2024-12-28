class PemanduWisata extends Entitas {
    private String zonaKerja;
    private String jadwalTur;

    public PemanduWisata(String id, String nama, String zonaKerja, String jadwalTur) {
        super(id, nama);
        this.zonaKerja = zonaKerja;
        this.jadwalTur = jadwalTur;
    }

    @Override
    public String toString() {
        return super.toString() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + jadwalTur;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println(super.toString() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + jadwalTur);
    }
}
