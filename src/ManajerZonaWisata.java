import java.util.ArrayList;
import java.util.List;

public class ManajerZonaWisata {
    private List<ZonaWisata> daftarZona = new ArrayList<>();

    public ZonaWisata getZonaByNama(String namaZona) {
        for (ZonaWisata zona : daftarZona) {
            if (zona.getNama().equalsIgnoreCase(namaZona)) {
                return zona;
            }
        }
        return null; // Jika zona tidak ditemukan
    }

    public List<ZonaWisata> getDaftarZona() {
        return daftarZona;
    }

    public void tambahZona(ZonaWisata zona) {
        daftarZona.add(zona);
    }

    public String tampilkanDaftarZona() {
        StringBuilder daftarZonaStr = new StringBuilder("Daftar Zona Wisata:\n");
        for (ZonaWisata zona : daftarZona) {
            daftarZonaStr.append(zona.toString()).append("\n");
        }
        return daftarZonaStr.toString();
    }
}
