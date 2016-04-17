/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris;

import controller.ControllerLogin;
import model.Application;
import model.Console;

/**
 *
 * @author iqbal
 */
public class Driver {
    public static void main(String args[]){
        /*Console console = new Console();
        console.menuUtama();*/
        Application app = new Application();
        new ControllerLogin(app);
    }
}
