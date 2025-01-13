import javax.swing.JOptionPane;


// Kelas anak dari Tiket
class TiketPremium extends Tiket {
    public TiketPremium(int harga, String fasilitas) {
        super("Premium", harga, fasilitas);
    }


    @Override
    public void tampilkanInfo() {
        String info = "Tiket Premium - Harga: " + getHarga() + ", Fasilitas: " + getFasilitas();
        JOptionPane.showMessageDialog(null, info, "Informasi Tiket Premium", JOptionPane.INFORMATION_MESSAGE);
    }
}
