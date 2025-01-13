import java.util.ArrayList;
import java.util.List;

class ZonaWisata extends Entitas {
    private List<ZonaWisata> daftarZona = new ArrayList<>();
    public ZonaWisata(String id, String nama) {
        super(id, nama);
    }

    private List<PemanduWisata> daftarPemandu = new ArrayList<>();

    public void tambahPemandu(PemanduWisata pemandu) {
        daftarPemandu.add(pemandu);
    }

    public List<PemanduWisata> getDaftarPemandu() {
        return daftarPemandu;
    }

    public void tambahZona(ZonaWisata zona) {
        daftarZona.add(zona);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Zona: " + getNama());
    }

    @Override
    public String toString() {
        return "ID Zona: " + getId() + ", Nama: " + getNama();
    }
}