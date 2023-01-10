package entity;

public class DokterEntity {
    private String nama;
    private String id;
    private String spesialis;
    public DokterEntity(String nama, String id, String spesialis) {
        this.nama = nama;
        this.id = id;
        this.spesialis = spesialis;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSpesialis() {
        return spesialis;
    }
    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
}
