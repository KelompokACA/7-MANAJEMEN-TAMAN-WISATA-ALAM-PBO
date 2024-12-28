import java.time.LocalDate;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Main {
    private List<ZonaWisata> daftarZona = new ArrayList<>();
    private List<PemanduWisata> daftarPemandu = new ArrayList<>();
    private List<Pengunjung> daftarPengunjung = new ArrayList<>();
    private LaporanPendapatan laporanPendapatan = new LaporanPendapatan();

    public void tambahPengunjung(Pengunjung pengunjung) {
        daftarPengunjung.add(pengunjung);
    }
    public void tambahPemandu(PemanduWisata pemandu) {
        daftarPemandu.add(pemandu);
    }
    public void tambahZona(ZonaWisata zona) {
        daftarZona.add(zona);
    }

    // Menyimpan data ke file
    public void simpanData() {
        try (ObjectOutputStream outPengunjung = new ObjectOutputStream(new FileOutputStream("pengunjung.txt"));
             ObjectOutputStream outPemandu = new ObjectOutputStream(new FileOutputStream("pemandu.txt"));
             ObjectOutputStream outZona = new ObjectOutputStream(new FileOutputStream("zona.txt"))) {
             outPengunjung.writeObject(daftarPengunjung);
             outPemandu.writeObject(daftarPemandu);
             outZona.writeObject(daftarZona);
             JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saat menyimpan data: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Main sistem = new Main();
        int pilihan;
        do {
            String menu = """
            ==================================================
            SELAMAT DATANG DI SISTEM MANAJEMEN TAMAN WISATA
            ==================================================
            Pilihan Menu:
            1. Tambah Zona Wisata
            2. Tampilkan Zona Wisata
            3. Tambah Pemandu Wisata
            4. Tampilkan Pemandu Wisata
            5. Tampilkan Info Tiket Reguler
            6. Tampilkan Info Tiket Premium
            7. Tambah Pengunjung
            8. Tampilkan Pengunjung
            9. Simpan Data
            10. Tampilkan Total Pendapatan
            11. Keluar
            """;
            String input = JOptionPane.showInputDialog(menu + "\nPilih menu:");
            if (input == null) break; // Jika pengguna menekan tombol cancel
            try {
                pilihan = Integer.parseInt(input);
                switch (pilihan) {
                    case 1: { // Tambah zona wisata
                        String idZona = JOptionPane.showInputDialog("Masukkan ID Zona Wisata:");
                        String namaZona = JOptionPane.showInputDialog("Masukkan Nama Zona Wisata:");
                        sistem.tambahZona(new ZonaWisata(idZona, namaZona));
                        JOptionPane.showMessageDialog(null, "Zona Wisata " + idZona + " berhasil ditambahkan.");
                        break;
                    }
                    case 2: { // Menampilkan daftar zona
                        StringBuilder daftarZona = new StringBuilder("Daftar Zona Wisata:\n");
                        for (ZonaWisata zona : sistem.daftarZona) {
                            daftarZona.append(zona.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, daftarZona.toString());
                        break;
                    }
                    case 3 : { // Tambah pemandu wisata
                        String idPemandu = JOptionPane.showInputDialog("Masukkan ID Pemandu Wisata:");
                        String namaPemandu = JOptionPane.showInputDialog("Masukkan Nama Pemandu Wisata:");
                        String zonaKerja = JOptionPane.showInputDialog("Masukkan Zona Kerja Pemandu Wisata (1-5):");
                        String jadwalTur = JOptionPane.showInputDialog("Masukkan Jadwal Tur Pemandu Wisata (Pagi/Siang):");
                        sistem.tambahPemandu(new PemanduWisata(idPemandu, namaPemandu, zonaKerja, jadwalTur));
                        JOptionPane.showMessageDialog(null, "Pemandu Wisata berhasil ditambahkan.");
                        break;
                    }
                    case 4 : { // Menampilkan daftar pemandu
                        StringBuilder daftarPemandu = new StringBuilder("Daftar Pemandu Wisata:\n");
                        for (PemanduWisata pemandu : sistem.daftarPemandu) {
                            daftarPemandu.append(pemandu.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, daftarPemandu.toString());
                        break;
                    }
                    case 5 : { //Menampilkan info tiket reguler
                        TiketReguler tiketReguler = new TiketReguler(100000, "Akses ke zona wisata 1 dan 2");
                        tiketReguler.tampilkanInfo();
                        break;
                    }
                    case 6 : { //Menampilkan info tiket premium
                        TiketPremium tiketPremium = new TiketPremium(200000, "Akses ke seluruh zona wisata.");
                        tiketPremium.tampilkanInfo();
                        break;
                    }
                    case 7 : { // Tambah pengunjung dan hitung pendapatan
                        String idPengunjung = JOptionPane.showInputDialog("Masukkan ID Pengunjung:");
                        String namaPengunjung = JOptionPane.showInputDialog("Masukkan Nama Pengunjung:");
                        int umurPengunjung = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Umur Pengunjung:"));
                        String jenisTiket = JOptionPane.showInputDialog("Masukkan Jenis Tiket Pengunjung (Reguler/Premium):");

                        // Validasi jenis tiket
                        int hargaTiket;
                        if (jenisTiket.equalsIgnoreCase("Reguler")) {
                            hargaTiket = 100000;
                        } else if (jenisTiket.equalsIgnoreCase("Premium")) {
                            hargaTiket = 200000;
                        } else {
                            JOptionPane.showMessageDialog(null, "Jenis tiket tidak valid. Tiket default ke Reguler.");
                                hargaTiket = 100000;
                                jenisTiket = "Reguler";
                        }

                        // Tambahkan pengunjung ke daftar
                        Pengunjung pengunjungBaru = new Pengunjung(idPengunjung, namaPengunjung, umurPengunjung, jenisTiket);
                        sistem.tambahPengunjung(pengunjungBaru);

                        // Tambahkan pendapatan ke laporan berdasarkan tanggal hari ini
                        String tanggalHariIni = LocalDate.now().toString(); //Tanggal otomatis
                        sistem.laporanPendapatan.tambahkanPendapatan(tanggalHariIni, hargaTiket);

                        // Tanya apakah ingin menggunakan pemandu wisata
                        int pilihanPemandu =
                                JOptionPane.showConfirmDialog(null, "Apakah pengunjung ingin menggunakan pemandu wisata?", "Pemandu Wisata", JOptionPane.YES_NO_OPTION);
                        if (pilihanPemandu == JOptionPane.YES_OPTION) {
                            // Menampilkan daftar pemandu wisata
                            StringBuilder daftarPemandu = new
                                    StringBuilder("Pilih Pemandu Wisata:\n");
                            for (int i = 0; i < sistem.daftarPemandu.size(); i++) {
                                PemanduWisata pemandu = sistem.daftarPemandu.get(i);
                                daftarPemandu.append((i + 1)).append(".").append(pemandu.toString()).append("\n");
                            }
                            // Input ID pemandu
                            try {
                                int pil =
                                        Integer.parseInt(JOptionPane.showInputDialog(daftarPemandu.toString() + "Masukkan ID pemandu:"));
                                if (pil > 0 && pil <=
                                        sistem.daftarPemandu.size()) {
                                    PemanduWisata pemanduDipilih = sistem.daftarPemandu.get(pil - 1);
                                    JOptionPane.showMessageDialog(null, "Pemandu wisata " + pemanduDipilih.getNama() + " telah dipilih untuk pengunjung.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "ID pemandu tidak valid. Tidak ada pemandu yang dipilih.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Input tidak valid. Tidak ada pemandu yang dipilih.");
                            }
                        }

                        // Tanyakan apakah membutuhkan layanan tambahan
                        int pilihanLayanan =
                                JOptionPane.showConfirmDialog(null, "Apakah pengunjung membutuhkan layanan tambahan?", "Layanan Tambahan", JOptionPane.YES_NO_OPTION);
                        if (pilihanLayanan == JOptionPane.YES_OPTION) {
                            String layanan = JOptionPane.showInputDialog("Pilih layanan tambahan (Katering/Dekorasi):");
                            if (layanan.equalsIgnoreCase("Katering")) {
                                LayananTambahan layananKatering = new LayananKatering();
                                layananKatering.layananKatering();
                                JOptionPane.showMessageDialog(null, "Layanan Katering akan disediakan.");
                            } else if (layanan.equalsIgnoreCase("Dekorasi")) {
                                LayananTambahan layananDekorasi = new LayananDekorasi();
                                layananDekorasi.layananDekorasi();
                                JOptionPane.showMessageDialog(null, "Layanan Dekorasi akan disediakan.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Layanan tidak dikenal.");
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Pengunjung berhasil ditambahkan. Harga Tiket: Rp " + hargaTiket);
                        break;
                    }
                    case 8 : { // Menampilkan daftar pengunjung
                        StringBuilder daftarPengunjung = new StringBuilder("Daftar Pengunjung:\n");
                        for (Pengunjung pengunjung : sistem.daftarPengunjung) {
                            daftarPengunjung.append(pengunjung.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, daftarPengunjung.toString());
                        break;
                    }
                    case 9 : sistem.simpanData(); // Simpan data
                        break;
                    case 10 : { // Menampilkan total pendapatan
                        int totalPendapatan = sistem.laporanPendapatan.hitungTotalPendapatan();
                        JOptionPane.showMessageDialog(null, "Total Pendapatan: Rp " + totalPendapatan);
                        break;
                    }
                    case 11 : {
                        JOptionPane.showMessageDialog(null, "Keluar dari sistem.");
                        return;
                    }
                    default : JOptionPane.showMessageDialog(null, "Pilihan tidak valid, coba lagi.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input tidak valid, masukkan angka.");
            }
        } while (true);
    }
}