package inventaris;

public class Penyedia extends Orang{
    private Barang[] daftarBarang = new Barang[100];
    private int numOfBarang;
    private long id;
    private String pass;
	
    public Penyedia(String nama, long id, String pass) {
        super(nama);
	this.id = id;
        this.pass = pass;
    }
	
    public void createBarang(String nb, String kb, int jum, boolean k) {
	daftarBarang[numOfBarang] = new Barang(nb, kb, jum, k);
	numOfBarang++;
    }
    
    public void createBarang(String nb, String kb, int jum) {
	daftarBarang[numOfBarang] = new Barang(nb, kb);
	numOfBarang++;
    }
	
    public void setPass(String pass) {
	this.pass = pass;
    }
	
    public String getPass() {
        return pass;
    }
	
    public long getId() {
	return id;
    }
    
    public Barang getBarang(int i){
        return daftarBarang[i];
    }
    
    public int getNumOfBarang(){
        return numOfBarang;
    }
}