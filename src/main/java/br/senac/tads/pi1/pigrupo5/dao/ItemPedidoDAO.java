/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Produto;
import br.senac.tads.pi1.pigrupo5.model.ItemPedido;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rodrigocarvalho
 */
public class ItemPedidoDAO {
    /**
     * Adicionando Produto no Pedido do Cliente e salvando no Banco
     * 
     * @param p = Nome dado ao Produto
     * @param id = Id do Pedido
     * @return 
     */
    public static boolean adicionarItens(Produto p, int id) {
        boolean retorno;
        Connection conexao = null;
        
        PreparedStatement comandoSQL = null;
        
        try {
            conexao = Conexao.abrirConexao();
            
            comandoSQL = conexao.prepareStatement("INSERT INTO itemPedido (id_pedido, id_produto, qtd, valorUnit) VALUES (?, ?, ?, ?)");
            
           
            comandoSQL.setInt(1, id);
            comandoSQL.setInt(2, p.getId());
            comandoSQL.setInt(3, p.getQtdEstoque());
            comandoSQL.setDouble(4, p.getValor());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                Conexao.fecharConexao();
            } catch (SQLException e) {
                
            }
        }
        return retorno;
    }
/**
 * Lista dos produtos no Pedido, que foi salvo no Banco.
 * 
 * @param id = Id do Pedido
 * @return 
 */
    public static ArrayList<ItemPedido> listarItemPedido(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ArrayList<ItemPedido> listaItemPedido = new ArrayList<ItemPedido>();

        try {
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT itemPedido.id_produto, produto.nome, itemPedido.valorUnit, itemPedido.qtd FROM itemPedido INNER JOIN produto ON itemPedido.id_produto = produto.id WHERE itemPedido.id_pedido = ?");
            comandoSQL.setInt(1, id);

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                ItemPedido objItemPedido = new ItemPedido();
                objItemPedido.setIdProduto(rs.getInt("id_produto"));
                objItemPedido.setNome(rs.getString("nome"));
                objItemPedido.setValorUnit(rs.getDouble("valorUnit"));
                objItemPedido.setQtd(rs.getInt("qtd"));

                listaItemPedido.add(objItemPedido);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listaItemPedido = null;
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
            return listaItemPedido;
        }
    }
}
