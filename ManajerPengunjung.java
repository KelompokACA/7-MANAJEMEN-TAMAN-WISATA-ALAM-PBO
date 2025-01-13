import java.util.ArrayList;
import java.util.List;

public class ManajerPengunjung {
    private List<Pengunjung> daftarPengunjung = new ArrayList<>();

    public void tambahPengunjung(Pengunjung pengunjung) {
        daftarPengunjung.add(pengunjung);
    }

    public String tampilkanDaftarPengunjung() {
        StringBuilder daftarPengunjungStr = new StringBuilder("Daftar Pengunjung:\n");
        for (Pengunjung pengunjung : daftarPengunjung) {
            daftarPengunjungStr.append(pengunjung.toString()).append("\n");
        }
        return daftarPengunjungStr.toString();
    }
}
