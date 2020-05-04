/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class TPS {
    private int nomorTPS;
    private String tempatTPS;
    private int jumlahDPT;
    private Boolean statusPenuh = false;
    private ArrayList<Pemilih> DPT = new ArrayList<Pemilih>();
    private ArrayList<Petugas> daftarPPS = new ArrayList<Petugas>();

    public TPS(int nomorTPS, String tempatTPS, int jumlahDPT) {
        this.nomorTPS = nomorTPS;
        this.tempatTPS = tempatTPS;
        this.jumlahDPT = jumlahDPT;
    }

    public void addPPS(Petugas petugas) {
        daftarPPS.add(petugas);
    }
    
    public void addDPT(Pemilih pemilih) {
        if (!isFull()) {
            DPT.add(pemilih);    
        } 
    }
    
    public void delDPT(Pemilih pemilih){
        DPT.remove(pemilih);
    }
    
    public Boolean isFull(){
        if (DPT.size() < jumlahDPT) {
            statusPenuh = false;
        } else {
            statusPenuh = true;
        }
        return statusPenuh;
    }
    
    public int getNomorTPS() {
        return nomorTPS;
    }

    public void setNomorTPS(int nomorTPS) {
        this.nomorTPS = nomorTPS;
    }

    public String getTempatTPS() {
        return tempatTPS;
    }

    public void setTempatTPS(String tempatTPS) {
        this.tempatTPS = tempatTPS;
    }

    public int getJumlahDPT() {
        return jumlahDPT;
    }

    public void setJumlahDPT(int jumlahDPT) {
        this.jumlahDPT = jumlahDPT;
    }

    public Boolean getStatusPenuh() {
        return statusPenuh;
    }

    public void setStatusPenuh(Boolean statusPenuh) {
        this.statusPenuh = statusPenuh;
    }

    public ArrayList<Pemilih> getDPT() {
        return DPT;
    }

    public ArrayList<Petugas> getDaftarPPS() {
        return daftarPPS;
    }
    
    
}
