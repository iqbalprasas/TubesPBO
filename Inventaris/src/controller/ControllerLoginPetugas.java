/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Application;
import model.Petugas;
import view.LoginPetugas;

/**
 *
 * @author iqbal
 */
public class ControllerLoginPetugas implements ActionListener{

    private Application model;
    private LoginPetugas lPetugas;
    private Petugas ps;
    
    public ControllerLoginPetugas(Application model){
        this.model = model;
        lPetugas = new LoginPetugas();
        lPetugas.setVisible(true);
        lPetugas.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(lPetugas.getBtnLogin())){
            try {
                if (model.getValidPetugas((Long.parseLong(lPetugas.getIdTextField().getText())), lPetugas.getPassTextField().getText())) {
                    new ControllerMenuUtamaPetugas(model, lPetugas.getIdTextField().getText());
                    lPetugas.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                }
            } catch (NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Username harus ID berupa angka");
            }
        }else if(source.equals(lPetugas.getBtnBack())){
            new ControllerLogin(model);
            lPetugas.dispose();
        }
    }
    
}
