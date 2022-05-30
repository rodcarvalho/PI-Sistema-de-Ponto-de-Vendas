/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Produto;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rodrigocarvalho
 */
public class ItemPedidoDAO {
    
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
}
