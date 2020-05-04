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
public class Program {
    private int noProgram;
    private String isiProgram;

    public Program(int noProgram, String isiProgram) {
        this.noProgram = noProgram;
        this.isiProgram = isiProgram;
    }

    public int getNoProgram() {
        return noProgram;
    }

    public void setNoProgram(int noProgram) {
        this.noProgram = noProgram;
    }

    public String getIsiProgram() {
        return isiProgram;
    }

    public void setIsiProgram(String isiProgram) {
        this.isiProgram = isiProgram;
    }    
}
