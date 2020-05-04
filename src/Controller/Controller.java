/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
        
import Application.Application;

/**
 *
 * @author ASUS
 */
public class Controller {
    private Application app = new Application();
    Person user;
    String role;

    public Controller() throws IOException {
        mainApp();
    }
    
    public void mainApp() throws IOException{
        String role = "";  
        Scanner input = new Scanner(System.in);
        System.out.println("=============== Login ================");
        System.out.println("ketik 'exit' atau 'keluar' untuk keluar.");
        System.out.println("");
        System.out.print("Masukkan NIK : ");
        String nik = input.nextLine();
        if ((nik.equals("exit")) || (nik.equals("keluar"))) System.exit(0);
        String temp1 = app.getNikPemilih(nik);
        System.out.println(temp1);
        if (nik.equals("admin")) {
            clrscr();
            menuAdmin();            
        } else if (nik.equals(app.getNikPemilih(nik))) {
            clrscr();
            role = "pemilih";
            user = app.getPemilih(nik);
            menuUser(role);    
        } else if (nik.equals(app.getNikPetugas(nik))) {
            clrscr();
            role = "petugas";
            user = app.getPetugas(nik);
            menuUser(role);          
        } else if (nik.equals(app.getNikKandidat(nik))) {
            clrscr();
            role = "kandidat";
            user = app.getKandidat(nik);
            menuUser(role);       
        } else {
            System.out.println("NIK tidak terdaftar!");
            mainApp();
        }
    }
    
    public void clrscr(){
        for(int clear = 0; clear < 5; clear++) System.out.println("\b") ;
    }     
    public void menuAdmin() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("==== Selamat datang di menu admin ====");
        System.out.println("=   1. Pemilih                       =");
        System.out.println("=   2. Petugas                       =");
        System.out.println("=   3. Kandidat                      =");
        System.out.println("=   4. TPS                           =");
        System.out.println("=   5. Assign Petugas TPS            =");
        System.out.println("=   6. Add Pemilih ke TPS            =");
        System.out.println("=   7. Rekap Hasil Pemilu            =");
        System.out.println("=                                    =");
        System.out.println("=   9. Logout                        =");
        System.out.println("=   0. Exit                          =");
        System.out.println("======================================");
        System.out.print("Pilihan anda : ");
        String pil = input.nextLine();
        
        switch(pil){
            case "1":
                clrscr();
                menuPemilih();
            case "2":
                clrscr();
                menuPetugas();
            case "3":
                clrscr();
                menuKandidat();
            case "4":
                clrscr();
                menuTPS();
            case "5":
                clrscr();
                ArrayList<Petugas> arr = app.getDaftarPetugas();
                System.out.println("========= Assign Petugas TPS =========");   
                for(Petugas x: arr){
                    System.out.println("   Petugas : " + x.getNoPetugas());
                    System.out.println("      Nama           : " + x.getNama());
                    System.out.println("      Nomor TPS      : " + x.getNomorTPS());
                    System.out.println("      Jabatan        : " + x.getJabatan());
                } System.out.println("");
                assignPetugas();
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil2 = input.nextLine();
                switch (pil2){ default: clrscr(); menuAdmin(); }
            case "6":
                clrscr();
                ArrayList<Pemilih> arrp = app.getDaftarPemilih();
                System.out.println("========== Assign DPT TPS ============");   
                for(Pemilih x: arrp){
                    System.out.println("   Pemilih : " + x.getNoPemilih());
                    System.out.println("      Nama           : " + x.getNama());
                    System.out.println("      Nomor TPS      : " + x.getNomorTps());
                    System.out.println("      Status Pilih   : " + x.getStatusPilih());
                } System.out.println("");
                assignPemilih();
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil3 = input.nextLine();
                switch (pil3){ default: clrscr(); menuAdmin(); }
            case "7":
                clrscr();
                    System.out.println("=========== Hasil Pemilu ==============");
                    seeResult();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil4 = input.nextLine();
                    switch (pil4){ default: clrscr(); menuAdmin(); }
            case "9":
                clrscr();
                mainApp();
                
            case "0":
                System.exit(0);
                
            default: 
                break;
        }
    }
    public void menuUser(String role) throws IOException{
        Scanner input = new Scanner(System.in);
        if (role.equals("pemilih")) {
            ArrayList<Pemilih> arr = app.getDaftarPemilih();
            Pemilih pem = null;
            for(Pemilih x: arr){
                if(x.getNik().equals(user.getNik())) {pem = x; break;} 
            }
            System.out.println("   Selamat datang, " + user.getNama());
            System.out.println("      1. Mulai Vote                 ");
            System.out.println("      2. Lihat Kandidat & Program   ");
            System.out.println("      3. Lihat Data Diri            ");
            System.out.println("      4. Ajukan Pindah TPS          ");
            System.out.println("      5. Lihat Hasil Pemilu         ");
            System.out.println("                                    ");
            System.out.println("      9. Logout                     ");
            System.out.println("      0. Exit                       ");
            System.out.println("                                    ");
            System.out.print("Pilihan anda : ");
            String pil = input.nextLine();
            switch(pil){
                case "1":
                    clrscr();
                    System.out.println("========== Mulai Pemilihan ===========");
                    beginVote(pem);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil1 = input.nextLine();
                    switch (pil1){ default: clrscr(); menuUser(role); }                 
                case "2":
                    clrscr();                    
                    System.out.println("========== Lihat Kandidat ============");
                    viewKandidat();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil2 = input.nextLine();
                    switch (pil2){ default: clrscr(); menuUser(role); }                    
                case "3":
                    clrscr();
                    System.out.println("============= Data Diri ==============");
                    viewDataDiri(pem);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil3 = input.nextLine();
                    switch (pil3){ default: clrscr(); menuUser(role); }
                case "4":
                    clrscr();
                    System.out.println("======= Permohonan Pindah TPS ========");
                    listTPS(); pindahTPS(pem);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil4 = input.nextLine();
                    switch (pil4){ default: clrscr(); menuUser(role); }
                case "5":
                    clrscr();
                    System.out.println("=========== Hasil Pemilu ==============");
                    seeResult();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil5 = input.nextLine();
                    switch (pil5){ default: clrscr(); menuUser(role); }
                case "9":
                    clrscr();
                    mainApp();
                case "0":
                    System.exit(0);
                default: 
                    break;
            }
        } else if (role.equals("petugas")){
            System.out.println("   Selamat datang, " + user.getNama());
            System.out.println("      1. Lihat Pengajuan Pindah TPS        ");
            System.out.println("      2. Verifikasi Pengajuan Pindah TPS   ");
            System.out.println("      3. Lihat Hasil Pemilu         ");
            System.out.println("                                    ");
            System.out.println("      9. Logout                     ");
            System.out.println("      0. Exit                       ");
            System.out.println("                                    ");
            System.out.print("Pilihan anda : ");
            String pil = input.nextLine();
            switch(pil){
                case "1":
                    clrscr();
                    System.out.println("===== Data Permohonan Pindah TPS =====");
                    viewPindahTPS();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil3 = input.nextLine();
                    switch (pil3){ default: clrscr(); menuUser(role); }
                case "2":
                    clrscr();
                    System.out.println("===== Data Permohonan Pindah TPS =====");
                    viewPindahTPS(); System.out.println("");
                    verifyPindahTPS();                    
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil4 = input.nextLine();
                    switch (pil4){ default: clrscr(); menuUser(role); }
                case "3":
                    clrscr();
                    System.out.println("=========== Hasil Pemilu ==============");
                    seeResult();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil5 = input.nextLine();
                    switch (pil5){ default: clrscr(); menuUser(role); }
                case "9":
                    clrscr();
                    mainApp();

                case "0":
                    System.exit(0);
                default: 
                    break;
            }
        } else if (role.equals("kandidat")){
            ArrayList<Kandidat> arr = app.getDaftarKandidat();
            Kandidat k = null;
            for(Kandidat x: arr){
                if(x.getNik().equals(user.getNik())) {k = x; break;} 
            }
            System.out.println("   Selamat datang, " + user.getNama());
            System.out.println("      1. Lihat Program              ");
            System.out.println("      2. Tambah Program             ");
            System.out.println("      3. Edit Program               ");
            System.out.println("      4. Hapus Program              ");
            System.out.println("      5. Lihat Hasil Pemilu         ");
            System.out.println("                                    ");
            System.out.println("      9. Logout                     ");
            System.out.println("      0. Exit                       ");
            System.out.println("                                    ");
            System.out.print("Pilihan anda : ");
            String pil = input.nextLine();
            switch(pil){
                case "1":
                    clrscr();
                    System.out.println("=========== Lihat Program ============");
                    viewProgram(k);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil1 = input.nextLine();
                    switch (pil1){ default: clrscr(); menuUser(role); }                    
                case "2":
                    clrscr();
                    System.out.println("========== Tambah Program ============");
                    addProgram(k);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil2 = input.nextLine();
                    switch (pil2){ default: clrscr(); menuUser(role); }              
                case "3":
                    clrscr();
                    System.out.println("=========== Edit Program =============");
                    viewProgram(k); editProgram(k);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil3 = input.nextLine();
                    switch (pil3){ default: clrscr(); menuUser(role); }              
                case "4":
                    clrscr();
                    System.out.println("========== Hapus Program =============");
                    viewProgram(k); deleteProgram(k);
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil4 = input.nextLine();
                    switch (pil4){ default: clrscr(); menuUser(role); }              
                case "5":
                    clrscr();
                    System.out.println("=========== Hasil Pemilu ==============");
                    seeResult();
                    System.out.println("");
                    System.out.println("=   Tekan enter untuk kembali        =");
                    String pil5 = input.nextLine();
                    switch (pil5){ default: clrscr(); menuUser(role); } 
                case "9":
                    clrscr();
                    mainApp();
                case "0":
                    System.exit(0);
                default: 
                    break;
            }
        }
    }
    public void seeResult(){
        ArrayList<Pemilihan> arr = app.getDaftarPemilihan();
        int totalVote = arr.size();
        if (totalVote != 0) {
            int a = 0, b = 0, c = 0, d = 0;
            for(Pemilihan x: arr){
                if (x.getKandidat().getNoKandidat() == 1) {
                    a++;
                } else if (x.getKandidat().getNoKandidat() == 2) {
                    b++;
                } else if (x.getKandidat().getNoKandidat() == 3) {
                    c++;
                } else if (x.getKandidat().getNoKandidat() == 4) {
                    d++;
                }
            }
            a = (a/totalVote) * 100;
            b = (b/totalVote) * 100;
            c = (c/totalVote) * 100;
            d = (d/totalVote) * 100;
            System.out.println("   Total Suara : " + totalVote);
            System.out.println("      Kandidat 1 : " + a +"%");
            System.out.println("      Kandidat 2 : " + b +"%");
            System.out.println("      Kandidat 3 : " + c +"%");
            System.out.println("      Kandidat 4 : " + d +"%");
        } else {
            System.out.println("Belum ada pemilihan");
        }            
    }
  
    //MENU APP ADMIN
    public void showArr(int a){
        if (a == 1) {
            ArrayList<Pemilih> arr = app.getDaftarPemilih();
            for(Pemilih x: arr){
                System.out.println("   Pemilih : " + x.getNoPemilih());
                System.out.println("      NIK            : " + x.getNik());
                System.out.println("      Nama           : " + x.getNama());
                System.out.println("      Tanggal Lahir  : " + x.getTanggalLahir());
                System.out.println("      Jenis Kelamin  : " + x.getJenisKelamin());
                System.out.println("      Nomor TPS      : " + x.getNomorTps());
                System.out.println("      Status Pilih   : " + x.getStatusPilih());
            }
        } else if (a == 2) {
            ArrayList<Petugas> arr = app.getDaftarPetugas();
            for(Petugas x: arr){
                System.out.println("   Petugas : " + x.getNoPetugas());
                System.out.println("      NIK            : " + x.getNik());
                System.out.println("      Nama           : " + x.getNama());
                System.out.println("      Tanggal Lahir  : " + x.getTanggalLahir());
                System.out.println("      Jenis Kelamin  : " + x.getJenisKelamin());
                System.out.println("      Nomor TPS      : " + x.getNomorTPS());
                System.out.println("      Jabatan        : " + x.getJabatan());
                System.out.println("      Status Pilih   : " + x.getStatusPilih());
            }
        } else if (a == 3) {
            ArrayList<Kandidat> arr = app.getDaftarKandidat();
            for(Kandidat x: arr){
                ArrayList<Program> arrProg = x.getDaftarProgram();
                System.out.println("   Kandidat : " + x.getNoKandidat());
                System.out.println("      NIK            : " + x.getNik());
                System.out.println("      Nama           : " + x.getNama());
                System.out.println("      Tanggal Lahir  : " + x.getTanggalLahir());
                System.out.println("      Jenis Kelamin  : " + x.getJenisKelamin());
                System.out.println("      Status Pilih   : " + x.getStatusPilih());
                System.out.println("      Program        : ");
                for(Program y: arrProg){
                    System.out.println("         " + y.getNoProgram() +". "+y.getIsiProgram());
                }
            }
        } else if (a == 4) {
            ArrayList<TPS> arr = app.getDaftarTPS();
            for(TPS x: arr){
                ArrayList<Pemilih> DPT = x.getDPT(); int i = 1;
                ArrayList<Petugas> PPS = x.getDaftarPPS(); int j = 1;
                System.out.println("   TPS : " + x.getNomorTPS());
                System.out.println("      Tempat TPS    : " + x.getTempatTPS());
                System.out.println("      Jumlah DPT    : " + x.getJumlahDPT());
                System.out.println("      Status Penuh  : " + x.getStatusPenuh());
                for(Pemilih y: DPT){
                    System.out.println("      DPT : ");
                    System.out.println("       " + i + ". " + "NIK  :" + y.getNik());
                    System.out.println("          Nama :" + y.getNama());
                    i++;
                }
                for(Petugas z: PPS){
                    System.out.println("      PPS : ");
                    System.out.println("       " + j + ". " + "NIK  :" + z.getNik());
                    System.out.println("          Nama :" + z.getNama());
                    j++;
                }
            }
        }
    }
    public void listTPS(){
        ArrayList<TPS> arr = app.getDaftarTPS();
        for(TPS x: arr){    
            System.out.println("   TPS : " + x.getNomorTPS());
            System.out.println("      Tempat TPS    : " + x.getTempatTPS());
            System.out.println("      Status Penuh  : " + x.getStatusPenuh());
        }
    }
    public void addPerson(int a){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor                    : ");
        int no = input.nextInt();
        String x = input.nextLine();
        System.out.print("   NIK                      : ");
        String nik = input.nextLine();
        System.out.print("   Nama                     : ");
        String nama = input.nextLine();
        System.out.print("   Tanggal Lahir (HHBBTTTT) : ");
        String ttl = input.nextLine();
        System.out.print("   Jenis Kelamin            : ");
        String jk = input.nextLine();
        if (a == 1){
            try {
                Pemilih p = new Pemilih(no,nik,ttl,nama,jk);
                app.inputPemilih(p);
                System.out.println("Data berhasil ditambahkan.");
            } catch(Exception e){
                System.out.println("Data gagal ditambahkan.");
            }    
        } else if (a == 2){
            try {
                Petugas p = new Petugas(no,nik,ttl,nama,jk);
                app.inputPetugas(p);
                System.out.println("Data berhasil ditambahkan.");
            } catch(Exception e){
                System.out.println("Data gagal ditambahkan.");
            }
        } else if (a == 3){
            try {
                Kandidat p = new Kandidat(no,nik,ttl,nama,jk);
                app.inputKandidat(p);
                System.out.println("Data berhasil ditambahkan.");
            } catch(Exception e){
                System.out.println("Data gagal ditambahkan.");
            }
        }
    }
    
    public void menuPemilih() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("============ Menu Pemilih ============");
        System.out.println("=   1. Lihat Pemilih                 =");
        System.out.println("=   2. Tambah Pemilih                =");
        System.out.println("=   3. Edit Pemilih                  =");
        System.out.println("=   4. Hapus Pemilih                 =");
        System.out.println("=                                    =");
        System.out.println("=   9. Kembali                       =");
        System.out.println("=   0. Exit                          =");
        System.out.println("======================================");
        System.out.print("Pilihan anda : ");
        String pil = input.nextLine();
        
        switch(pil){
            case "1":
                clrscr();
                System.out.println("=========== Lihat Pemilih ============");
                showArr(1);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil1 = input.nextLine();
                switch (pil1){ default: clrscr(); menuPemilih(); }
                
            case "2":
                clrscr();
                System.out.println("=========== Tambah Pemilih ===========");
                addPerson(1);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil2 = input.nextLine();
                switch (pil2){ default: clrscr(); menuPemilih(); }

            case "3":
                clrscr();
                System.out.println("============ Edit Pemilih ============");
                showArr(1); System.out.println("");
                editPemilih(); System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil3 = input.nextLine();
                switch (pil3){ default: clrscr(); menuPemilih(); }
                
            case "4":
                clrscr();
                System.out.println("=========== Hapus Pemilih ============");
                showArr(1); hapusPemilih();
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil4 = input.nextLine();
                switch (pil4){ default: clrscr(); menuPemilih(); }
                
            case "9":
                clrscr();
                menuAdmin();
                
            case "0":
                System.exit(0);
        }
    }    
    public void editPemilih(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Pemilih yang ingin diupdate : ");
        int no = input.nextInt();
   
        if (!app.isNoPemilihExist(no)) {            
            System.out.println("Nomor Pemilih tidak ada.");
            editPemilih();
        }
        
        String x = input.nextLine();
        System.out.print("   No Pemilih               : ");
        int nom = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   NIK                      : ");
        String nik = input.nextLine();
        System.out.print("   Nama                     : ");
        String nama = input.nextLine();
        System.out.print("   Tanggal Lahir (HHBBTTTT) : ");
        String ttl = input.nextLine();
        System.out.print("   Jenis Kelamin            : ");
        String jk = input.nextLine();
        
        try {
            Pemilih p = new Pemilih(nom,nik,ttl,nama,jk);
            app.editPemilih(no, p);
            System.out.println("Data berhasil diupdate.");
        } catch(Exception e){
            System.out.println("Data gagal diupdate.");
        }
    }    
    public void hapusPemilih(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Pemilih yang ingin dihapus : ");
        int no = input.nextInt();
   
        if (!app.isNoPemilihExist(no)) {            
            System.out.println("Nomor Pemilih tidak ada.");
            hapusPemilih();
        }
        String x = input.nextLine();
        try {
            app.hapusPemilih(no);
            System.out.println("Data berhasil dihapus.");
        } catch(Exception e){
            System.out.println("Data gagal dihapus.");
        }    
    }
    
    public void menuPetugas() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("============ Menu Petugas ============");
        System.out.println("=   1. Lihat Petugas                 =");
        System.out.println("=   2. Tambah Petugas                =");
        System.out.println("=   3. Edit Petugas                  =");
        System.out.println("=   4. Hapus Petugas                 =");
        System.out.println("=                                    =");
        System.out.println("=   9. Kembali                       =");
        System.out.println("=   0. Exit                          =");
        System.out.println("======================================");
        System.out.print("Pilihan anda : ");
        String pil = input.nextLine();
        
        switch(pil){
            case "1":
                clrscr();
                System.out.println("=========== Lihat Petugas ============");
                showArr(2);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil1 = input.nextLine();
                switch (pil1){ default: clrscr(); menuPetugas(); }
                
            case "2":
                clrscr();
                System.out.println("=========== Tambah Petugas ===========");
                addPerson(2);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil2 = input.nextLine();
                switch (pil2){ default: clrscr(); menuPetugas(); }

            case "3":
                clrscr();
                System.out.println("============ Edit Petugas ============");
                showArr(2); System.out.println("");
                editPetugas(); System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil3 = input.nextLine();
                switch (pil3){ default: clrscr(); menuPetugas(); }
                
            case "4":
                clrscr();
                System.out.println("=========== Hapus Petugas ============");
                showArr(2); hapusPetugas();
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil4 = input.nextLine();
                switch (pil4){ default: clrscr(); menuPetugas(); }
                
            case "9":
                clrscr();
                menuAdmin();
            case "0":
                System.exit(0);
        }
    }    
    public void editPetugas(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Petugas yang ingin diupdate : ");
        int no = input.nextInt();
   
        if (!app.isNoPetugasExist(no)) {            
            System.out.println("Nomor Petugas tidak ada.");
            editPetugas();
        }
        
        String x = input.nextLine();
        System.out.print("   No Petugas               : ");
        int nom = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   NIK                      : ");
        String nik = input.nextLine();
        System.out.print("   Nama                     : ");
        String nama = input.nextLine();
        System.out.print("   Tanggal Lahir (HHBBTTTT) : ");
        String ttl = input.nextLine();
        System.out.print("   Jenis Kelamin            : ");
        String jk = input.nextLine();
        try {
            Petugas p = new Petugas(nom,nik,ttl,nama,jk);
            app.editPetugas(no, p);
            System.out.println("Data berhasil diupdate.");
        } catch(Exception e){
            System.out.println("Data gagal diupdate.");
        }
    }    
    public void hapusPetugas(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Petugas yang ingin dihapus : ");
        int no = input.nextInt();
   
        if (!app.isNoPetugasExist(no)) {            
            System.out.println("Nomor Petugas tidak ada.");
            hapusPetugas();
        }
        String x = input.nextLine();
        try {
            app.hapusPetugas(no);
            System.out.println("Data berhasil dihapus.");
        } catch(Exception e){
            System.out.println("Data gagal dihapus.");
        }
    }
    
    public void menuKandidat() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("=========== Menu Kandidat ============");
        System.out.println("=   1. Lihat Kandidat                =");
        System.out.println("=   2. Tambah kandidat               =");
        System.out.println("=   3. Edit Kandidat                 =");
        System.out.println("=   4. Hapus Kandidat                 =");
        System.out.println("=                                    =");
        System.out.println("=   9. Kembali                       =");
        System.out.println("=   0. Exit                          =");
        System.out.println("======================================");
        System.out.print("Pilihan anda : ");
        String pil = input.nextLine();
        
        switch(pil){
            case "1":
                clrscr();
                System.out.println("========== Lihat Kandidat ============");
                showArr(3);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil1 = input.nextLine();
                switch (pil1){ default: clrscr(); menuKandidat(); }
                
            case "2":
                clrscr();
                System.out.println("========== Tambah Kandidat ===========");
                addPerson(3);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil2 = input.nextLine();
                switch (pil2){ default: clrscr(); menuKandidat(); }

            case "3":
                clrscr();
                System.out.println("=========== Edit Kandidat ============");
                showArr(3); System.out.println("");
                editKandidat(); System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil3 = input.nextLine();
                switch (pil3){ default: clrscr(); menuKandidat(); }
                
            case "4":
                clrscr();
                System.out.println("========== Hapus Kandidat ============");
                showArr(3); hapusKandidat();
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil4 = input.nextLine();
                switch (pil4){ default: clrscr(); menuKandidat(); }
                
            case "9":
                clrscr();
                menuAdmin();
            case "0":
                System.exit(0);
        }
    }
    public void editKandidat() {
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Kandidat yang ingin diupdate : ");
        int no = input.nextInt();
   
        if (!app.isNoKandidatExist(no)) {            
            System.out.println("Nomor Kandidat tidak ada.");
            editKandidat();
        }
        
        String x = input.nextLine();
        System.out.print("   No Kandidat              : ");
        int nom = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   NIK                      : ");
        String nik = input.nextLine();
        System.out.print("   Nama                     : ");
        String nama = input.nextLine();
        System.out.print("   Tanggal Lahir (HHBBTTTT) : ");
        String ttl = input.nextLine();
        System.out.print("   Jenis Kelamin            : ");
        String jk = input.nextLine();
        try {
            Kandidat p = new Kandidat(nom,nik,ttl,nama,jk);
            app.editKandidat(no, p);
            System.out.println("Data berhasil diupdate.");
        } catch(Exception e){
            System.out.println("Data gagal diupdate.");
        }
    }
    public void hapusKandidat() {
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Kandidat yang ingin dihapus : ");
        int no = input.nextInt();
   
        if (!app.isNoKandidatExist(no)) {            
            System.out.println("Nomor Kandidat tidak ada.");
            hapusKandidat();
        }
        String x = input.nextLine();
        try {
            app.hapusKandidat(no);
            System.out.println("Data berhasil dihapus.");
        } catch(Exception e){
            System.out.println("Data gagal dihapus.");
        }
    }
     
    public void menuTPS() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("============== Menu TPS ==============");
        System.out.println("=   1. Lihat TPS                     =");
        System.out.println("=   2. Tambah TPS                    =");
        System.out.println("=   3. Edit TPS                      =");
        System.out.println("=   4. Hapus TPS                     =");
        System.out.println("=                                    =");
        System.out.println("=   9. Kembali                       =");
        System.out.println("=   0. Exit                          =");
        System.out.println("======================================");
        System.out.print("Pilihan anda : ");
        String pil = input.nextLine();
        
        switch(pil){
            case "1":
                clrscr();
                System.out.println("============= Lihat TPS ==============");
                showArr(4);
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil1 = input.nextLine();
                switch (pil1){ default: clrscr(); menuTPS(); }
                
            case "2":
                clrscr();
                System.out.println("============= Tambah TPS =============");
                addTPS();
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil2 = input.nextLine();
                switch (pil2){ default: clrscr(); menuTPS(); }

            case "3":
                clrscr();
                System.out.println("============== Edit TPS ==============");
                showArr(4); System.out.println("");
                editTPS(); System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil3 = input.nextLine();
                switch (pil3){ default: clrscr(); menuTPS(); }
                
            case "4":
                clrscr();
                System.out.println("============== Hapus TPS ==============");
                showArr(4); hapusTPS();
                System.out.println("");
                System.out.println("=   Tekan enter untuk kembali        =");
                String pil4 = input.nextLine();
                switch (pil4){ default: clrscr(); menuTPS(); }
                
            case "9":
                clrscr();
                menuAdmin();
            case "0":
                System.exit(0);
        }
    }
    public void addTPS(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor TPS         : ");
        int no = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   Tempat TPS        : ");
        String tem = input.nextLine();
        System.out.print("   Jumlah DPT        : ");
        int dpt = input.nextInt();
        try {
            TPS t = new TPS(no,tem,dpt);
            app.inputTPS(t);
            System.out.println("Data berhasil ditambahkan.");
        } catch(Exception e){
            System.out.println("Data gagal ditambahkan.");
        }
    }
    public void editTPS(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor TPS yang ingin diupdate : ");
        int no = input.nextInt();
   
        if (!app.isNoTPSExist(no)) {            
            System.out.println("Nomor TPS tidak ada.");
            editTPS();
        }
        String x = input.nextLine();
        System.out.print("   Nomor TPS         : ");
        int nom = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   Tempat TPS        : ");
        String tem = input.nextLine();
        System.out.print("   Jumlah DPT        : ");
        int dpt = input.nextInt();
        try {
            TPS t = new TPS(nom,tem,dpt);
            app.editTPS(no,t);
            System.out.println("Data berhasil diupdate.");
        } catch(Exception e){
            System.out.println("Data gagal diupdate.");
        }
    }
    public void hapusTPS(){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor TPS yang ingin dihapus : ");
        int no = input.nextInt();
   
        if (!app.isNoTPSExist(no)) {            
            System.out.println("Nomor TPS tidak ada.");
            hapusTPS();
        }
        String x = input.nextLine();
        try {
            app.hapusTPS(no);
            System.out.println("Data berhasil dihapus.");
        } catch(Exception e){
            System.out.println("Data gagal dihapus.");
        }
    }
    
    public void assignPetugas(){
        Scanner input = new Scanner(System.in);        
        System.out.print("   Nomor Petugas yang ingin diassign : ");
        int noP = input.nextInt();
        if (!app.isNoPetugasExist(noP)) {            
            System.out.println("Nomor Petugas tidak ada.");
            assignPetugas();
        }
        String x = input.nextLine();
        System.out.print("   Petugas " + noP + " Assign ke TPS : " );
        int noT = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   Jabatan : ");
        String jab = input.nextLine();
        try {
            Petugas p = app.getPetugas(noP);
            TPS tps = app.getTPS(noT);
            tps.addPPS(p);
            p.setNomorTPS(noT);
            p.setJabatan(jab);
            app.editPetugas(noP, p);
            System.out.println("Petugas berhasil diassign.");
        } catch(Exception e){
            System.out.println("Petugas gagal diassign.");
        }
    }
    public void assignPemilih(){
        Scanner input = new Scanner(System.in);        
        System.out.print("   Nomor Pemilih yang ingin diassign : ");
        int noP = input.nextInt();
        if (!app.isNoPemilihExist(noP)) {            
            System.out.println("Nomor Pemilih tidak ada.");
            assignPemilih();
        }
        String x = input.nextLine();
        System.out.print("   Pemilih " + noP + " Assign ke TPS : " );
        int noT = input.nextInt();
        String xy = input.nextLine();
        try {
            Pemilih p = app.getPemilih(noP);
            TPS tps = app.getTPS(noT);
            tps.addDPT(p);
            p.setNomorTps(noT);
            app.editPemilih(noP, p);
            System.out.println("Pemilih berhasil diassign.");
        } catch(Exception e){
            System.out.println("Pemilih gagal diassign.");
        }
    }
    
    // MENU APP NON-ADMIN  
    public void beginVote(Pemilih pem) throws IOException{
        if (pem.getStatusPilih()) {
            System.out.println("Maaf anda sudah menggunakan hak pilih anda!");
        } else {
            Scanner input = new Scanner(System.in);
            ArrayList<Kandidat> arr = app.getDaftarKandidat();
            for(Kandidat x: arr){
                System.out.println("   Kandidat : " + x.getNoKandidat());
                System.out.println("      Nama           : " + x.getNama());
            } System.out.println("");
            System.out.print("Pilihan anda : ");
            int pil = input.nextInt();
            Kandidat k = app.getKandidat(pil);
            try{
                Pemilihan vote = new Pemilihan(pem,k);
                app.inputPemilihan(vote);
                pem.setStatusPilih(true);
                System.out.println("Data berhasil ditambahkan.");
            } catch (Exception e){
                System.out.println("Data gagal ditambahkan.");
            }
        }            
    }
    public void viewKandidat(){
        ArrayList<Kandidat> arr = app.getDaftarKandidat();
        for(Kandidat x: arr){
            ArrayList<Program> arrProg = new ArrayList<Program>();
            System.out.println("   Kandidat : " + x.getNoKandidat());
            System.out.println("      Nama           : " + x.getNama());
            System.out.println("      Program        : " + x.getDaftarProgram());
            for(Program y: arrProg){
                System.out.println("         " + y.getNoProgram() +". "+y.getIsiProgram());
            }
        }
    }
    public void viewDataDiri(Pemilih p){
        System.out.println("   Pemilih : " + p.getNoPemilih());
        System.out.println("      NIK            : " + p.getNik());
        System.out.println("      Nama           : " + p.getNama());
        System.out.println("      Tanggal Lahir  : " + p.getTanggalLahir());
        System.out.println("      Jenis Kelamin  : " + p.getJenisKelamin());
        System.out.println("      Nomor TPS      : " + p.getNomorTps());
        System.out.println("      Status Pilih   : " + p.getStatusPilih());
    }    
    public void pindahTPS(Pemilih p){
        Scanner input = new Scanner(System.in);
        System.out.println("   TPS sebelumnya : " + p.getNomorTps());
        System.out.print("   Nomor TPS yang ingin dituju : ");
        int noT = input.nextInt();   
        if (!app.isNoTPSExist(noT)) {            
            System.out.println("Nomor TPS tidak ada.");
            pindahTPS(p);
        }
        String x = input.nextLine();
        try {
            TPS tps = app.getTPS(noT);
            app.inputPindahTPS(p, tps);
            System.out.println("Permohonan berhasil diajukan.");
        } catch(Exception e){
            System.out.println("Permohonan gagal diajukan.");
        }
    }
 
    public void viewPindahTPS(){
        ArrayList<Object[]> arr = app.getDataPindahTPS();
        for(Object[] x: arr){
            System.out.println("   No Pengajuan : " + x[0] );
            System.out.println("      NIK Pemilih               : " + x[1]);
            System.out.println("      Nama Pemilih              : " + x[2]);
            System.out.println("      Nomor TPS lama            : " + x[3]);
            System.out.println("      Nomor TPS tujuan          : " + x[4]);
            System.out.println("      Status penuh TPS tujuan   : " + x[5]);
        }
    }
    public void verifyPindahTPS(){
        ArrayList<Object[]> arr = app.getDataPindahTPS();
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Pengajuan yang ingin diverifikasi : ");
        int no = input.nextInt();
        if (!app.isNoPengajuanExist(no)) {            
            System.out.println("Nomor Pengajuan tidak ada.");
            verifyPindahTPS();
        }
        String x = input.nextLine();
        System.out.print("   Konfirmasi (Y/N) :");
        String kon = input.nextLine();
        if (kon.equals("y") || kon.equals("Y")) {
            try {
                Object[] o = app.getPengajuan(no);
                app.verify(o);
                System.out.println("Data berhasil diverifikasi.");
            } catch(Exception e){
                System.out.println("Data gagal diverifikasi.");
            }
        } else if (kon.equals("n") || kon.equals("N")) {
            try {
                Object[] o = app.getPengajuan(no);
                app.reject(o);
                System.out.println("Data berhasil diverifikasi.");
            } catch(Exception e){
                System.out.println("Data gagal diverifikasi.");
            }
        }
    }
    
    public void viewProgram(Kandidat k){
        ArrayList<Program> arrProg = k.getDaftarProgram();
        System.out.println("   Program        : ");
        for(Program y: arrProg){
            System.out.println("      " + y.getNoProgram() +". "+y.getIsiProgram());
        }
    }
    public void addProgram(Kandidat k){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Program     : ");
        int no = input.nextInt();
        String x = input.nextLine();
        System.out.print("   Isi Program       : ");
        String isi = input.nextLine();
        try {
            Program p = new Program(no,isi);
            k.addProgram(p);
            System.out.println("Data berhasil ditambahkan.");
        } catch(Exception e){
            System.out.println("Data gagal ditambahkan.");
        }
    }
    public void editProgram(Kandidat k){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Program yang ingin diupdate : ");
        int no = input.nextInt();
   
        if (!k.isNoProgramExist(no)) {            
            System.out.println("Nomor Program tidak ada.");
            editProgram(k);
        }
        String x = input.nextLine();
        System.out.print("   Nomor Program     : ");
        int nom = input.nextInt();
        String xy = input.nextLine();
        System.out.print("   Isi Program       : ");
        String isi = input.nextLine();
        try {
            Program p = new Program(nom,isi);
            k.editProgram(no, p);
            System.out.println("Data berhasil diupdate.");
        } catch(Exception e){
            System.out.println("Data gagal diupdate.");
        }
    }
    public void deleteProgram(Kandidat k){
        Scanner input = new Scanner(System.in);
        System.out.print("   Nomor Program yang ingin dihapus : ");
        int no = input.nextInt();
   
        if (!k.isNoProgramExist(no)) {            
            System.out.println("Nomor Program tidak ada.");
            deleteProgram(k);
        }
        String x = input.nextLine();
        try {
            k.delProgram(no);
            System.out.println("Data berhasil dihapus.");
        } catch(Exception e){
            System.out.println("Data gagal dihapus.");
        }
    }
   
}
