/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaio
 */
public class Conexao {

    public static String status = "Não conectado";
    public static String driver = "com.mysql.cj.jdbc.Driver";

    public static String server = "localhost";
    public static String database = "loja";

    public static String login = "root";
    public static String senha = "";

    public static String url;

    public static Connection conexao;

    public Conexao() {
    }

    public static String getStatus() {
        return status;
    }

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
        url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

        if (conexao == null) {

            try {

                Class.forName(driver);
                conexao = DriverManager.getConnection(url, login, senha);

                if (conexao != null) {
                    status = "Conexão realizada com sucesso";
                } else {
                    status = "Falha na conexão";
                }
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException("O driver especificado não foi encontrado.");
            
            } catch(SQLException e){
                throw new SQLException("Falha na conexão");
            }

        } else {
            try {
                if (conexao.isClosed()) {
                    conexao = DriverManager.getConnection(url, login, senha);
                }
            } catch (SQLException e) {
                throw new SQLException("Falha ao fechar a conexão");
            }
        }

        return conexao;
    }
    
    
    public static boolean fecharConexao(){
        boolean retorno;
        
        try {
            if(conexao!=null){
                if(!conexao.isClosed()) conexao.close();
            }
            
            status = "Não conectado";
            retorno = true;
            
        } catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }
    
    public static void FecharConexaoProduto(Connection con){
        
        
            try {
                
             if (con != null){   
                con.close();
            }    
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        
        
    }
    
    public static void FecharConexaoProduto(Connection con, PreparedStatement comandoSQL1){
        
            FecharConexaoProduto(con);
        
            try {
                
             if (comandoSQL1 != null){   
                comandoSQL1.close();
            }    
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
         }
    
    public static void FecharConexaoProduto(Connection con, PreparedStatement comandoSQL1, ResultSet rs){
        
            FecharConexaoProduto(con, comandoSQL1);
        
            try {
                
             if (rs != null){   
                rs.close();
            }    
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
         }
    
    
    
}
