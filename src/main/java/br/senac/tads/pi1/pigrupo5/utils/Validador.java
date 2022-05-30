/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rodrigocarvalho
 */


public class Validador {

    public static ArrayList<String> mensagensErro = new ArrayList<>();

    public static ArrayList<String> getMensagensErro() {
        return mensagensErro;
    }

    public static boolean ValidarInteiro(JTextField txt) {
        try {
            if (txt.getText().equals("")) {
                throw new IllegalArgumentException();
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
        } finally {
            if (!mensagensErro.isEmpty()) {
                JOptionPane.showMessageDialog(txt, Validador.getMensagensErro());
                mensagensErro.clear();
            }
        }
    }

    public static boolean ValidarDouble(JTextField txt) {
        try {
            if (txt.getText().equals("")) {
                throw new IllegalArgumentException();
            }

            double valorConvertido = Double.parseDouble(txt.getText());
            txt.setBackground(Color.white);
            return true;
        } catch (NumberFormatException e) {
            mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em double");
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
        } finally {
            if (!mensagensErro.isEmpty()) {
                JOptionPane.showMessageDialog(txt, Validador.getMensagensErro());
                mensagensErro.clear();
            }
        }
    }

    public static boolean ObrigarCampo(JTextField txt) {
        boolean retorno;
        int comprimento = (int) txt.getSize().getHeight();
        if (txt.getText().replace("-", "").replace(".", "").trim().equals("")) {
            txt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            retorno = false;
        } else {
            txt.setBorder(new JTextField().getBorder());

            retorno = true;
        }

        txt.setPreferredSize(new Dimension(22, comprimento));
        return retorno;
    }

}
