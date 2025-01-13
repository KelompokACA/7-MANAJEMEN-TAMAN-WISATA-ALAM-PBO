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


    public String getFasilitas(){
        return fasilitas;
    }


    public void tampilkanInfo() {
        System.out.println("Kategori: " + kategori + ", Harga: " + harga + ", Fasilitas: " + fasilitas);
    }
}
//up