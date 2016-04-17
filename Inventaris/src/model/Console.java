/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
/**
 *
 * @author iqbal
 */
public class Console {
    /*Scanner baca = new Scanner(System.in);
    Gudang gudang = new Gudang(100);
    Petugas petugas = new Petugas("Iqbal",1301144042,"iqbal123");
    Penyedia penyedia = new Penyedia("Pratomo",1111144042,"prasas123");*/
    
    /*public void menuUtama(){
        int pilih;
        do {
            try {
                System.out.println("MENU");
                System.out.println("1. Petugas");
                System.out.println("2. Penyedia");
                System.out.println("3. Exit");
                pilih = baca.nextInt();
                switch (pilih) {
                    case 1:
                        menuLoginPetugas();
                        break;
                    case 2:
                        menuLoginPenyedia();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        } while (true);
    }
    
    public void menuLoginPetugas(){
        try{
            long un;
            String pass;
            System.out.println("MENU LOGIN PETUGAS");
            System.out.println("ID : ");
            un = baca.nextLong();
            System.out.println("Password : ");
            pass = baca.next();
            if ((petugas.getId() == un) && (pass.equals(petugas.getPass()))) {
                menuPetugas();
                System.out.println();
            } else {
                System.out.println("ID atau Password salah !!");
                System.out.println();
            }
        }catch(Exception e){
            System.out.println("Error");
            baca.next();
        }
        
    }
    
    public void menuLoginPenyedia(){
        try{
            long un;
            String pass;
            System.out.println("MENU LOGIN PENYEDIA");
            System.out.println("ID : ");
            un = baca.nextLong();
            System.out.println("Password : ");
            pass = baca.next();
            if ((penyedia.getId() == un) && (pass.equals(penyedia.getPass()))) {
                menuPenyedia();
                System.out.println();
            } else {
                System.out.println("ID atau Password salah !!");
                System.out.println();
            }
        }catch(Exception e){
            System.out.println("Error");
            baca.next();
        }                                                                                                                                                                                                                                 
    }
    
    public void menuPetugas(){
        int pilih;
        do{
            try {
                System.out.println("MENU PETUGAS");
                System.out.println("1. Lihat Profile");
                System.out.println("2. Edit Profile");
                System.out.println("3. Masukkan Barang");
                System.out.println("4. Edit Kondisi Barang");
                System.out.println("5. Lihat Info Semua Barang");
                System.out.println("6. Cari Info Barang");
                System.out.println("7. Logout");
                pilih = baca.nextInt();
                switch (pilih) {
                    case 1:
                        lihatProfilePetugas();
                        break;
                    case 2:
                        editProfilePetugas();
                        break;
                    case 3:
                        inputBarang();
                        break;
                    case 4:
                        editKondisiBarang(cariBarang());
                        break;
                    case 5:
                        petugas.tampilinfoAll(gudang);
                        break;
                    case 6:
                        cariBarang().tampilLaporanBarang();
                        break;
                    case 7:
                        menuUtama();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        } while (true);
    }
    
    public void menuPenyedia(){
        int pilih;
        do{
            try {
                System.out.println("MENU PENYEDIA");
                System.out.println("1. Lihat Profile");
                System.out.println("2. Edit Profile");
                System.out.println("3. Buat Barang");
                System.out.println("4. Logout");
                pilih = baca.nextInt();
                switch (pilih) {
                    case 1:
                        lihatProfilePenyedia();
                        break;
                    case 2:
                        editProfilePenyedia();
                    case 3:
                        createBarang();
                        break;
                    case 4:
                        menuUtama();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        } while (true);
    }
    
    public void lihatProfilePetugas(){
        petugas.tampilProfile();
        System.out.println();
    }
    
    public void lihatProfilePenyedia(){
        penyedia.tampilProfile();
        System.out.println();
    }
    
    public void editProfilePetugas(){
        lihatProfilePetugas();
        System.out.println("Masukkan Password : ");
        if (baca.next().equals(petugas.getPass())) {
            System.out.println("Password : ");
            petugas.setPass(baca.next());
            System.out.println("Jenis Kelasmin : ");
            petugas.setKel(baca.next());
            try {
                System.out.println("Umur : ");
                petugas.setUmur(baca.nextInt());
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        }
    }
    
    public void editProfilePenyedia(){
        penyedia.tampilProfile();
        System.out.println("Masukkan Password : ");
        if (baca.next().equals(penyedia.getPass())) {
            System.out.println("Password : ");
            penyedia.setPass(baca.next());
            System.out.println("Jenis Kelasmin : ");
            penyedia.setKel(baca.next());
            try {
                System.out.println("Umur : ");
                penyedia.setUmur(baca.nextInt());
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        }
    }
    
    public void inputBarang(){
        String nama;
        String kode;
        int jum;
        boolean isKondisi;
        for (int i = petugas.getNumOfCatat(); i < penyedia.getNumOfBarang(); i++) {
            try {
                penyedia.getBarang(i).tampilInfoBarang();
                System.out.println("");
                System.out.println("Kode Barang : ");
                kode = baca.next();
                penyedia.getBarang(i).setKodeBarang(kode);
                System.out.println("Nama Barang : ");
                nama = baca.next();
                System.out.println("Jumlah : ");
                jum = baca.nextInt();
                System.out.println("Kondisi : ");
                isKondisi = baca.nextBoolean();
                petugas.catatBarang(penyedia.getBarang(i), gudang);
                System.out.println("Data Barang Telah disimpan");
                System.out.println("");
            } catch (Exception e) {
                System.out.println("Error");
                baca.next();
            }
        }
        if (petugas.getNumOfCatat() == penyedia.getNumOfBarang()) {
            System.out.println("Tidak ada barang baru yang masuk");
            System.out.println("");
        }
    }
    
    public void createBarang(){
        String nama;
        int jum;
        boolean isKondisi;
        try {
            System.out.println("Nama Barang : ");
            nama = baca.next();
            System.out.println("Jumlah : ");
            jum = baca.nextInt();
            System.out.println("Kondisi : ");
            isKondisi = baca.nextBoolean();
            penyedia.createBarang(nama, jum, isKondisi);
            System.out.println("Barang telah dibuat");
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error");
            baca.next();
        }
    }
    
    public Barang cariBarang(){
        
        System.out.println("Masukkan ID Barang : ");
        String cari = baca.next();
        for(int i = 0;i<gudang.getNumOfBarang();i++){
            try{
            if(cari.equals(gudang.getBarang(i).getKodeBarang())){
                return gudang.getBarang(i);
            }
            }catch(Exception e){
                System.out.println("Error");
                baca.next();
            }
        }
        return null;
    }
    
    public void editKondisiBarang(Barang barang){
        try {
            barang.tampilInfoBarang();
            System.out.println("");
            System.out.println("Jumlah : ");
            barang.setJumlah(baca.nextInt());
            System.out.println("Kondisi ");
            barang.setKondisiBarang(baca.next());
        } catch (Exception e) {
            System.out.println("Error");
            baca.next();
        }
    }*/
}
