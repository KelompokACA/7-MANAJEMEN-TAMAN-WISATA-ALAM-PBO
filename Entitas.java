import java.io.Serializable;

abstract class Entitas implements Serializable {
    private String id;
    private String nama;

    public Entitas(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public abstract void tampilkanInfo();

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama;
    }
}
