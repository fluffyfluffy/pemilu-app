/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class Application {
    private ArrayList<Pemilih> daftarPemilih = new ArrayList<Pemilih>();
    private ArrayList<Petugas> daftarPetugas = new ArrayList<Petugas>();
    private ArrayList<Kandidat> daftarKandidat = new ArrayList<Kandidat>();
    private ArrayList<Pemilihan> daftarPemilihan = new ArrayList<Pemilihan>();
    private ArrayList<TPS> daftarTPS = new ArrayList<TPS>();
    private ArrayList<Object[]> dataPindahTPS = new ArrayList<Object[]>();

    public Application() {
        Pemilih p = new Pemilih(1,"123456","17041999","Bejo Sudrajat","LakiLaki");
        Petugas t = new Petugas(1,"098765","28071988","Maria Hartini","Perempuan");
        Kandidat k = new Kandidat(1,"111000","14011989","Ahmad Sartono","LakiLaki");
        TPS s = new TPS(1,"Bandung",100);
        inputPemilih(p);
        inputPetugas(t);
        inputKandidat(k);
        inputTPS(s);
    }
    
    public void inputPemilih(Pemilih pemilih) {
        daftarPemilih.add(pemilih); 
    }    
    public void editPemilih(int nomor, Pemilih pemilih) {
        int a = 0;
        for(Pemilih x: daftarPemilih){
            if(x.getNoPemilih() == nomor){
                a = daftarPemilih.indexOf(x);
                daftarPemilih.set(a, pemilih);
            }
        }
    }
    public void hapusPemilih(int nomor){
        for(Pemilih x: daftarPemilih){
            if(x.getNoPemilih() == nomor){
                daftarPemilih.remove(x);
                break;
            }
        }
    }
    public Boolean isNoPemilihExist(int nomor){
        Boolean s = false;
        for(Pemilih x: daftarPemilih){
            if(x.getNoPemilih() == nomor) s = true;
        } return s;
    }
    public Boolean isNikPemilihExist(String nik){
        Boolean s = false;
        for(Pemilih x: daftarPemilih){
            if(x.getNik().equals(nik)) s = true;
        } return s;
    }
    public String getNikPemilih(String nik){
        String s = "";
        for(Pemilih x: daftarPemilih){
            if(x.getNik().equals(nik)) s = x.getNik();
        } return s;
    }
    public Person getPemilih(String nik){
        Person p = null;
        for(Person x: daftarPemilih){
            if(x.getNik().equals(nik)) p = x;
        } return p;
    }
    public Pemilih getPemilih(int nomor){
        Pemilih p = null;
        for(Pemilih x: daftarPemilih){
            if(x.getNoPemilih() == nomor) p = x;
        } return p;
    }
    public Pemilih getPemilihByNik(String nik){
        Pemilih p = null;
        for(Pemilih x: daftarPemilih){
            if(x.getNik().equals(nik)) p = x;
        } return p;
    }
    
    public void inputPetugas(Petugas petugas) {
        daftarPetugas.add(petugas);
    }  
    public void editPetugas(int nomor, Petugas petugas) {
        int a = 0;
        for(Petugas x: daftarPetugas){
            if(x.getNoPetugas() == nomor){
                a = daftarPetugas.indexOf(x);
                daftarPetugas.set(a, petugas);
            }
        }      
    }
    public void hapusPetugas(int nomor){
        for(Petugas x: daftarPetugas){
            if(x.getNoPetugas() == nomor){
                daftarPetugas.remove(x);
                break;
            }
        }
    }
    public Boolean isNoPetugasExist(int nomor){
        Boolean s = false;
        for(Petugas x: daftarPetugas){
            if(x.getNoPetugas() == nomor) s = true;
        } return s;
    }
    public String getNikPetugas(String nik){
        String s = "";
        for(Petugas x: daftarPetugas){
            if(x.getNik().equals(nik)) s = x.getNik();
        } return s;
    }
    public Person getPetugas(String nik){
        Person p = null;
        for(Person x: daftarPetugas){
            if(x.getNik().equals(nik)) p = x;
        } return p;
    }
    public Petugas getPetugas(int nomor){
        Petugas p = null;
        for(Petugas x: daftarPetugas){
            if(x.getNoPetugas() == nomor) p = x;
        } return p;
    }
    
    public void inputKandidat(Kandidat kandidat) {
        daftarKandidat.add(kandidat); 
    } 
    public void editKandidat(int nomor, Kandidat kandidat) {
        int a = 0;
        for(Kandidat x: daftarKandidat){
            if(x.getNoKandidat() == nomor){
                a = daftarKandidat.indexOf(x);
                daftarKandidat.set(a, kandidat);
            }
        }      
    }
    public void hapusKandidat(int nomor){
        for(Kandidat x: daftarKandidat){
            if(x.getNoKandidat() == nomor){
                daftarKandidat.remove(x);
                break;
            }
        }
    }
    public Boolean isNoKandidatExist(int nomor){
        Boolean s = false;
        for(Kandidat x: daftarKandidat){
            if(x.getNoKandidat() == nomor) s = true;
        } return s;
    }
    public String getNikKandidat(String nik){
        String s = "";
        for(Kandidat x: daftarKandidat){
            if(x.getNik().equals(nik)) s = x.getNik();
        } return s;
    }
    public Person getKandidat(String nik){
        Person p = null;
        for(Person x: daftarKandidat){
            if(x.getNik().equals(nik)) p = x;
        } return p;
    }
    public Kandidat getKandidat(int nomor){
        Kandidat p = null;
        for(Kandidat x: daftarKandidat){
            if(x.getNoKandidat() == nomor) p = x;
        } return p;
    }
    
    public void inputTPS(TPS tps) {
        daftarTPS.add(tps); 
    }
    public void editTPS(int nomor, TPS tps){
        int a = 0;
        for(TPS x: daftarTPS){
            if(x.getNomorTPS() == nomor){
                a = daftarTPS.indexOf(x);
                daftarTPS.set(a, tps);
            }
        }
    }
    public void hapusTPS(int nomor){
        for(TPS x: daftarTPS){
            if(x.getNomorTPS() == nomor){
                daftarTPS.remove(x);
                break;
            }
        }
    }
    public Boolean isNoTPSExist(int nomor){
        Boolean s = false;
        for(TPS x: daftarTPS){
            if(x.getNomorTPS() == nomor) s = true;
        } return s;
    }
    public TPS getTPS(int nomor){
        TPS p = null;
        for(TPS x: daftarTPS){
            if(x.getNomorTPS() == nomor) p = x;
        } return p;
    }
    
    public void inputPemilihan(Pemilihan pemilihan) {
        daftarPemilihan.add(pemilihan); 
    }
    
    public void inputPindahTPS(Pemilih pemilih, TPS tps){
        int no = dataPindahTPS.size();
        Object[] data = {(no+1), pemilih.getNik(), pemilih.getNama(), pemilih.getNomorTps(), tps.getNomorTPS(), tps.getStatusPenuh()};
        dataPindahTPS.add(data);
    }
    public Boolean isNoPengajuanExist(int nomor){
        Boolean s = false;
        for(Object[] x: dataPindahTPS){
            if(x[0].equals(nomor)) s = true;
        } return s;
    }
    public Object[] getPengajuan(int nomor){
        Object[] o = null;
        for(Object[] x: dataPindahTPS){
            if(x[0].equals(nomor)) o = x;
        } return o;
    }
    public void verify(Object[] o){
        Pemilih p = getPemilihByNik(o[1].toString());
        int newTPS = Integer.parseInt(o[4].toString());
        int oldTPS = Integer.parseInt(o[3].toString());
        TPS newt = getTPS(newTPS);
        TPS oldt = getTPS(oldTPS);
        p.setNomorTps(newTPS);
        newt.addDPT(p);
        oldt.delDPT(p);
        dataPindahTPS.remove(o);
    }
    public void reject(Object[] o){
        dataPindahTPS.remove(o);
    }
    
    public ArrayList<Pemilih> getDaftarPemilih() {
        return daftarPemilih;
    }
    public ArrayList<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }
    public ArrayList<Kandidat> getDaftarKandidat() {
        return daftarKandidat;
    }
    public ArrayList<Pemilihan> getDaftarPemilihan() {
        return daftarPemilihan;
    }
    public ArrayList<TPS> getDaftarTPS() {
        return daftarTPS;
    }
    public ArrayList getDataPindahTPS() {
        return dataPindahTPS;
    }

}
