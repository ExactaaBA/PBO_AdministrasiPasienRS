package controller;

import entity.PasienEntity;
import model.PasienModel;
import java.util.ArrayList;

public class PasienController {
    public int getIndexPasien(String id){
        return PasienModel.getIndexPasien(id);
    }
    public boolean addPasien(PasienEntity pasien) {
        return PasienModel.addPasien(pasien);
    }
    public boolean loginAdmin(String nama, String Id){
        return PasienModel.login(nama, Id);
    }
    public ArrayList<PasienEntity> getListPasien() {
        return PasienModel.getListPasien();
    }
    public int editNama(String id, String nama){
        int status = PasienModel.editNama(id, nama);
        return status;
    }
    public int editTempatTanggalLahir(String id, String tempatTanggalLahir){
        int status = PasienModel.editTempatTanggalLahit(id, tempatTanggalLahir);
        return status;
    }
    public int editUmur(String id, int umur){
        int status = PasienModel.editUmur(id,umur);
        return status;
    }
    public int editNomorTelepon(String id, String noTelepon){
        int status = PasienModel.editNomorTelepon(id,noTelepon);
        return status;
    }
    public int editJenisKelamin(String id, char jeniskelamin){
        int status = PasienModel.editJenisKelamin(id,jeniskelamin);
        return status;
    }
    public int editAlamat(String id, String alamat){
        int status = PasienModel.editAlamat(id,alamat);
        return status;
    }
    public boolean removePasien(String id){
        return PasienModel.removePasien(id);
    }
}
