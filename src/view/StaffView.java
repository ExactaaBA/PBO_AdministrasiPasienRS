package view;

import controller.StaffController;
import entity.StaffEntity;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffView {
    StaffController staffController = new StaffController();
    public void StaffMenu(){
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println(" STAFF");
            System.out.println(" 1. Create Staff ");
            System.out.println(" 2. Read Staff ");
            System.out.println(" 3. Update Staff ");
            System.out.println(" 4. Delete Staff ");
            System.out.println(" 5. Keluar ");
            System.out.print("\n Pilih Menu : \n");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1 -> inputStaff();
                case 2 -> viewListStaff();
                case 3 -> updateStaff();
                case 4 -> deleteListStaff();
                case 5 -> System.out.println("Selesai..");
                default -> {
                    System.out.println(" Masukkan Pilihan Dengan Benar ! ");
                    System.out.println("");
                }
            }
        }while (pilihan != 5);
    }
    public void inputStaff() {
        Scanner input = new Scanner(System.in);
        System.out.print("  Nama staff  : ");
        String nama = input.nextLine();
        System.out.println(" Username   : ");
        String username = input.nextLine();
        System.out.print(" Id           : ");
        String id = input.nextLine();
        System.out.print(" Staff bagian : ");
        String Staffbagian = input.nextLine();
        System.out.println("");
        boolean status = staffController.addStaff(new StaffEntity());
        if (status) {
            System.out.println("DATA BERHASIL DITAMBAHKAN");
        } else {
            System.out.println("DATA GAGAL DITAMBAHKAN");
        }
    }
    public void updateStaff() {
        Scanner input = new Scanner(System.in);
        ArrayList<StaffEntity> staffEntities = staffController.getListStaff();
        if (staffEntities.isEmpty()) {
            System.out.println("Data Tidak Ada");
        } else {
            System.out.print(" Masukkan id Yang Ingin Diubah : ");
            String id = input.nextLine();
            int indeks = staffController.getIndexStaff(id);
            if (indeks != -1) {
                System.out.println("Mana yang diupdate :");
                System.out.println("1. Nama ");
                System.out.println("2. Username ");
                System.out.println("3. id  ");
                System.out.println("4. Staff Bagian ");
                System.out.print("Pilih : ");
                int pilih = input.nextInt();
                input.nextLine();
                switch (pilih) {
                    case 1:
                        System.out.print(" Nama Baru  : ");
                        String nama = input.nextLine();
                        staffController.editNama(id, nama);
                        break;
                    case 2:
                        System.out.println(" Username Baru :");
                        String Username = input.nextLine();
                        staffController.editUsername(id, Username);

                        case 3:
                        System.out.println(" Data Id Tidak Bisa Diubah ");
                        break;

                    case 4:
                        System.out.print(" Staff bagian Baru : ");
                        String Bagian = input.nextLine();
                        staffController.editStaffBagian(id, Bagian);
                }
            } else {
                System.out.println("Staff TIDAK TERDAFTAR");
            }
        }
    }
    public void viewStaff(StaffEntity staffEntity) {
        if (staffEntity == null) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            System.out.println(" Nama staff            : " + staffEntity.getNama());
            System.out.println(" Username              : " + staffEntity.getUsername());
            System.out.println(" Id                    : " + staffEntity.getId());
            System.out.println(" Staff Bagian          : " + staffEntity.getStaffbagian());
            System.out.println("");
        }
    }
    public void viewListStaff() {
        ArrayList<StaffEntity> staffEntityArrayList = staffController.getListStaff();
        if (staffEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            for (StaffEntity staffEntity : staffEntityArrayList) {
                viewStaff(staffEntity);
            }
        }
    }
    public void deleteListStaff() {
        ArrayList<StaffEntity> staffEntityArrayList = staffController.getListStaff();
        Scanner input = new Scanner(System.in);
        System.out.println(" Masukkan id Yang Ingin Di Hapus : ");
        String id = input.nextLine();
        int index = staffController.getIndexStaff(id);
        if (index == -1) {
            System.out.println(" Username Tidak Di Temukan ");
        } else {
            System.out.println(" Apakah Yakin Data Pasien " + staffEntityArrayList.get(index).getId().toUpperCase() + " Ingin Di Hapus (Y/N) : ");
            char kofirmasi = input.next().charAt(0);
            if (kofirmasi == 'y' || kofirmasi == 'Y') {
                staffController.removeStaff(id);
                viewListStaff();
            } else {
                System.out.println(" Data Tidak Jadi Di Hapus ");
            }
        }
    }
}


