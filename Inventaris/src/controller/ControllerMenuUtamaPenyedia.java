/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import model.Application;
import model.Barang;
import model.Penyedia;
import view.MenuUtamaPenyedia;

/**
 *
 * @author iqbal
 */
public class ControllerMenuUtamaPenyedia implements ActionListener,FocusListener{
    private Application model;
    private MenuUtamaPenyedia muPenyedia;
    private Penyedia pa;
    private Barang tempNb;
    
    public ControllerMenuUtamaPenyedia(Application model,String id){
        muPenyedia = new MenuUtamaPenyedia();
        this.model = model;
        muPenyedia.setVisible(true);
        muPenyedia.addListener(this);
        muPenyedia.getPassTextField().addFocusListener(this);
        pa = model.getPenyedia(Long.parseLong(id));
        muPenyedia.setIdPenyedia(String.valueOf(pa.getId()));
        muPenyedia.setNamaPenyedia(pa.getNama());
        muPenyedia.setUmur(String.valueOf(pa.getUmur()));
        muPenyedia.setJenisKel(String.valueOf(pa.getKel()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(muPenyedia.getSaveButton())){
            if(this.muPenyedia.getPassTextField().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
            }else if(this.muPenyedia.getPassTextField().getText().length()<6){
                JOptionPane.showMessageDialog(null, "Password minimal 8 digit");
            }else{
                model.updatePassPenyedia(pa.getId(), muPenyedia.getPassTextField().getText());
                JOptionPane.showMessageDialog(null, "Data telah disimpan");
            }
        }else if(source.equals(muPenyedia.getBtnCreate())){
            if((muPenyedia.getNbTextField().getText().length()<1||muPenyedia.getJbTextField().getText().length()<1)||
              (((int)muPenyedia.getTglSpinner().getValue())<1||((int)muPenyedia.getBlnSpinner().getValue())<1)){
                JOptionPane.showMessageDialog(null, "Data harus terisi semua");
            }else{
                String tgl = ((muPenyedia.getTglSpinner().getValue().toString())+"-"+(muPenyedia.getBlnSpinner().getValue().toString()+"-"+
                        (muPenyedia.getThnSpinner().getValue().toString())));
                model.createBarang(muPenyedia.getNbTextField().getText(),Integer.parseInt(muPenyedia.getJbTextField().getText()),
                        muPenyedia.getKbComboBox().getSelectedIndex(), tgl);
                JOptionPane.showMessageDialog(null, "Data Barang berhasil dibuat");
            }
        }else if(source.equals(muPenyedia.getLogoutButton())){
            new ControllerLoginPenyedia(model);
            muPenyedia.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object source = e.getSource();
        if(source.equals(this.muPenyedia.getPassTextField())){
            
        }
    }
}
