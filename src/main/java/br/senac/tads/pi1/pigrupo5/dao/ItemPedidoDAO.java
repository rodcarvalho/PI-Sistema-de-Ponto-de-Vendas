/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.ItemPedido;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaio
 */
public class ItemPedidoDAO {

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
