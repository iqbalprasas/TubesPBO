/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DatabaseInventaris;
import java.util.ArrayList;

/**
 *
 * @author iqbal
 */
public class Application {
    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<Penyedia> daftarPenyedia;
    private DatabaseInventaris di;
    private int index;
    
    public Application(){
        daftarPetugas = new ArrayList<Petugas>();
        daftarPenyedia = new ArrayList<Penyedia>();
        di = new DatabaseInventaris();
        di.Connect();
        index = di.getCountBarang();
    }
    
    public void insertPetugas(String nama, long id, String pass){
        daftarPetugas.add(new Petugas(nama,id,pass));
        di.savePetugas(new Petugas(nama,id,pass));
    }
    public void insertPenyedia(String nama, long id, String pass){
        daftarPenyedia.add(new Penyedia(nama,id,pass));
        di.savePenyedia(new Penyedia(nama,id,pass));
    }
    public Petugas getPetugas(long id){
        return di.getPetugas(id);
        /*for(Petugas ps : daftarPetugas){
            if(ps.getId()==id){
                return ps;
            }
        }*/
        //return null;
    }
    public Penyedia getPenyedia(long id){
        /*for(Penyedia pa : daftarPenyedia){
            if(pa.getId()==id){
                return pa;
            }
        }
        return null;*/
        return di.getPenyedia(id);
    }
    
    public boolean getValidPenyedia(long id, String pass){
        try {
            if ((di.getPenyedia(id).getId() == id) && (di.getPenyedia(id).getPass().equals(pass))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("login gagal");
        }
        return false;
    }
    
    public boolean getValidPetugas(long id, String pass){
        try{
            if ((di.getPetugas(id).getId() == id) && (di.getPetugas(id).getPass().equals(pass))) {
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            System.out.println("login gagal");
        }
        return false;
    }
    
    public void updatePassPenyedia(long id, String pass){
        di.updatePassPenyedia(id, pass);
    }
    
    public void updatePassPetugas(long id, String pass){
        di.updatePassPetugas(id, pass);
    }
    
    public void createBarang(String nama, int jumlah, int kondisi, String tglMasuk){
        boolean kb;
        if(kondisi==0){
            kb = true;
        }else{
            kb = false;
        }
        di.saveBarang(new Barang(nama, ("BRG"+String.valueOf(index)), jumlah, kb, tglMasuk));
        index++;
    }
    
    public void catatBarang(Barang b){
        di.saveBarangGudang(b);
    }
    
    public String[] showAllBarang(){
        return di.getBarang();
    }
    
    public String[] showAllBarangGudang(){
        return di.getBarangGudang();
    }
    
    public Barang findBarang(String kode){
        return di.findBarang(kode);
    }
    
    public Barang findBarangGudang(String kode){
        return di.findBarangGudang(kode);
    }
    
    public void updateBarang(String kode, int jumlah, int kondisi){
        di.updateBarang(kode, (jumlah), kondisi);
    }
    
    public boolean isBaranginGudang(String kode){
        return di.isBaranginGudang(kode);
    }
}
