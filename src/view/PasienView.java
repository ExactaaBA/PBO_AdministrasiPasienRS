package view;

import controller.PasienController;
import entity.PasienEntity;
import java.util.ArrayList;
import java.util.Scanner;

public class PasienView {
    PasienController pasienController = new PasienController();
    public void PasienMenu(){
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println(" MENU PASIEN ");
            System.out.println(" 1. Create Pasien ");
            System.out.println(" 2. Read Pasien ");
            System.out.println(" 3. Update Pasien ");
            System.out.println(" 4. Delete Pasien ");
            System.out.println(" 5. Keluar ");
            System.out.print("\n Pilih Menu : \n");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1 -> inputPasien();
                case 2 -> viewListPasien();
                case 3 -> updatePasien();
                case 4 -> deleteListPasien();
                case 5 -> System.out.println("Selesai..");
                default -> {
                    System.out.println(" Masukkan Pilihan Dengan Benar ! ");
                    System.out.println("");
                }
            }
        }while (pilihan != 5);
    }
    public void inputPasien() {
        Scanner input = new Scanner(System.in);
        System.out.print(" Masukkan Nama : ");
        String nama = input.nextLine();
        System.out.print(" Masukkan Id : ");
        String id = input.nextLine();
        System.out.print(" Masukkan Tempat Tanggal Lahir : ");
        String tempatTanggalLahir = input.nextLine();
        System.out.print(" Masukkan Alamat : ");
        String alamat = input.nextLine();
        System.out.print(" Masukkan Nomor Telepon : ");
        String noTelepon = input.nextLine();
        System.out.print(" Masukkan Umur : ");
        int umur = input.nextInt();
        System.out.print(" Masukkan Jenis Kelamin : ");
        char jenisKelamin = input.next().charAt(0);
        System.out.println("");
        boolean status = pasienController.addPasien(new PasienEntity(nama,id,tempatTanggalLahir,alamat,noTelepon,umur,jenisKelamin));
        if (status) {
            System.out.println("DATA BERHASIL DITAMBAHKAN");
        } else {
            System.out.println("DATA GAGAL DITAMBAHKAN");
        }
    }
    public void updatePasien() {
        Scanner input = new Scanner(System.in);
        ArrayList<PasienEntity> pasienEntities = pasienController.getListPasien();
        if (pasienEntities.isEmpty()) {
            System.out.println("Data Tidak Ada");
        } else {
            System.out.print(" Masukkan id Yang Ingin Diubah : ");
            String id = input.nextLine();
            int indeks = pasienController.getIndexPasien(id);
            if (indeks != -1) {
                System.out.println("Mana yang diupdate :");
                System.out.println("1. Nama ");
                System.out.println("2. Id ");
                System.out.println("3. Tempat Tanggal Lahir  ");
                System.out.println("4. Alamat ");
                System.out.println("5. Nomor Telepon ");
                System.out.println("6. Umur ");
                System.out.println("7. Jenis Kelamin ");
                System.out.print("Pilih : ");
                int pilih = input.nextInt();
                input.nextLine();
                switch (pilih) {
                    case 1:
                        System.out.print(" Nama Baru : ");
                        String nama = input.nextLine();
                        pasienController.editNama(id, nama);
                        break;
                    case 2:
                        System.out.println(" Data Id Tidak Bisa Diubah ");
                        break;
                    case 3:
                        System.out.println("  Tempat Tanggal Lahir Baru :");
                        String tempatTanggalLahir = input.nextLine();
                        pasienController.editTempatTanggalLahir(id, tempatTanggalLahir);
                        break;
                    case 4:
                        System.out.print(" Alamat Baru : ");
                        String alamat = input.nextLine();
                        pasienController.editAlamat(id, alamat);
                        break;
                    case 5:
                        System.out.print(" Nomor Telepon Baru : ");
                        String noTelepon = input.nextLine();
                        pasienController.editNomorTelepon(id,noTelepon);
                        break;
                    case 6:
                        System.out.print(" Umur Baru : ");
                        int umur = input.nextInt();
                        pasienController.editUmur(id, umur);
                        break;
                    case 7:
                        System.out.print(" Jenis Kelamin Baru : ");
                        char jenisKelamin = input.next().charAt(0);
                        pasienController.editJenisKelamin(id, jenisKelamin);
                        break;
                }
            } else {
                System.out.println("TAMU TIDAK TERDAFTAR");
            }
        }
    }
    public void viewPasien(PasienEntity pasienEntity) {
        if (pasienEntity == null) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            System.out.println(" Nama Anda             : " + pasienEntity.getNama());
            System.out.println(" Id Anda               : " + pasienEntity.getId());
            System.out.println(" Tempat Tanggal Lahir  : " + pasienEntity.getTempatTanggalLahir());
            System.out.println(" Alamat Anda           : " +pasienEntity.getAlamat());
            System.out.println(" Nomor Telepon Anda    : " + pasienEntity.getNoTelepon());
            System.out.println(" Umur Anda             : " + pasienEntity.getUmur());
            System.out.println(" Jenis Kelamin Anda    : " + pasienEntity.getJenisKelamin());
            System.out.println("");
        }
    }
    public void viewListPasien() {
        ArrayList<PasienEntity> pasienEntityArrayList = pasienController.getListPasien();
        if (pasienEntityArrayList.isEmpty()) {
            System.out.println(" Data Kosong ");
            System.out.println("");
        } else {
            for (PasienEntity pasienEntity : pasienEntityArrayList) {
                viewPasien(pasienEntity);
            }
        }
    }
    public void deleteListPasien() {
        ArrayList<PasienEntity> pasienEntityArrayList = pasienController.getListPasien();
        Scanner input = new Scanner(System.in);
        System.out.println(" Masukkan id Yang Ingin Di Hapus : ");
        String id = input.nextLine();
        int index = pasienController.getIndexPasien(id);
        if (index == -1) {
            System.out.println(" Username Tidak Di Temukan ");
        } else {
            System.out.println(" Apakah Yakin Data Pasien " + pasienEntityArrayList.get(index).getId().toUpperCase() + " Ingin Di Hapus (Y/N) : ");
            char kofirmasi = input.next().charAt(0);
            if (kofirmasi == 'y' || kofirmasi == 'Y') {
                pasienController.removePasien(id);
                viewListPasien();
            } else {
                System.out.println(" Data Tidak Jadi Di Hapus ");
            }
        }
    }
}



