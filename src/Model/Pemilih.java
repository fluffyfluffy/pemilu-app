/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Pemilih extends Person{
    private int noPemilih;
    private int nomorTps;

    public Pemilih(int noPemilih, String nik, String tanggalLahir, String nama, String jenisKelamin) {
        super(nik, tanggalLahir, nama, jenisKelamin);
        this.noPemilih = noPemilih;
    }

    public Pemilih(String nik, String tanggalLahir, String nama, String jenisKelamin) {
        super(nik, tanggalLahir, nama, jenisKelamin);
    }
    
    public int getNomorTps() {
        return nomorTps;
    }

    public void setNomorTps(int nomorTps) {
        this.nomorTps = nomorTps;
    }

    public int getNoPemilih() {
        return noPemilih;
    }

    public void setNoPemilih(int noPemilih) {
        this.noPemilih = noPemilih;
    }
    
    
}
