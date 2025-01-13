import javax.swing.*;

interface Layanan {
    String getNamaLayanan();
    String getVendor();
    double getBiaya();
    public default void tampilkanInfoLayanan() {
        String info = "Detail Layanan " + getNamaLayanan() + "\n"
                + "Vendor: " + getVendor() + "\n"
                + "Biaya: Rp " + getBiaya();
        JOptionPane.showMessageDialog(null, info, "Detail Layanan Dekorasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
