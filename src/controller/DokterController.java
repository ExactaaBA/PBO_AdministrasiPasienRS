package controller;

import entity.DokterEntity;
import model.DokterModel;
import java.util.ArrayList;

public class DokterController {
    public int getIndexDokter(String nama){
        return DokterModel.getIndexDokter(nama);
    }
    public boolean addDokter(DokterEntity dokter) {
        return DokterModel.addDokter(dokter);
    }
    public ArrayList<DokterEntity> getListDokter() {
        return DokterModel.getListDokter();
    }
    public int editId(String nama, String id){
        int status = DokterModel.editId(nama, id);
        return status;
    }
    public int editSpesialis(String nama, String spesialis){
        int status = DokterModel.editSpesialis(nama,spesialis);
        return status;
    }
    public boolean removeDokter(String nama){
        return DokterModel.removeDokter(nama);
    }
}
