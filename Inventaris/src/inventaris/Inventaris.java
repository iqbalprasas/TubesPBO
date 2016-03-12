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
        // TODO code application logic here
        Date a = new Date();
        Barang b = new Barang("tes","101");
        //b.setTglMasuk(a);
        System.out.println(b.getTglMasuk().getDate()+" "+b.getTglMasuk().getMonth()+" "+(1900+b.getTglMasuk().getYear()));
    }
    
}
