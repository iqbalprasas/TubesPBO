package model;

public abstract class Orang {
	private String nama;
        private String pass;
	private int umur;
        private long id;
	private String jenisKel;
	
	public Orang(String nama, String pass, long id) {
		this.nama=nama;
                this.pass=pass;
                this.id=id;
	}
	
	public String getNama() {
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
        
        public String getPass() {
        return pass;
        }

        public void setPass(String pass) {
        this.pass = pass;
        }

        public long getId() {
            return id;
        }
        
        public void tampilProfile(){
            System.out.println("ID : "+id);
            System.out.println("Nama : "+nama);
            System.out.println("Umur : "+umur);
            System.out.println("Jenis Kelamin : "+jenisKel);
        }
        
        public void editProfile(String pass, String jenisKel, int umur){
            this.pass = pass;
            this.jenisKel = jenisKel;
            this.umur = umur;
        }
        
        
}
