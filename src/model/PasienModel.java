package model;

import entity.PasienEntity;
import java.util.ArrayList;

public class PasienModel {
    static ArrayList<PasienEntity> pasienEntityArrayList = new ArrayList<>();
    public static int getIndexPasien(String id) {
        int index = -1;
        if (pasienEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong \n");
        } else {
            for (PasienEntity pasien : pasienEntityArrayList) {
                if (pasien.getId().equals(id)) {
                    index = pasienEntityArrayList.indexOf(pasien);
                }
            }
        }
        return index;
    }
    public static boolean addPasien(PasienEntity pasienEntity){
        boolean status = false;
        if (pasienEntity != null){
            pasienEntityArrayList.add(pasienEntity);
            status = true;
        }
        return status;
    }
    public static PasienEntity findName (String nama){
        for (PasienEntity pasien : pasienEntityArrayList){
            if (pasien.getNama().equals(nama)){
                return pasien;
            }
        }
        return null;
    }
    public static boolean login(String nama, String Id){
        PasienEntity pasien = findName(nama);
        if (pasien != null){
            if (pasien.getNama().equals(Id)){
                return  true;
            }
        }
        return false;
    }
    public static ArrayList<PasienEntity> getListPasien() {
        return pasienEntityArrayList;
    }
    public static int editNama(String id, String nama){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setNama(nama);
        return index;
    }
    public static int editTempatTanggalLahit(String id, String tempatTanggalLahir){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setTempatTanggalLahir(tempatTanggalLahir);
        return index;
    }
    public static int editUmur(String id, int umur){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setUmur(umur);
        return index;
    }
    public static int editNomorTelepon(String id, String noTelepon){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setNoTelepon(noTelepon);
        return index;
    }
    public static int editJenisKelamin(String id, char jenisKelamin){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setJenisKelamin(jenisKelamin);
        return index;
    }
    public static int editAlamat(String id, String alamat){
        int index = getIndexPasien(id);
        pasienEntityArrayList.get(index).setAlamat(alamat);
        return index;
    }
    public static boolean removePasien(String id){
        int index = getIndexPasien(id);
        boolean status = false;
        if (index != -1){
            pasienEntityArrayList.remove(index);
            status = true;
        }
        return status;
    }
}
