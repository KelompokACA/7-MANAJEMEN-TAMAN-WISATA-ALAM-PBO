import java.util.HashMap;
import java.util.Map;

class LaporanPendapatan {
    private Map<String, Integer> pendapatan = new HashMap<>();

    public void tambahkanPendapatan(String tanggal, int jumlah) {
        pendapatan.put(tanggal, pendapatan.getOrDefault(tanggal, 0) + jumlah);
    }

    public int hitungTotalPendapatan() {
        int total = 0;
        for (int pendapatan : pendapatan.values()) {
            total += pendapatan;
        }
        return total;
    }
}
