package controller;

import entity.StaffEntity;
import model.StaffModel;
import java.util.ArrayList;

public class StaffController {
    public int getIndexStaff(String id){
        return StaffModel.getIndexStaff(id);
    }
    public boolean addStaff(StaffEntity staff) {
        return StaffModel.addStaff(staff);
    }

    public boolean login(String nama, String Id){
        return StaffModel.login(nama, Id);
    }
    public ArrayList<StaffEntity> getListStaff() {
        return StaffModel.getListStaff();
    }
    public int editNama(String id, String nama){
        int status = StaffModel.editNama(id, nama);
        return status;
    }
    public int editUsername(String id, String Username){
        int status = StaffModel.editUsername(id, Username);
        return status;
    }
    public int editStaffBagian(String id, String staffBagian){
        int status = StaffModel.editStaffBagian(id,staffBagian);
        return status;
    }

    public boolean removeStaff(String id){
        return StaffModel.removeStaff(id);
    }
}
