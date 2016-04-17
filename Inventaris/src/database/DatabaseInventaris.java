/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Barang;
import model.Penyedia;
import model.Petugas;

/**
 *
 * @author iqbal
 */
public class DatabaseInventaris {
    private Connection koneksi;
    private Statement s;
    
    public void Connect(){
        try{
            if(koneksi==null){
                new Driver();
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventaris", "root", "");
                s = koneksi.createStatement();
            }
        }catch(SQLException e){
            System.out.println("errorcon");
        }
    }
    
    public void savePetugas(Petugas p){
        try{
            s.executeUpdate("INSERT INTO petugas VALUES ("
                    + "'" + p.getId() + "',"+ "'" + p.getNama() + "',"+ "'" + p.getPass() + "',"+ "'" + p.getUmur() + "',"
                    + "'" + p.getKel() + "');");
        }catch(SQLException e){
            System.out.println("error");
        }
    }
    
    public void savePenyedia(Penyedia p){
        try{
            s.executeQuery("INSERT INTO penyedia VALUES ("
                    + "'" + p.getId() + "',"+ "'" + p.getNama() + "',"+ "'" + p.getPass() + "',"+ "'" + p.getUmur() + "',"
                    + "'" + p.getKel() + "');");
        }catch(SQLException e){
            System.out.println("error");
        }
    }
    
    public void saveBarangGudang(Barang b){
        try{
            /*s.execute("INSERT INTO barang(kode,namabarang,jumlah,kondisi,tglmasuk,tglkeluar) VALUES ("
                    +"'" +b.getKodeBarang()+ "',"+ "'" + b.getNamaBarang() + "',"+ "'" 
                    + b.getJumlah()+"',"+ "'" +b.getKondisiBarang()+ "',"+null+ "',"
                    + "'" +null+ "');",Statement.RETURN_GENERATED_KEYS);*/
            s.execute("INSERT INTO gudang(kode,namabarang,jumlah,kondisi,tglmasuk,tglkeluar) VALUES ("+"'"+b.getKodeBarang()+"','"+b.getNamaBarang()+"',"+
                    b.getJumlah()+","+b.getKondisiBarang()+","+null+","+null+");", Statement.RETURN_GENERATED_KEYS);
            
        }catch(SQLException e){
            System.out.println("errorbaranggudang");
        }
    }
    
    public void saveBarang(Barang b){
        try{
            /*s.execute("INSERT INTO barang(kode,namabarang,jumlah,kondisi,tglmasuk,tglkeluar) VALUES ("
                    +"'" +b.getKodeBarang()+ "',"+ "'" + b.getNamaBarang() + "',"+ "'" 
                    + b.getJumlah()+"',"+ "'" +b.getKondisiBarang()+ "',"+null+ "',"
                    + "'" +null+ "');",Statement.RETURN_GENERATED_KEYS);*/
            s.execute("INSERT INTO barang(kode,namabarang,jumlah,kondisi,tglmasuk,tglkeluar) VALUES ("+"'"+b.getKodeBarang()+"','"+b.getNamaBarang()+"',"+
                    b.getJumlah()+","+b.getKondisiBarang()+",'"+b.getTglMasuk()+"','"+b.getTglKeluar()+"');", Statement.RETURN_GENERATED_KEYS);
            
        }catch(SQLException e){
            System.out.println("Errorbarang");
        }
    }
    
    public Petugas getPetugas(long idPetugas) {
        Petugas p = null;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM petugas WHERE idpetugas = "+idPetugas);
            while (rs.next()) {
                p = new Petugas(rs.getString(2), rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public Penyedia getPenyedia(long idPenyedia) {
        Penyedia p = null;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM penyedia WHERE idpenyedia = "+idPenyedia);
            while (rs.next()) {
                p = new Penyedia(rs.getString(2), rs.getLong(1), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("errorReadPenyedia");
        }
        return p;
    }
    
    public void updatePassPenyedia(long id, String pass){
        try {
            s.executeUpdate("update penyedia set password = "+"'"+pass+"'"+" where idpenyedia="+id+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePassPetugas(long id, String pass){
        try {
            s.executeUpdate("update petugas set password = "+"'"+pass+"'"+" where idpetugas="+id+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String [] getBarang(){
        String kode,nama,jumlah,kondisi;
        String [] ss = new String[100];
        int i=0;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM barang;");
            while (rs.next()) {
                kode = rs.getString(1);
                nama = rs.getString(2);
                jumlah = String.valueOf(rs.getInt(3));
                if(rs.getInt(4)==1){
                    kondisi = "bagus";
                }else{
                    kondisi = "Tidak Bagus";
                }
                ss[i] = kode+"         "+nama+"             "+jumlah+"              "+kondisi;
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("errorgetbarang");
        }
        return ss;
    }
    
    public String [] getBarangGudang(){
        String kode,nama,jumlah,kondisi;
        String [] ss = new String[100];
        int i=0;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM gudang;");
            while (rs.next()) {
                kode = rs.getString(1);
                nama = rs.getString(2);
                jumlah = String.valueOf(rs.getInt(3));
                if(rs.getInt(4)==1){
                    kondisi = "bagus";
                }else{
                    kondisi = "Tidak Bagus";
                }
                ss[i] = kode+"         "+nama+"             "+jumlah+"              "+kondisi;
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ss;
    }
    
    public int getCountBarang(){
        int [] ss = new int[100];
        int i=0;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM barang;");
            while (rs.next()) {
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("errorgetbarang");
        }
        return i;
    }
    
    public Barang findBarang(String kode){
        Barang b=null;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM barang WHERE kode = "+"'"+kode+"';");
            while (rs.next()) {
                b = new Barang(rs.getString("namabarang"),rs.getString("kode"),rs.getString("tglmasuk"));
                b.setJumlah(rs.getInt("jumlah"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("errorReadFindBarang");
        }
        return b;
    }
    
    public Barang findBarangGudang(String kode){
        Barang b=null;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM gudang WHERE kode = "+"'"+kode+"';");
            while (rs.next()) {
                b = new Barang(rs.getString("namabarang"),rs.getString("kode"),rs.getString("tglmasuk"));
                b.setJumlah(rs.getInt("jumlah"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("errorReadFindBarang");
        }
        return b;
    }
    
    public void updateBarang(String kode, int jumlah, int kondisi){
        try {
            s.executeUpdate("update gudang set jumlah ="+jumlah+" where kode='"+kode+"';");
            s.executeUpdate("update gudang set kondisi ="+kondisi+" where kode='"+kode+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isBaranginGudang(String kode){
        String a;
        try {
            ResultSet rs = s.executeQuery("SELECT * FROM gudang;");
            while (rs.next()) {
                if(rs.getString(1).equals(kode)){
                    return true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("errorgetbarang");
        }
        return false;
    }
}
