package model;

import entity.DokterEntity;
import java.util.ArrayList;

public class DokterModel {
    static ArrayList<DokterEntity> dokterEntityArrayList = new ArrayList<>();
    public static ArrayList<DokterEntity> getListDokter() {
        return dokterEntityArrayList;
    }
    public static boolean addDokter(DokterEntity dokterEntity){
        boolean status = false;
        if (dokterEntity != null){
            dokterEntityArrayList.add(dokterEntity);
            status = true;
        }
        return status;
    }
    public static int getIndexDokter(String nama) {
        int index = -1;
        if (dokterEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong \n");
        } else {
            for (DokterEntity dokter : dokterEntityArrayList) {
                if (dokter.getNama().equals(nama)) {
                    index = dokterEntityArrayList.indexOf(dokter);
                }
            }
        }
        return index;
    }
    public static int editId(String nama, String id){
        int index = getIndexDokter(nama);
        dokterEntityArrayList.get(index).setId(id);
        return index;
    }
    public static int editSpesialis(String nama, String spesialis){
        int index = getIndexDokter(nama);
        dokterEntityArrayList.get(index).setSpesialis(spesialis);
        return index;
    }
    public static boolean removeDokter(String nama){
        int index = getIndexDokter(nama);
        boolean status = false;
        if (index != -1){
            dokterEntityArrayList.remove(index);
            status = true;
        }
        return status;
    }
}
