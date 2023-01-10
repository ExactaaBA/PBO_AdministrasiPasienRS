package model;

import entity.StaffEntity;
import java.util.ArrayList;

public class StaffModel {
    static ArrayList<StaffEntity> staffEntityArrayList = new ArrayList<>();
    public static int getIndexStaff(String id) {
        int index = -1;
        if (staffEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong \n");
        } else {
            for (StaffEntity staff: staffEntityArrayList) {
                if (staff.getId().equals(id)) {
                    index = staffEntityArrayList.indexOf(staff);
                }
            }
        }
        return index;
    }
    public static boolean addStaff(StaffEntity staffEntity){
        boolean status = false;
        if (staffEntity != null){
            staffEntityArrayList.add(staffEntity);
            status = true;
        }
        return status;
    }
    public static StaffEntity findName (String nama){
        for (StaffEntity staff : staffEntityArrayList){
            if (staff.getNama().equals(nama)){
                return staff;
            }
        }
        return null;
    }
    public static boolean login(String nama, String Id){
        StaffEntity staff = findName(nama);
        if (staff != null){
            if (staff.getNama().equals(Id)){
                return  true;
            }
        }
        return false;
    }
    public static ArrayList<StaffEntity> getListStaff() {
        return staffEntityArrayList;
    }
    public static int editNama(String id, String nama){
        int index = getIndexStaff(id);
        staffEntityArrayList.get(index).setNama(nama);
        return index;
    }
    public static int editStaffBagian(String id, String StaffBagian){
        int index = getIndexStaff(id);
        staffEntityArrayList.get(index).setStaffbagian(StaffBagian);
        return index;
    }
    public static int editUsername(String id, String Username){
        int index = getIndexStaff(id);
        staffEntityArrayList.get(index).setUsername(Username);
        return index;
    }

    public static boolean removeStaff(String id){
        int index = getIndexStaff(id);
        boolean status = false;
        if (index != -1){
            staffEntityArrayList.remove(index);
            status = true;
        }
        return status;
    }
}
