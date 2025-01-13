import javax.swing.*;

class TiketReguler extends Tiket {
    public TiketReguler(int harga, String fasilitas) {
        super("Reguler", harga, fasilitas);
    }

    public void tampilkanInfo() {
        String info = "Kategori Tiket: Reguler\n"
                + "Harga Tiket: Rp " + harga + "\n"
                + "Fasilitas: " + fasilitas;
        JOptionPane.showMessageDialog(null, info, "Informasi Tiket Reguler", JOptionPane.INFORMATION_MESSAGE);
    }

}