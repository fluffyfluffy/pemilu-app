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
public class Petugas extends Person{
    private int noPetugas;
    private String jabatan;
    private int nomorTPS;

    public Petugas(int noPetugas, String nik, String tanggalLahir, String nama, String jenisKelamin) {
        super(nik, tanggalLahir, nama, jenisKelamin);
        this.noPetugas = noPetugas;
    }

    public Petugas(String nik, String nama) {
        super(nik, nama);
    }

    public Petugas(String jabatan, int nomorTPS, String nik, String nama) {
        super(nik, nama);
        this.jabatan = jabatan;
        this.nomorTPS = nomorTPS;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getNomorTPS() {
        return nomorTPS;
    }

    public void setNomorTPS(int nomorTPS) {
        this.nomorTPS = nomorTPS;
    }

    public int getNoPetugas() {
        return noPetugas;
    }

    public void setNoPetugas(int noPetugas) {
        this.noPetugas = noPetugas;
    }
    
    
}
