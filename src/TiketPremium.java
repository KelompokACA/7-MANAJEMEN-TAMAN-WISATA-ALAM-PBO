import javax.swing.*;

class TiketPremium extends Tiket {
    public TiketPremium(int harga, String fasilitas) {
        super("Premium", harga, fasilitas);
    }

    public void tampilkanInfo() {
        String info = "Kategori Tiket: Premium\n"
                + "Harga Tiket: Rp " + harga + "\n"
                + "Fasilitas: " + fasilitas;
        JOptionPane.showMessageDialog(null, info, "Informasi Tiket Premium", JOptionPane.INFORMATION_MESSAGE);
    }

}