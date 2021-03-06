
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
    /**
     * Adicionando Produto no banco de dados com informações relevantes
     * 
     * @param p = produto
     */
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
     /**
      * Atualizando dados do Produto salvos no Banco com Novas Informaçoes do mesmo.
      * 
      * @param p =  produto
      */
          public void atualizar(Produto p) {
        
        // inicialização da conexão 
        Connection con = null;
        PreparedStatement comandoSQL1 = null;

        try {
            
            con = Conexao.abrirConexao();

            comandoSQL1 = con.prepareStatement("UPDATE produto SET nome = ?, codproduto = ?, qtdEstoque = ?, valor = ?, marca = ?, modelo = ?, cor = ?, descricao = ? WHERE id = ?");


            //informações do produto
            comandoSQL1.setString(1, p.getNome());
            comandoSQL1.setInt(2, p.getCodproduto());
            comandoSQL1.setInt(3, p.getQtdEstoque());
            comandoSQL1.setDouble(4, p.getValor());
            comandoSQL1.setString(5, p.getMarca());
            comandoSQL1.setString(6, p.getModelo()); 
            comandoSQL1.setString(7, p.getCor());
            comandoSQL1.setString(8, p.getDescricao());
            comandoSQL1.setInt(9, p.getId());
            
            


            comandoSQL1.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso");

   } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ e);

        } catch (ClassNotFoundException ex) {
             Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
           Conexao.FecharConexaoProduto(con, comandoSQL1);
            
        }
        
}
          /**
           * Excluir PRODUTO, utilizando o ID do mesmo e Salvado a mudança no Banco.
           * 
           * @param p = nome dado ao Produto
           */
        public void Excluir(Produto p) {
        
        // inicialização da conexão 
        Connection con = null;
        PreparedStatement comandoSQL1 = null;

        try {
            
            con = Conexao.abrirConexao();

            comandoSQL1 = con.prepareStatement("DELETE FROM produto WHERE id = ?");


            //id da linha que deseja excluir
           
            comandoSQL1.setInt(1, p.getId());
            

            comandoSQL1.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso");

   } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ e);

        } catch (ClassNotFoundException ex) {
             Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
           Conexao.FecharConexaoProduto(con, comandoSQL1);
            
        }
        
}
     // aparecer dados da Jtable
      
     /**
      * Listando todos os produtos cadastrados com informações no banco
      * 
      * @return 
      */
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
     
     /**
      * Utilizado para fazer a Busca na Listagem anteriormente feita dos Produtos 
      * no Banco de Dados, Utilizando as Informações antes cadastradas.
      * 
      * @param busca = Valor Salvo no Banco que o Usuario irá usar para Busca.
      * 
      * @param parametro = Nome do parametro no Qual a Informação do valor está 
      * 
      * @return 
      */
     public List<Produto> ListaBusca(String busca, String parametro){
         
         // inicialização da conexão 
        Connection con = null;
        PreparedStatement comandoSQL1 = null;
        ResultSet rs = null;

        // array para receber os valores produtos do banco
        List<Produto> produtos = new ArrayList<>();


         try {
             
             con = Conexao.abrirConexao();
      
             comandoSQL1 = con.prepareStatement("SELECT * FROM produto WHERE " + parametro + " LIKE ?");
             comandoSQL1.setString(1,"%"+busca+"%");
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
     
     /**
      * Buscar Produto no estoque, utilizando Informações e ID do mesmo no banco de dados
      * 
      * @param idBusca = buscar produtos por Id, no estoque no Banco de dados
      * @return 
      */

    public static ArrayList<Produto> buscaProduto(int idBusca) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        
        try {
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT id, qtdEstoque, valor, nome, descricao, modelo, cor, marca  FROM produto WHERE id = ?");
            
            comandoSQL.setInt(1, idBusca);
            
            rs = comandoSQL.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
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
    /**
     * Retira a Quantidade da Informação, qtd'Estoque', de quantos produtos existem em estoque
     * 
     * @param id = produto
     * @param qtd = quantidade
     * @return 
     */
    public static boolean decrementaQtd(int id, int qtd) {
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;
        
        try {
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("UPDATE produto SET qtdEstoque = ? WHERE id = ?");
                 
                
            comandoSQL.setInt(1, qtd);
            comandoSQL.setInt(2, id);
            
            int linhasAfetadas =  comandoSQL.executeUpdate();
            
            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
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
