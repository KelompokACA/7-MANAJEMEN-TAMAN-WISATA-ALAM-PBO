public class PemanduWisata extends Entitas {
    private String zonaKerja;
    private String jadwalTur;

    public PemanduWisata(String id, String nama, String zonaKerja, String jadwalTur) {
        super(id, nama);
        this.zonaKerja = zonaKerja;
        this.jadwalTur = jadwalTur;
    }

    public String getZonaKerja() {
        return zonaKerja;
    }

    public String getJadwalTur() {
        return jadwalTur;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId() + ", Nama: " + getNama() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + jadwalTur);
    }
}