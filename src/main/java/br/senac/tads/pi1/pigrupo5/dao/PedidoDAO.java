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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author rodrigocarvalho
 */
public class PedidoDAO {
    
    public static int adicionar(Pedido p, Cliente c) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatador.format(p.getData());
        int id = -1;
        Connection conexao = null;
        ResultSet rs = null;
        PreparedStatement comandoSQL = null;
        
        try {
            conexao = Conexao.abrirConexao();
            
            comandoSQL = conexao.prepareStatement("INSERT INTO pedido (dataP, valorDesconto, total, id_cliente) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            comandoSQL.setString(1, dataFormatada);
            comandoSQL.setDouble(2, p.getDesconto());
            comandoSQL.setDouble(3, p.getTotal());
            comandoSQL.setInt(4, c.getId());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            rs = comandoSQL.getGeneratedKeys();
            
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            id = -1;
        } finally {
            try {
                if (comandoSQL != null) {
                    comandoSQL.close();
                }
                Conexao.fecharConexao();
            } catch (SQLException e) {
                
            }
        }
        return id;
    }
}
