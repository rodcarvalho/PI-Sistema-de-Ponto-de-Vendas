/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.utils;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rodrigocarvalho
 */
public class Validador {
    public static ArrayList<String> mensagensErro = new ArrayList<>();
    /**
     * validando mesagens de erro
     * @return 
     */
    public static ArrayList<String> getMensagensErro() {
        return mensagensErro;
    }
    /**
     * validando Textos, e mostrando mensagens de erro.
     * 
     * @param txt = escrito pelo ususario 
     * @return 
     */
    public static boolean ValidarInteiro(JTextField txt) {
        try {
            if (txt.getText().equals("")){
                throw new  IllegalArgumentException();
            }
            
            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.white);
            return true;
        } catch (NumberFormatException e) {
            mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro");
            txt.setBackground(Color.red);
            txt.setText("");
            return false;
        } catch (IllegalArgumentException e) {
            mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
            txt.setText("");
            return false;
        } catch (Exception e) {
            mensagensErro.add(e.getMessage());
            txt.setText("");
            return false;
        }
        finally {
            if (!mensagensErro.isEmpty()){
               JOptionPane.showMessageDialog(txt, Validador.getMensagensErro());
               mensagensErro.clear();
            }
        }
    }
}
