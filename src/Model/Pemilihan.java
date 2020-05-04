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
public class Pemilihan {
    private Pemilih pemilih;
    private Kandidat kandidat;

    public Pemilihan(Pemilih pemilih, Kandidat kandidat) {
        this.pemilih = pemilih;
        this.kandidat = kandidat;
    }

    public Pemilih getPemilih() {
        return pemilih;
    }

    public void setPemilih(Pemilih pemilih) {
        this.pemilih = pemilih;
    }

    public Kandidat getKandidat() {
        return kandidat;
    }

    public void setKandidat(Kandidat kandidat) {
        this.kandidat = kandidat;
    }
    
    
}
