import java.util.ArrayList;
import java.util.List;

public class Pengunjung extends Entitas{
    private int umur;
    private String jenisTiket;
    private List<Layanan> layananTambahan; // Tambahan untuk mencatat layanan

    public Pengunjung(String id, String nama, int umur, String jenisTiket) {
        super(id, nama);
        this.umur = umur;
        this.jenisTiket = jenisTiket;
        this.layananTambahan = new ArrayList<>();
    }

    public void tambahLayanan(Layanan layanan) {
        layananTambahan.add(layanan);
    }

    public List<Layanan> getLayananTambahan() {
        return layananTambahan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId() + ", Nama: " + getNama() + ", Umur: " + umur + ", Jenis Tiket: " + jenisTiket);
        System.out.println("Layanan Tambahan:");
        for (Layanan layanan : layananTambahan) {
            System.out.println("- " + layanan.getNamaLayanan() + " oleh " + layanan.getVendor() + ", Biaya: Rp " + layanan.getBiaya());
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(super.toString() + ", Umur: " + umur + ", Jenis Tiket: " + jenisTiket + "\nLayanan Tambahan:\n");
        for (Layanan layanan : layananTambahan) {
            info.append("- ").append(layanan.getNamaLayanan()).append(" oleh ").append(layanan.getVendor()).append(", Biaya: Rp ").append(layanan.getBiaya()).append("\n");
        }
        return info.toString();
    }
}
