/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Relatorio;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kaio
 */
public class RelatorioDAO {
/**
 * Consultando Relatorios com base nos Adicionados nos Bancos de Dados.
 * 
 * @param cbParametro = nome da Função na qual o valor está
 * @param txfBusca = valor no qual você vai Procurar o pedido na Lista do Banco
 * @param dataInicio = data da Criação do Pedido
 * @param dataFim = data da Entrega do Pedido
 * @return 
 */
    public static ArrayList<Relatorio> consultarRelatorios(String cbParametro, String txfBusca, Date dataInicio, Date dataFim) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ArrayList<Relatorio> listaRelatorios = new ArrayList<Relatorio>();
        
        if(dataFim == null)
            dataFim = new Date();
        
        if(dataInicio == null)
            dataInicio = new Date(100,0,0,0,0);
        
        switch (cbParametro) {
            case "Cod. Pedido":
                cbParametro = "pedido.id";
                break;
            case "Cod. Cliente":
                cbParametro = "cliente.id";

            default:
                cbParametro = cbParametro.toLowerCase();
                break;
        }

        try {

            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT pedido.id, pedido.id_cliente, cliente.nome, cliente.cpf, pedido.total, pedido.valorDesconto, pedido.dataP FROM pedido INNER JOIN cliente ON pedido.id_cliente = cliente.id WHERE " + cbParametro + " LIKE ? AND pedido.dataP between ? and ?");

            comandoSQL.setString(1, '%' + txfBusca + '%');
            comandoSQL.setDate(2, new java.sql.Date(dataInicio.getTime()));
            comandoSQL.setDate(3, new java.sql.Date(dataFim.getTime()));

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Relatorio r = new Relatorio();

                r.setId(rs.getInt("id"));
                r.setIdCliente(rs.getInt("id_cliente"));
                r.setNomeCliente(rs.getString("nome"));
                r.setCpf(rs.getString("cpf"));
                r.setTotal(rs.getDouble("total"));
                r.setDesconto(rs.getDouble("valorDesconto"));
                r.setDataPedido(rs.getDate("dataP"));

                listaRelatorios.add(r);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listaRelatorios = null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (comandoSQL != null) {
                    comandoSQL.close();
                }

                Conexao.fecharConexao();

            } catch (SQLException e) {
            }
        }

        return listaRelatorios;
    }
}
