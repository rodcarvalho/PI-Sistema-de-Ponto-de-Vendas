/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rodrigocarvalho
 */


public class Validador {

    public static ArrayList<String> mensagensErro = new ArrayList<>();
/**
 * Validando a Entrada de Dados e Retornando mensagem de Erro.
 * 
 * @return 
 */
    public static ArrayList<String> getMensagensErro() {
        return mensagensErro;
    }
/**
 * Validando apenas textos completos
 * 
 * @param txt = validar o Campo escrito
 * @return 
 */
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
/**
 * Validando Textos com utilização de "," e compostos
 * 
 * @param txt = Validando o Campo escrito
 * @return 
 */
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

    
    /**
     * Compara a Data de Inicio e Fim, para garantir que a De inicio não é 
     * maior que a Final.
     * 
     * @param dcInicio= data de Inicio
     * @param dcFim= data de Finalização
     * @return 
     */
    public static boolean CompararData(JDateChooser dcInicio, JDateChooser dcFim ) {
        Date dataInicio = dcInicio.getDate();
        Date dataFim = dcFim.getDate();
        
        if(dataFim == null)
            dataFim = new Date();
        
        if(dataInicio == null)
            dataInicio = new Date(100,0,0,0,0);
        
        if (dataInicio.before(dataFim)) {
            dcInicio.setBorder(new JDateChooser().getBorder());
            dcFim.setBorder(new JDateChooser().getBorder());
            return true;
        } else {
            dcInicio.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            dcFim.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            return false;
        }
        
    }
    
/**
 * Validando somente quando houver algo escrito e Mostrar mensagem de Erro
 * 
 * @param txt = campo de Escrita
 * @return 
 */
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
    /**
     * Validar somente quando Houver data escrita se não mostrar Mensagem de Erro
     * 
     * @param data = Campo de Escrita de Data
     * @return 
     */
    public static boolean ObrigarCampo(JDateChooser data) {
        boolean retorno;
        int altura = (int) data.getSize().getHeight();
        Date data1 = data.getDate();
        
        if (data1 == null || data1.after(new Date())) {
            data.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            retorno = false;
        } else {
            data.setBorder(new JDateChooser().getBorder());
            retorno = true;
        }

        data.setPreferredSize(new Dimension(22, altura));
        return retorno;
    }

}
