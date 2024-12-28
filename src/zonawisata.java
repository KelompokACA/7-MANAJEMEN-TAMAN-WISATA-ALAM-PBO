public class ZonaWisata extends Entitas {
    public ZonaWisata(String id, String nama) {
        super(id, nama);
    }


    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId() + ", Nama: " + getNama());
    }
}
