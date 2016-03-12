package inventaris;

import java.util.Date;

public class Barang {
    private String namaBarang;
    private String kodeBarang;
    private int jumlah;
    private boolean kondisiBagus;
    private Date tglMasuk;
    private Date tglKeluar;
    private String mutasi [] = new String[100];
    private int jumOfMutasi;
	
    public Barang(String nb, String kb, int jum, boolean k) {
	namaBarang = nb;
	kodeBarang = kb;
	jumlah = jum;
	kondisiBagus = k;
	tglMasuk = new Date();
	tglKeluar = new Date();
        if(k==true){
            mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear())+" Jumlah : "+String.valueOf(jumlah)+" Kondisi Bagus";
        }else{
            mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear())+" Jumlah : "+String.valueOf(jumlah)+" Kondisi Tidak Bagus";
        }
        jumOfMutasi++;
    }
    public Barang(String nb, String kb){
        namaBarang = nb;
        kodeBarang = kb;
        tglMasuk = new Date();
	tglKeluar = new Date();
        mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear());
        jumOfMutasi++;
    }
	
    public String getNamaBarang() {
        return namaBarang;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah=this.jumlah+jumlah;
        mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear())+" Jumlah : "+String.valueOf(jumlah);
        jumOfMutasi++;
    }
	
    public int getJumlah() {
        return jumlah;   
    }
    
    public void setKondisiBarang(String kb){
        if (kb.equals("bagus")){
            kondisiBagus = true;
            mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear())+" Kondisi Bagus";
        }else{
            kondisiBagus = false;
            mutasi[jumOfMutasi] = String.valueOf(tglMasuk.getDate())+"-"+String.valueOf(tglMasuk.getMonth())+"-"+String.valueOf(tglMasuk.getYear())+" Kondisi Tidak Bagus";
        }
        jumOfMutasi++;
    }
	
    public boolean getKondisiBarang() {
        return kondisiBagus;
    }
	
    public Date getTglMasuk() {
	return tglMasuk;
    }
	
    public Date getTglKeluar() {
        return tglKeluar;
    }
    
    public void tampilMutasi(){
        System.out.println("Mutasi Perubahan : ");
        for(int i=0;i<=(jumOfMutasi-1);i++){
            System.out.println((i+1)+". "+mutasi[i]);
        }
    }
    public void tampilInfoBarang(){
        System.out.println("Kode : "+kodeBarang);
        System.out.println("Nama : "+namaBarang);
        if (kondisiBagus==true){
            System.out.println("Kondisi : Layak Pakai");
        }else{
            System.out.println("Kondisi : Tidak Layak Pakai");
        }
        System.out.println("Jumlah : "+jumlah);
        System.out.println("Tanggal Masuk : "+tglMasuk.getDate()+"-"+tglMasuk.getMonth()+"-"+tglMasuk.getYear());
        tampilMutasi();
        System.out.println();
    }
}