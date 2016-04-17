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
import model.Penyedia;
import model.Petugas;
import view.Login;

/**
 *
 * @author iqbal
 */
public class ControllerLogin implements ActionListener{
    
    private Login login;
    private Application model;
    
    public ControllerLogin(Application model){
        login = new Login();
        this.model = model;
        login.setVisible(true);
        login.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(login.getBtnPenyedia())){
            new ControllerLoginPenyedia(model);
            login.dispose();
        }else if(source.equals(login.getBtnPetugas())){
            new ControllerLoginPetugas(model);
            login.dispose();
        }else if(source.equals(login.getBtnExit())){
            System.exit(0);
        }
    }
    
}
