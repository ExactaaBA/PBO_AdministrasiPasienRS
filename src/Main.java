import view.DokterView;
import java.util.Scanner;
import view.PasienView;

public class Main {
    public static void main(String[] args) {
        DokterView dokter = new DokterView();
        PasienView pasien = new PasienView();

        Main main = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat datang di Rumah sakit");
        int pilih;
        int plh;
        do{
            System.out.println("1. login staff ");
            System.out.println("0. exit");
            System.out.println("pilih :");
            pilih =input.nextInt();
            switch (pilih){
                case 1 :
                    System.out.println("username  :");
                    String Username = input.next();
                    System.out.println("ID        :");
                    String ID= input.next();
                    main.login(Username, ID);

                    do{
                        System.out.println("1. Data Dokter");
                        System.out.println("2. Data Pasien");
                        System.out.println("3. exit");
                        System.out.println("Masukan Pilihan :");
                        plh=input.nextInt();

                        switch (plh){
                            case 1:
                                dokter.DokterMenu();
                            break;
                            case 2:
                                pasien.PasienMenu();
                                break;
                            case 3:
                                System.out.println("---------------");
                                System.out.println("Menu login !!");
                                break;
                        }

                    }while (plh !=3);
            }
        }while (pilih != 0);
        System.out.println(" Semoga Lekas Sembuh ");
    }
    void login (String Username, String id){
        if ((id.equals("123")) && (Username.equals("izzah"))){
            System.out.println("login sukses !!");
            System.out.println(" ");
        }else {
            System.out.println("maaf username dan password salah");
        }
    }
}