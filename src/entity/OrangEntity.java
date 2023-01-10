package entity;

public class OrangEntity {
    private String noTelepon;
    private int umur;
    private char jenisKelamin;
    public OrangEntity(String noTelepon, int umur, char jenisKelamin) {
        this.noTelepon = noTelepon;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
    }
    public String getNoTelepon() {
        return noTelepon;
    }
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }
    public char getJenisKelamin() {
        return jenisKelamin;
    }
    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
