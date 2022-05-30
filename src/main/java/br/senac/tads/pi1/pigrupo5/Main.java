/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5;

import br.senac.tads.pi1.pigrupo5.view.LoginFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kaio
 */
public class Main {

   /**  Main do Sistema, tela Inicial.
    * 
    * @param args 
    */
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
//            try {
//                UIManager.setLookAndFeel(new WindowsLookAndFeel());
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(br.senac.tads.pi1.pigrupo5.Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }

}
