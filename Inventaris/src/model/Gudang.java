package model;

public class Gudang {
    private Barang[] daftarBarang;
    private int numOfBarang;
    private int maxGudang;
    
    public Gudang(int maxGudang){
        this.maxGudang = maxGudang;
        daftarBarang = new Barang[maxGudang];
    }
    public void addBarang(Barang b) {
        daftarBarang[numOfBarang] = b;
        numOfBarang++;
    }
    public void tampilGudang(){
        for (int i=0;i<=(numOfBarang-1);i++){
            daftarBarang[i].tampilLaporanBarang();
        }
    }
    public Barang getBarang(int i){
        return daftarBarang[i];
    }
    
    public int getNumOfBarang(){
        return numOfBarang;
    }
}
	
