package model;

import java.util.Date;

public class Barang {
    private String namaBarang;
    private String kodeBarang;
    private int jumlah;
    private boolean kondisiBagus=true;
    private String tglMasuk;
    private String tglKeluar;
    private String mutasi [] = new String[100];
    private int jumOfMutasi;
	
    public Barang(String nb, String kb, int jum, boolean k, String tglMasuk) {
	namaBarang = nb;
	kodeBarang = kb;
	jumlah = jum;
	kondisiBagus = k;
        tglKeluar = "";
        this.tglMasuk = tglMasuk;
        if(k==true){
            mutasi[jumOfMutasi] = tglMasuk+String.valueOf(jumlah)+" Kondisi Bagus";
        }else{
            mutasi[jumOfMutasi] = tglMasuk+" Jumlah : "+String.valueOf(jumlah)+" Kondisi Tidak Bagus";
        }
        jumOfMutasi++;
    }
    public Barang(String nb, String kb, String tglMasuk){
        namaBarang = nb;
        kodeBarang = kb;
        tglKeluar = "";
        this.tglMasuk = tglMasuk;
        mutasi[jumOfMutasi] = tglMasuk;
        jumOfMutasi++;
    }
    
    public Barang(String nb, int jum, boolean k, String tglMasuk){
        namaBarang = nb;
        jumlah = jum;
        kondisiBagus = k;
        tglKeluar = "";
        this.tglMasuk = tglMasuk;
        mutasi[jumOfMutasi] = tglMasuk;
        jumOfMutasi++;
    }
	
    public String getNamaBarang() {
        return namaBarang;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah=this.jumlah+jumlah;
        if(jumlah>=0){
            mutasi[jumOfMutasi] = tglMasuk+" Jumlah : "+String.valueOf(jumlah);
        }else{
            mutasi[jumOfMutasi] = tglKeluar+" Jumlah : "+String.valueOf(jumlah);
        }
        jumOfMutasi++;
    }
	
    public int getJumlah() {
        return jumlah;   
    }
    
    
    
    public void setKondisiBarang(String kb){
        if (kb.equals("bagus")){
            kondisiBagus = true;
            mutasi[jumOfMutasi] = tglMasuk+" Kondisi Bagus";
        }else{
            kondisiBagus = false;
            mutasi[jumOfMutasi] = tglMasuk+" Kondisi Tidak Bagus";
        }
        jumOfMutasi++;
    }
	
    public int getKondisiBarang() {
        if(kondisiBagus){
            return 1;
        }else{
            return 0;
        }
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }
	
    
    public String getTglMasuk() {
	return tglMasuk;
    }
	
    public String getTglKeluar() {
        return tglKeluar;
    }
    
    public String getKodeBarang(){
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }
    
    public void tampilMutasi(){
        System.out.println("Mutasi Perubahan : ");
        for(int i=0;i<=(jumOfMutasi-1);i++){
            System.out.println((i+1)+". "+mutasi[i]);
        }
    }
    
    
    public void tampilInfoBarang(){
        System.out.println("Nama : "+namaBarang);
        System.out.println("Jumlah : "+jumlah);
        if (kondisiBagus==true){
            System.out.println("Kondisi : Layak Pakai");
        }else{
            System.out.println("Kondisi : Tidak Layak Pakai");
        }
        System.out.println();
    }
    
    public void tampilLaporanBarang(){
        System.out.println("Kode : "+kodeBarang);
        System.out.println("Nama : "+namaBarang);
        if (kondisiBagus==true){
            System.out.println("Kondisi : Layak Pakai");
        }else{
            System.out.println("Kondisi : Tidak Layak Pakai");
        }
        System.out.println("Jumlah : "+jumlah);
        //System.out.println("Tanggal Masuk : "+tglMasuk.getDate()+"-"+tglMasuk.getMonth()+"-"+tglMasuk.getYear());
        tampilMutasi();
        System.out.println();
    }

    public String[] getMutasi() {
        return mutasi;
    } 
}