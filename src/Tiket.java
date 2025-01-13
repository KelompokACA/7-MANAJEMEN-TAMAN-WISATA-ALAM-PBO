class Tiket {
    public String kategori;
    public int harga;
    public String fasilitas;

    public Tiket(String kategori, int harga, String fasilitas) {
        this.kategori = kategori;
        this.harga = harga;
        this.fasilitas = fasilitas;
    }

    public void tampilkanInfo() {
        System.out.println("Kategori Tiket: " + kategori);
        System.out.println("Harga Tiket: Rp " + harga);
        System.out.println("Fasilitas: " + fasilitas);
    }

    @Override
    public String toString() {
        return "Kategori: " + kategori + ", Harga: " + harga + ", Fasilitas: " + fasilitas;
    }
}