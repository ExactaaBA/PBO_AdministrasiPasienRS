package entity;

public class StaffEntity {
    private String nama;
    private String Username;
    private String Id;
    private String staffbagian;
    public StaffEntity() {
        this.nama = "izzah";
        this.Username = "ija1";
        this.Id ="123";
        this.staffbagian = "administrasi";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStaffbagian() {
        return staffbagian;
    }

    public void setStaffbagian(String staffbagian) {
        this.staffbagian = staffbagian;
    }
}
