package model;

public class Petugas extends Orang {
    private long id;
    private String pass;
    private int numOfCatat;
	
    public  Petugas (String nama,long id, String pass) {
	super(nama,pass,id);
    }
    public  Petugas (String nama,long id, String pass, int umur, String jeniskel) {
	super(nama,pass,id);
        setUmur(umur);
        setKel(jeniskel);
    }

	
    public void catatBarang(Barang b,Gudang g) {
	g.addBarang(b);
        numOfCatat++;
    }
	
    public void editBarang(Gudang g, String kodeBarang, int jumlah, String kondisiBagus){
	for(int i=0;i<=(g.getNumOfBarang()-1);i++){
            if(g.getBarang(i).getKodeBarang().equals(kodeBarang)){
                g.getBarang(i).setJumlah(jumlah);
                g.getBarang(i).setKondisiBarang(kondisiBagus);
            }
        }
    }
    
    public void editBarang(Gudang g, String kodeBarang, int jumlah){
	for(int i=0;i<=(g.getNumOfBarang()-1);i++){
            if(g.getBarang(i).getKodeBarang().equals(kodeBarang)){
                g.getBarang(i).setJumlah(jumlah);
            }
        }
    }
    
    public void editBarang(Gudang g, String kodeBarang, String kondisiBagus){
	for(int i=0;i<=(g.getNumOfBarang()-1);i++){
            if(g.getBarang(i).getKodeBarang().equals(kodeBarang)){
                g.getBarang(i).setKondisiBarang(kondisiBagus);
            }
        }
    }
	
    public void tampilinfoAll(Gudang g){
	g.tampilGudang();
    }
    
    public void tampilInfo(int i, Gudang g){
        g.getBarang(i).tampilInfoBarang();
    }

    @Override
    public void tampilProfile() {
        super.tampilProfile(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumOfCatat() {
        return numOfCatat;
    }
    
    
    
}