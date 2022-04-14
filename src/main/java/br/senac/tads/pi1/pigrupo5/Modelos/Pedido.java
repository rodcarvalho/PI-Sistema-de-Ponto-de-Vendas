/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.Modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rodrigocarvalho
 */
public class Pedido {
 
    Date data = new Date();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Integer> quantidades = new ArrayList<Integer>();
    String clienteNome = new String("");
    String clienteCPF = new String("");

    public Pedido() {
    }

    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

     public void insertProduct(Produto prod) {
        produtos.add(prod);
    }
     
    
    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(ArrayList<Integer> quantidades) {
        this.quantidades = quantidades;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }
    
}
