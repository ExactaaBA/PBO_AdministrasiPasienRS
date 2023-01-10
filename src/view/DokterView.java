package view;

import controller.DokterController;
import entity.DokterEntity;
import java.util.ArrayList;
import java.util.Scanner;

public class DokterView implements ViewInterface{
    DokterController dokterController = new DokterController();
    public void DokterMenu(){
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println(" MENU DOKTER ");
            System.out.println(" 1. Create Dokter ");
            System.out.println(" 2. Read Dokter ");
            System.out.println(" 3. Update Dokter ");
            System.out.println(" 4. Delete Dokter ");
            System.out.println(" 5. Keluar ");
            System.out.print("\n Pilih Menu : \n");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1 -> inputDokter();
                case 2 -> viewListDokter();
                case 3 -> updateDokter();
                case 4 -> deleteListDokter();
                case 5 -> System.out.println("Selesai..");
                default -> {
                    System.out.println(" Masukkan Pilihan Dengan Benar ! ");
                    System.out.println("");
                }
            }
        }while (pilihan != 5);
    }
public void inputDokter(){
    System.out.println("=== MENU INSERT ===");
    Scanner scan = new Scanner(System.in);
    String id = "";
    String nama = "", spesialis = "";
    try{
        System.out.print("masukkan nama kasir : ");
        nama = scan.next();
        System.out.print("masukkan id kasir : ");
        id= scan.next();
        System.out.print("masukkan spesialis : ");
        spesialis = scan.next();

        DokterController obj = new DokterController();
        obj.addDokter(new DokterEntity(nama, id , spesialis ));

        System.out.println("data berhasil masuk");
    } catch (Exception e) {
        System.out.println(e);
        System.out.printf("data gagal dimasukkan");
    }
}
    @Override
    public void viewDokter() {

    }
    public void viewDokter(DokterEntity dokterEntity) {
        if (dokterEntity == null) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            System.out.println(" Nama Anda       : " + dokterEntity.getNama());
            System.out.println(" Id Anda         : " + dokterEntity.getId());
            System.out.println(" Poli Spesialis  : "+dokterEntity.getSpesialis());
            System.out.println("");
        }
    }
    public void viewListDokter() {
        ArrayList<DokterEntity> dokterEntityArrayList = dokterController.getListDokter();
        if (dokterEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            for (DokterEntity dokterEntity : dokterEntityArrayList) {
                viewDokter(dokterEntity);
            }
        }
    }
    public void updateDokter() {
        Scanner input = new Scanner(System.in);
        ArrayList<DokterEntity> dokterEntities = dokterController.getListDokter();
        if (dokterEntities.isEmpty()) {
            System.out.println("Data Tidak Ada");
        } else {
            System.out.print(" Masukkan Nama Yang Ingin Diubah : ");
            String nama = input.nextLine();
            int indeks = dokterController.getIndexDokter(nama);
            if (indeks != -1) {
                System.out.println(" Mana yang diupdate :");
                System.out.println("1. Nama ");
                System.out.println("2. Id ");
                System.out.println("3. Spesialis ");
                System.out.print("Pilih : ");
                int pilih = input.nextInt();
                input.nextLine();
                switch (pilih) {
                    case 1:
                        System.out.println(" Data Nama Tidak Bisa Diubah ");
                        break;
                    case 2:
                        System.out.print(" Nomor Id Baru : ");
                        String id = input.nextLine();
                        dokterController.editId(nama, id);
                        break;

                    case 3:
                        System.out.print(" Poli Spesialis Baru : ");
                        String spesialis = input.nextLine();
                        dokterController.editSpesialis(nama, spesialis);
                }
            } else {
                System.out.println("TAMU TIDAK TERDAFTAR");
            }
        }
    }
    public void deleteListDokter() {
        ArrayList<DokterEntity> dokterEntityArrayList = dokterController.getListDokter();
        Scanner input = new Scanner(System.in);
        System.out.println(" Masukkan nama Yang Ingin Di Hapus : ");
        String nama = input.nextLine();
        int index = dokterController.getIndexDokter(nama);
        if (index == -1) {
            System.out.println(" Nama Tidak Di Temukan ");
        } else {
            System.out.println(" Apakah Yakin Data Dokter " + dokterEntityArrayList.get(index).getNama().toUpperCase() + " Ingin Di Hapus (Y/N) : ");
            char kofirmasi = input.next().charAt(0);
            if (kofirmasi == 'y' || kofirmasi == 'Y') {
                dokterController.removeDokter(nama);
                viewListDokter();
            } else {
                System.out.println(" Data Tidak Jadi Di Hapus ");
            }
        }
    }

}
