/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iqbal
 */
public class Inventaris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        File user = new File("user.txt");
        File pass = new File("pass.txt");
        FileInputStream fis = new FileInputStream(user);
        DataInputStream dis = new DataInputStream(fis);
        String isi = dis.readLine();
        System.out.println(isi);
        /*FileOutputStream fosUser = new FileOutputStream(user);
        FileOutputStream fosPass = new FileOutputStream(pass);
        DataOutputStream dosUser = new DataOutputStream(fosUser);
        DataOutputStream dosPass = new DataOutputStream(fosPass);*/
        Gudang g = new Gudang(100);
        /*Penyedia penyedia = new Penyedia("Iqbal",130,"iqbal123");
        Petugas petugas = new Petugas("Prasas",130114,"prasas123");
        penyedia.createBarang("Kursi","111",10,true);
        penyedia.createBarang("Proyektor","222", 5, true);
        petugas.catatBarang(penyedia.getBarang(0), g);
        petugas.catatBarang(penyedia.getBarang(1), g);
        petugas.editBarang(g, "111", 20);
        petugas.editBarang(g, "222", "tidak bagus");
        petugas.tampilinfoAll(g);
        petugas.tampilProfile();
        penyedia.tampilProfile();
        /*dosUser.writeBytes(petugas.getNama());
        dosPass.writeBytes(petugas.getPass());*/
    }    
}
