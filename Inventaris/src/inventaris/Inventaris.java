/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris;

import java.util.Date;

/**
 *
 * @author iqbal
 */
public class Inventaris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gudang g = new Gudang(100);
        Penyedia penyedia = new Penyedia("Iqbal",130,"iqbal123");
        Petugas petugas = new Petugas("Prasas",130114,"prasas123");
        penyedia.createBarang("Kursi","111",10,true);
        penyedia.createBarang("Proyektor","222", 5, true);
        petugas.catatBarang(penyedia.getBarang(0), g);
        petugas.catatBarang(penyedia.getBarang(1), g);
        petugas.editBarang(g, 0, 20);
        petugas.editBarang(g, 1, "tidak bagus");
        petugas.tampilinfoAll(g);
    }    
}
