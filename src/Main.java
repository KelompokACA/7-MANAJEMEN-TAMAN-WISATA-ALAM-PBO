import java.time.LocalDate;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ManajerZonaWisata manajerZona = new ManajerZonaWisata();
        ManajerPengunjung manajerPengunjung = new ManajerPengunjung();
        ManajerPemanduWisata manajerPemandu = new ManajerPemanduWisata();
        ManajerLaporanPendapatan manajerPendapatan = new ManajerLaporanPendapatan();

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
            8. Tampilkan Pendapatan per Tanggal
            9. Tampilkan Total Pendapatan
            10. Keluar
            """;
            String input = JOptionPane.showInputDialog(menu + "\nPilih menu:");
            if (input == null) break; //JIka pengguna menekan cancel
            try {
                pilihan = Integer.parseInt(input);
                switch (pilihan) {
                    case 1: {
                        String idZona = JOptionPane.showInputDialog("Masukkan ID Zona Wisata:");
                        String namaZona = JOptionPane.showInputDialog("Masukkan Nama Zona Wisata:");
                        manajerZona.tambahZona(new ZonaWisata(idZona, namaZona));
                        JOptionPane.showMessageDialog(null, "Zona Wisata berhasil ditambahkan.");
                        break;
                    }
                    case 2: {
                        JOptionPane.showMessageDialog(null, manajerZona.tampilkanDaftarZona());
                        break;
                    }
                    case 3: {
                        if (manajerZona.tampilkanDaftarZona().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Belum ada zona wisata yang tersedia. Tambahkan zona wisata terlebih dahulu.");
                            break;
                        }

                        String idPemandu = JOptionPane.showInputDialog("Masukkan ID Pemandu Wisata:");
                        String namaPemandu = JOptionPane.showInputDialog("Masukkan Nama Pemandu Wisata:");

                        // Pilih zona kerja dari daftar zona yang tersedia
                        StringBuilder daftarZonaStr = new StringBuilder("Pilih Zona Kerja:\n");
                        for (int i = 0; i < manajerZona.getDaftarZona().size(); i++) {
                            ZonaWisata zona = manajerZona.getDaftarZona().get(i);
                            daftarZonaStr.append((i + 1)).append(". ").append(zona.getNama()).append("\n");
                        }

                        String zonaKerja;
                        try {
                            int pilihanZona = Integer.parseInt(JOptionPane.showInputDialog(daftarZonaStr.toString() + "Masukkan nomor zona kerja:"));
                            if (pilihanZona > 0 && pilihanZona <= manajerZona.getDaftarZona().size()) {
                                zonaKerja = manajerZona.getDaftarZona().get(pilihanZona - 1).getNama();
                            } else {
                                JOptionPane.showMessageDialog(null, "Pilihan tidak valid. Pemandu tidak ditambahkan.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Input tidak valid. Pemandu tidak ditambahkan.");
                            break;
                        }

                        String setJadwalTur = JOptionPane.showInputDialog("Masukkan Jadwal Tur Pemandu Wisata (Pagi/Siang):");
                        ZonaWisata zonaKerjaObj = manajerZona.getZonaByNama(zonaKerja);

                        if (zonaKerjaObj != null) {
                            manajerPemandu.tambahPemandu(new PemanduWisata(idPemandu, namaPemandu, zonaKerjaObj, setJadwalTur));
                            JOptionPane.showMessageDialog(null, "Pemandu Wisata berhasil ditambahkan.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Zona kerja tidak ditemukan.");
                        }

                        break;
                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, manajerPemandu.tampilkanDaftarPemandu());
                        break;
                    }
                    case 5: {
                        TiketReguler tiketReguler = new TiketReguler(100000, "Akses ke zona wisata umum");
                        tiketReguler.tampilkanInfo();
                        break;
                    }
                    case 6: {
                        TiketPremium tiketPremium = new TiketPremium(200000, "Akses ke seluruh zona wisata");
                        tiketPremium.tampilkanInfo();
                        break;
                    }
                    case 7: {
                        String idPengunjung = JOptionPane.showInputDialog("Masukkan ID Pengunjung:");
                        String namaPengunjung = JOptionPane.showInputDialog("Masukkan Nama Pengunjung:");
                        int umurPengunjung = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Umur Pengunjung:"));
                        String jenisTiket = JOptionPane.showInputDialog("Masukkan Jenis Tiket (Reguler/Premium):");

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

                        Pengunjung pengunjungBaru = new Pengunjung(idPengunjung, namaPengunjung, umurPengunjung, jenisTiket);

                        int pilihanLayanan = JOptionPane.showConfirmDialog(null, "Apakah pengunjung membutuhkan layanan tambahan?", "Layanan Tambahan", JOptionPane.YES_NO_OPTION);
                        if (pilihanLayanan == JOptionPane.YES_OPTION) {
                            while (true) {
                                String layanan = JOptionPane.showInputDialog("Pilih layanan tambahan (Katering/Dekorasi, ketik 'selesai' untuk selesai):");
                                if (layanan.equalsIgnoreCase("Katering")) {
                                    String vendor = JOptionPane.showInputDialog("Masukkan vendor katering:");
                                    double biaya = Double.parseDouble(JOptionPane.showInputDialog("Masukkan biaya katering:"));
                                    pengunjungBaru.tambahLayanan(new LayananKatering(vendor, biaya));
                                    JOptionPane.showMessageDialog(null, "Layanan katering telah ditambahkan.");
                                } else if (layanan.equalsIgnoreCase("Dekorasi")) {
                                    String vendor = JOptionPane.showInputDialog("Masukkan vendor dekorasi:");
                                    double biaya = Double.parseDouble(JOptionPane.showInputDialog("Masukkan biaya dekorasi:"));
                                    pengunjungBaru.tambahLayanan(new LayananDekorasi(vendor, biaya));
                                    JOptionPane.showMessageDialog(null, "Layanan dekorasi telah ditambahkan.");
                                } else if (layanan.equalsIgnoreCase("selesai")) {
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Layanan tidak valid.");
                                }
                            }
                        }
                        manajerPengunjung.tambahPengunjung(pengunjungBaru);
                        String tanggalHariIni = LocalDate.now().toString();
                        manajerPendapatan.tambahkanPendapatan(tanggalHariIni, hargaTiket);

                        JOptionPane.showMessageDialog(null, "Pengunjung berhasil ditambahkan. Harga Tiket: Rp " + hargaTiket);
                        break;
                    }
                    case 8: {
                        JOptionPane.showMessageDialog(null, manajerPendapatan.tampilkanPendapatanPerTanggal());
                        break;
                    }
                    case 9: {
                        int totalPendapatan = manajerPendapatan.hitungTotalPendapatan();
                        JOptionPane.showMessageDialog(null, "Total Pendapatan: Rp " + totalPendapatan);
                        break;
                    }
                    case 10: {
                        JOptionPane.showMessageDialog(null, "Keluar dari sistem.");
                        return;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input tidak valid.");
            }
        } while (true);
    }
}
