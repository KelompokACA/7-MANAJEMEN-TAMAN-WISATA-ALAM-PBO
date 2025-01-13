import javax.swing.JOptionPane;


// Kelas anak dari Tiket
class TiketReguler extends Tiket {
    public TiketReguler(int harga, String fasilitas) {
        super("Reguler", harga, fasilitas);
    }


    @Override
    public void tampilkanInfo() {
        String info = "Tiket Reguler - Harga: " + getHarga() + ", Fasilitas: " + getFasilitas();
        JOptionPane.showMessageDialog(null, info, "Informasi Tiket Reguler", JOptionPane.INFORMATION_MESSAGE);
    }
}
