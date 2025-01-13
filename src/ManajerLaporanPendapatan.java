import java.util.HashMap;
import java.util.Map;

public class ManajerLaporanPendapatan {
    private Map<String, Integer> pendapatan = new HashMap<>();

    // Tambahkan pendapatan berdasarkan tanggal
    public void tambahkanPendapatan(String tanggal, int jumlah) {
        pendapatan.put(tanggal, pendapatan.getOrDefault(tanggal, 0) + jumlah);
    }

    // Hitung total pendapatan
    public int hitungTotalPendapatan() {
        int total = 0;
        for (int jumlah : pendapatan.values()) {
            total += jumlah;
        }
        return total;
    }

    // Tampilkan pendapatan berdasarkan tanggal
    public String tampilkanPendapatanPerTanggal() {
        StringBuilder laporan = new StringBuilder("Laporan Pendapatan:\n");
        for (Map.Entry<String, Integer> entry : pendapatan.entrySet()) {
            laporan.append("Tanggal: ").append(entry.getKey())
                    .append(", Pendapatan: Rp ").append(entry.getValue())
                    .append("\n");
        }
        return laporan.toString();
    }
}
