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
public class Kandidat extends Person{
    private int noKandidat;
    private ArrayList<Program> daftarProgram = new ArrayList<Program>();

    public Kandidat(int noKandidat, String nik, String tanggalLahir, String nama, String jenisKelamin) {
        super(nik, tanggalLahir, nama, jenisKelamin);
        this.noKandidat = noKandidat;
    }
    
    public Kandidat(String nik, String tanggalLahir, String nama, String jenisKelamin) {
        super(nik, tanggalLahir, nama, jenisKelamin);
    }

    public Kandidat(String nik, String nama) {
        super(nik, nama);
    }
  
    public void addProgram(Program p) {
        daftarProgram.add(p);
    }
    
    public void delProgram(int noProgram) {
        for(Program x: daftarProgram){
            if(x.getNoProgram() == noProgram){
                daftarProgram.remove(x);
                break;
            }
        }
    }
    
    public void editProgram(int noProgram, Program p){
        int a = 0;
        for(Program x: daftarProgram){
            if(x.getNoProgram() == noProgram){
                a = daftarProgram.indexOf(x);
                daftarProgram.set(a, p);
            }
        }
    }
    
    public Boolean isNoProgramExist(int nomor){
        Boolean s = false;
        for(Program x: daftarProgram){
            if(x.getNoProgram() == nomor) s = true;
        } return s;
    }
    
    public ArrayList<Program> getList() {
        return daftarProgram;
    }

    public ArrayList<Program> getDaftarProgram() {
        return daftarProgram;
    }

    public int getNoKandidat() {
        return noKandidat;
    }

    public void setNoKandidat(int noKandidat) {
        this.noKandidat = noKandidat;
    }
    
}
