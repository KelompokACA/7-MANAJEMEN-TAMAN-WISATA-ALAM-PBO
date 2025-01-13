import javax.swing.*;

class LayananDekorasi implements Layanan {
    private String vendor;
    private double biaya;

    public LayananDekorasi(String vendor, double biaya) {
        this.vendor = vendor;
        this.biaya = biaya;
    }

    @Override
    public String getNamaLayanan() {
        return "Dekorasi";
    }

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public double getBiaya() {
        return biaya;
    }

    @Override
    public void tampilkanInfoLayanan() {
        String info = "Detail Layanan " + getNamaLayanan() + "\n"
                + "Vendor: " + vendor + "\n"
                + "Biaya: Rp " + biaya;
        JOptionPane.showMessageDialog(null, info, "Detail Layanan Dekorasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
