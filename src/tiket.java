class Tiket {
    private String kategori;
    private int harga;
    private String fasilitas;

    public Tiket(String kategori, int harga, String fasilitas) {
        this.kategori = kategori;
        this.harga = harga;
        this.fasilitas = fasilitas;
    }

    public String getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println("Kategori: " + kategori + ", Harga: " + harga + ", Fasilitas: " + fasilitas);
    }
}

class TiketReguler extends Tiket {
    public TiketReguler(int harga, String fasilitas) {
        super("Reguler", harga, fasilitas);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Tiket Reguler - Harga: " + getHarga() + ", Fasilitas: " + getKategori());
    }
}

class TiketPremium extends Tiket {
    public TiketPremium(int harga, String fasilitas) {
        super("Premium", harga, fasilitas);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Tiket Premium - Harga: " + getHarga() + ", Fasilitas: " + getKategori());
    }
}

//Coba ae