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
import model.Penyedia;
import view.LoginPenyedia;

/**
 *
 * @author iqbal
 */
public class ControllerLoginPenyedia implements ActionListener{
    private Application model;
    private LoginPenyedia lPenyedia;
    private Penyedia pa;
    
    public ControllerLoginPenyedia(Application model){
        this.model = model;
        lPenyedia = new LoginPenyedia();
        lPenyedia.setVisible(true);
        lPenyedia.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(lPenyedia.getBtnLogin())) {
            try {
                if (model.getValidPenyedia((Long.parseLong(lPenyedia.getIdTextField().getText())), lPenyedia.getPassTextField().getText())) {
                    new ControllerMenuUtamaPenyedia(model, lPenyedia.getIdTextField().getText());
                    lPenyedia.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Username harus ID berupa angka");
            }
        } else if (source.equals(lPenyedia.getBtnBack())){
            new ControllerLogin(model);
            lPenyedia.dispose();
        }
    }
}
