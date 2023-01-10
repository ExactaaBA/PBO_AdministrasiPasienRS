package entity;

public class PasienEntity extends OrangEntity {
    private String nama;
    private String id; // NORM
    private String tempatTanggalLahir; // (dd/mm/yyyy)
    private String alamat;
    public PasienEntity(String nama, String id, String tempatTanggalLahir, String alamat, String noTelepon, int umur, char jenisKelamin) {
        super( noTelepon, umur, jenisKelamin );
        this.nama = nama;
        this.id = id;
        this.tempatTanggalLahir = tempatTanggalLahir;
        this.alamat = alamat;
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
    public String getTempatTanggalLahir() {
        return tempatTanggalLahir;
    }
    public void setTempatTanggalLahir(String tempatTanggalLahir) {
        this.tempatTanggalLahir = tempatTanggalLahir;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
