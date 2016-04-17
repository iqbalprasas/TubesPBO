package model;

public class Penyedia extends Orang{
    private Barang[] daftarBarang = new Barang[100];
    private int numOfBarang=0;
    private long id;
    private String pass;
	
    public Penyedia(String nama, long id, String pass) {
        super(nama,pass,id);
    }
    
    public  Penyedia (String nama,long id, String pass, int umur, String jeniskel) {
	super(nama,pass,id);
        setUmur(umur);
        setKel(jeniskel);
    }
	
    public void createBarang(String nb, String kb, int jum, boolean k,String tglMasuk) {
	
        daftarBarang[numOfBarang] = new Barang(nb, kb, jum, k, tglMasuk);
	numOfBarang++;
    }
    
    public void createBarang(String nb, String kb, int jum, String tglMasuk) {
	
        daftarBarang[numOfBarang] = new Barang(nb, kb,tglMasuk);
	numOfBarang++;
    }
    
    public void createBarang(String nb, int jum, boolean k, String tglMasuk) {
	
        daftarBarang[numOfBarang] = new Barang(nb, jum, k, tglMasuk);
	numOfBarang++;
    }
    
    public Barang getBarang(int i){
        return daftarBarang[i];
    }
    
    public int getNumOfBarang(){
        return numOfBarang;
    }

    @Override
    public void tampilProfile() {
        super.tampilProfile(); 
    }
    
}