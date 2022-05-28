
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Produto;
import br.senac.tads.pi1.pigrupo5.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wellington
 */
public class ProdutoDAO {
    
     public void adicionar(Produto p) {
        
        // inicialização da conexão 
        Connection con = null;
        PreparedStatement comandoSQL1 = null;

        try {
            
            con = Conexao.abrirConexao();

            comandoSQL1 = con.prepareStatement("INSERT INTO produto(nome, codproduto, qtdEstoque, valor, marca, modelo, cor, descricao) VALUES (?,?,?,?,?,?,?,?)");


            //informações do produto
            comandoSQL1.setString(1, p.getNome());
            comandoSQL1.setInt(2, p.getCodproduto());
            comandoSQL1.setInt(3, p.getQtdEstoque());
            comandoSQL1.setDouble(4, p.getValor());
            comandoSQL1.setString(5, p.getMarca());
            comandoSQL1.setString(6, p.getModelo()); 
            comandoSQL1.setString(7, p.getCor());
            comandoSQL1.setString(8, p.getDescricao());
            
            


            comandoSQL1.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");

   } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ e);

        } catch (ClassNotFoundException ex) {
             Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
           Conexao.FecharConexaoProduto(con, comandoSQL1);
            
        }
        
}
     
     public List<Produto> ListaProduto(){
         
         // inicialização da conexão 
        Connection con = null;
        PreparedStatement comandoSQL1 = null;
        ResultSet rs = null;
        
        // array para receber os valores produtos do banco
        List<Produto> produtos = new ArrayList<>();

         try {
             
             con = Conexao.abrirConexao();
      
             comandoSQL1 = con.prepareStatement("SELECT * FROM produto");
             rs = comandoSQL1.executeQuery();
             
            while(rs.next()){
                
                //obter dados
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCodproduto(rs.getInt("codproduto"));
                produto.setQtdEstoque(rs.getInt("qtdEstoque"));
                produto.setValor(rs.getDouble("valor"));
                produto.setMarca(rs.getString("marca"));
                produto.setModelo(rs.getString("modelo"));
                produto.setCor(rs.getString("cor"));
                produto.setDescricao(rs.getString("descricao"));
                produtos.add(produto);
                   
            } 
   
         } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally{
             Conexao.FecharConexaoProduto(con, comandoSQL1, rs);
         }
           return produtos;
     }
     
    public static ArrayList<Produto> buscaProduto(int idBusca) {
        System.out.println("AQUIIIIII = " + idBusca);
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        
        try {
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT id, qtdEstoque, valor, nome, descricao, modelo, cor, marca  FROM produto WHERE id = ?");
            
            comandoSQL.setInt(1, idBusca);
            System.out.println(comandoSQL);
            rs = comandoSQL.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                p.setCodproduto(rs.getInt("id"));
                p.setQtdEstoque(rs.getInt("qtdEstoque"));
                p.setValor(rs.getDouble("valor"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setMarca(rs.getString("marca"));
                
                listaProdutos.add(p); 
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
             listaProdutos = null;
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
        return listaProdutos;
    }
     
}
