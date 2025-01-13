import java.util.ArrayList;
import java.util.List;

public class ManajerPemanduWisata {
    private List<PemanduWisata> daftarPemandu = new ArrayList<>();

    public void tambahPemandu(PemanduWisata pemandu) {
        daftarPemandu.add(pemandu);
    }

    public String tampilkanDaftarPemandu() {
        StringBuilder daftarPemanduStr = new StringBuilder("Daftar Pemandu Wisata:\n");
        for (PemanduWisata pemandu : daftarPemandu) {
            daftarPemanduStr.append(pemandu.toString()).append("\n");
        }
        return daftarPemanduStr.toString();
    }
}
