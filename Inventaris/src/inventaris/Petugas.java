package inventaris;

public class Petugas extends Orang {
    private long id;
    private String pass;
	
    public  Petugas (String nama,long id, String pass) {
	super(nama);
        this.id = id;
        this.pass = pass;
    }
	
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getPass(){
        return pass;
    }
    
    public long getId() {
	return id;
    }
	
    public void catatBarang(Barang b,Gudang g) {
	g.addBarang(b);
    }
	
    public void editBarang(Gudang g, int i, int jumlah, String kondisiBagus){
	g.getBarang(i).setJumlah(jumlah);
	g.getBarang(i).setKondisiBarang(kondisiBagus);
    }
    
    public void editBarang(Gudang g, int i, int jumlah){
	g.getBarang(i).setJumlah(jumlah);
    }
    
    public void editBarang(Gudang g, int i, String kondisiBagus){
	g.getBarang(i).setKondisiBarang(kondisiBagus);
    }
	
    public void tampilinfoAll(Gudang g){
	g.tampilGudang();
    }
    
    public void tampilInfo(int i, Gudang g){
        g.getBarang(i).tampilInfoBarang();
    }
}