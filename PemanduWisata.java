<<<<<<< HEAD
class PemanduWisata extends Entitas{
    private ZonaWisata zonaKerja;
    private String jadwalTur;

    public PemanduWisata(String id, String nama, ZonaWisata zonaKerja, String jadwalTur) {
        super(id, nama); // Jika menggunakan inheritance dari Entitas
=======
class PemanduWisata extends Entitas {
    private String zonaKerja;
    private String jadwalTur;

    public PemanduWisata(String id, String nama, String zonaKerja, String jadwalTur) {
        super(id, nama);
>>>>>>> b3e632d9a89cbb428929e614e85103e6f59b7c3f
        this.zonaKerja = zonaKerja;
        this.jadwalTur = jadwalTur;
    }

<<<<<<< HEAD
    public ZonaWisata getZonaKerja() {
        return zonaKerja;
    }

    public String setJadwalTur() {
        return jadwalTur;
=======
    @Override
    public String toString() {
        return super.toString() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + jadwalTur;
>>>>>>> b3e632d9a89cbb428929e614e85103e6f59b7c3f
    }

    @Override
    public void tampilkanInfo() {
<<<<<<< HEAD
        return;
    }

    @Override
    public String toString() {
        return "Pemandu ID: " + getId() + ", Nama: " + getNama() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + setJadwalTur();
=======
        System.out.println(super.toString() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + jadwalTur);
>>>>>>> b3e632d9a89cbb428929e614e85103e6f59b7c3f
    }
}
