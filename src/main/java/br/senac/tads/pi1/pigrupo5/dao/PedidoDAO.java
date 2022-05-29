/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Cliente;
import br.senac.tads.pi1.pigrupo5.model.Pedido;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author rodrigocarvalho
 */
public class PedidoDAO {
    
    public static boolean adicionar(Pedido p, Cliente c){
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatador.format(p.getData());
        boolean retorno;
        Connection conexao = null;
        
        PreparedStatement comandoSQL = null;
        
        try {
            conexao = Conexao.abrirConexao();
            
            comandoSQL = conexao.prepareStatement("INSERT INTO pedido (dataP, valorDesconto, total, id_cliente) VALUES (?, ?, ?, ?)");
            
            comandoSQL.setString(1, dataFormatada);
            comandoSQL.setDouble(2, p.getDesconto());
            comandoSQL.setDouble(3, p.getTotal());
            comandoSQL.setInt(4, c.getId());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if (linhasAfetadas == 1) {
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
