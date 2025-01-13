class PemanduWisata extends Entitas{
    private ZonaWisata zonaKerja;
    private String jadwalTur;

    public PemanduWisata(String id, String nama, ZonaWisata zonaKerja, String jadwalTur) {
        super(id, nama); // Jika menggunakan inheritance dari Entitas
        this.zonaKerja = zonaKerja;
        this.jadwalTur = jadwalTur;
    }

    public ZonaWisata getZonaKerja() {
        return zonaKerja;
    }

    public String setJadwalTur() {
        return jadwalTur;
    }

    @Override
    public void tampilkanInfo() {
        return;
    }

    @Override
    public String toString() {
        return "Pemandu ID: " + getId() + ", Nama: " + getNama() + ", Zona Kerja: " + zonaKerja + ", Jadwal Tur: " + setJadwalTur();
    }
}
