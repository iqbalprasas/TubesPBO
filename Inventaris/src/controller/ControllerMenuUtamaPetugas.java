/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Application;
import model.Barang;
import model.Petugas;
import view.MenuUtamaPetugas;

/**
 *
 * @author iqbal
 */
public class ControllerMenuUtamaPetugas implements ActionListener{
    private Application model;
    private MenuUtamaPetugas muPetugas;
    private Petugas ps;
    private Barang tempNb;
    
    public ControllerMenuUtamaPetugas(Application model,String id){
        muPetugas = new MenuUtamaPetugas();
        this.model = model;
        muPetugas.setVisible(true);
        muPetugas.addListener(this);
        ps = model.getPetugas(Long.parseLong(id));
        muPetugas.setId(String.valueOf(ps.getId()));
        muPetugas.setNama(ps.getNama());
        muPetugas.setUmur(String.valueOf(ps.getUmur()));
        muPetugas.setJenisKel(ps.getKel());
        muPetugas.getListBarang().setListData(model.showAllBarang());
        muPetugas.getListAllBarang().setListData(model.showAllBarangGudang());
        muPetugas.getKbSComboBox().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(muPetugas.getSaveButton())){
            if(muPetugas.getPassTextField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
            }else if(this.muPetugas.getPassTextField().getText().length()<6){
                JOptionPane.showMessageDialog(null, "Password minimal 8 digit");
            }else{
                model.updatePassPetugas(ps.getId(), muPetugas.getPassTextField().getText());
                JOptionPane.showMessageDialog(null, "Data telah disimpan");
            }
        }else if(source.equals(muPetugas.getBtnInput())){
            if(muPetugas.getKodeTextField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Kode barang harus diisi");
            }else if(muPetugas.getKodeTextField().getText().length()>1){
                if(model.findBarang(muPetugas.getKodeTextField().getText())!=null){
                    if (model.isBaranginGudang(muPetugas.getKodeTextField().getText())) {
                        JOptionPane.showMessageDialog(null, "Data barang sudah ada digudang");
                    }else{
                        model.catatBarang(model.findBarang(muPetugas.getKodeTextField().getText()));
                        JOptionPane.showMessageDialog(null, "Data barang telah disimpan");
                        muPetugas.getListAllBarang().setListData(model.showAllBarangGudang());
                    }
                }
                
            }
        }else if(source.equals(muPetugas.getSearchButton())){
            if(muPetugas.getKodeSTextField1().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Kode barang harus diisi");
            }else {
                tempNb = model.findBarangGudang(muPetugas.getKodeSTextField1().getText());
                if(tempNb!=null){
                    muPetugas.getNamaSLabel().setText(tempNb.getNamaBarang());
                    muPetugas.getKbSComboBox().setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            }
        
        }else if (source.equals(muPetugas.getBtnSaveEdit())) {
            if (muPetugas.getNamaSLabel().getText().length() > 1) {
                tempNb.setJumlah(Integer.parseInt(muPetugas.getJumSTextField().getText()));
                if (muPetugas.getKbSComboBox().getSelectedIndex() == 0) {
                    tempNb.setKondisiBarang("bagus");
                } else if (muPetugas.getKbSComboBox().getSelectedIndex() == 1) {
                    tempNb.setKondisiBarang("Tidak bagus");
                }
                model.updateBarang(tempNb.getKodeBarang(), tempNb.getJumlah(), tempNb.getKondisiBarang());
                muPetugas.getKodeSTextField1().setText("");
                muPetugas.getNamaSLabel().setText("");
                muPetugas.getJumSTextField().setText("");
                muPetugas.getKbSComboBox().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Data telah diupdate");
            }
        }else if(source.equals(muPetugas.getSearch1Button())){
            if (muPetugas.getKodeS1TextField().getText().length() > 1) {
                System.out.println("1");
                tempNb = model.findBarangGudang(muPetugas.getKodeS1TextField().getText());
                System.out.println("2");
                if (tempNb != null) {
                    muPetugas.getNamaS1Label().setText(tempNb.getNamaBarang());
                    muPetugas.getJumlahS1Label().setText(String.valueOf(tempNb.getJumlah()));
                    if (tempNb.getKondisiBarang() == 1) {
                        muPetugas.getKondisiS1Label().setText("Bagus");
                    } else {
                        muPetugas.getKondisiS1Label().setText("Tidak Bagus");
                    }
                    muPetugas.getMutasiList().setListData(tempNb.getMutasi());
                }else{
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }   
            } else {   
                System.out.println("tes");
                JOptionPane.showMessageDialog(null, "Kode barang harus diisi");
            }
        }else if(source.equals(muPetugas.getLogoutButton())){
            new ControllerLoginPetugas(model);
            muPetugas.dispose();
        }
    }
}
