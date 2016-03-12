package inventaris;

public abstract class Orang {
	private String nama;
	private int umur;
	private String jenisKel;
	
	public Orang(String nama) {
		this.nama=nama;
	}
	
	public String getNama(String nama) {
		return nama;
	}
	
	public void setUmur(int umur) {
		this.umur = umur;
	}
	
	public int getUmur() {
		return umur;
	}
	
	public void setKel(String jenisKel) {
		this.jenisKel = jenisKel;
	}
	
	public String getKel() {
		return jenisKel;
	}
}
