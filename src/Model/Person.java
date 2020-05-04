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
public abstract class Person {
    private String nik;
    private String tanggalLahir;
    private String nama;
    private String jenisKelamin;
    private Boolean statusPilih = false;

    public Person(String nik, String tanggalLahir, String nama, String jenisKelamin) {
        this.nik = nik;
        this.tanggalLahir = tanggalLahir;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }

    public Person(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public Boolean getStatusPilih() {
        return statusPilih;
    }

    public void setStatusPilih(Boolean statusPilih) {
        this.statusPilih = statusPilih;
    }
    
}
