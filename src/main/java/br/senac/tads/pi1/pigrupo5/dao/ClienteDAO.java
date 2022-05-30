/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.dao;

import br.senac.tads.pi1.pigrupo5.model.Cliente;
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
public class ClienteDAO {
/**
 * Conectando com o Banco de Dados e adicionando os Dados que ficaram Guardados nele
 * 
 * @param c
 * @return 
 */
    public static boolean adicionar(Cliente c) {
        boolean retorno;
        Connection conexao = null;
        PreparedStatement comandoSQL1 = null;
        PreparedStatement comandoSQL2 = null;
        PreparedStatement comandoSQL3 = null;

        try {
            conexao = Conexao.abrirConexao();

            comandoSQL1 = conexao.prepareStatement("INSERT INTO cliente (nome, cpf, nascimento, sexo, estadoCivil) VALUES (?,?,?,?,?)");
            comandoSQL2 = conexao.prepareStatement("INSERT INTO contato (id_cliente, email, tipoTelefone, ddd, telefone) VALUES (LAST_INSERT_ID(),?,?,?,?)");
            comandoSQL3 = conexao.prepareStatement("INSERT INTO endereco(id_cliente, logradouro, bairro, complemento, cep, uf, cidade, numEndereco) VALUES (LAST_INSERT_ID(),?,?,?,?,?,?,?)");

            //Dados Basicos
            comandoSQL1.setString(1, c.getNome());
            comandoSQL1.setString(2, c.getCpf());
            comandoSQL1.setDate(3, new java.sql.Date(c.getNascimento().getTime()));
            comandoSQL1.setString(4, c.getSexo());
            comandoSQL1.setString(5, c.getEstadoCivil());

            //Contato
            comandoSQL2.setString(1, c.getEmail());
            comandoSQL2.setString(2, c.getTipoTelefone());
            comandoSQL2.setString(3, c.getDdd());
            comandoSQL2.setString(4, c.getTelefone());

            //Endereço
            comandoSQL3.setString(1, c.getLogradouro());
            comandoSQL3.setString(2, c.getBairro());
            comandoSQL3.setString(3, c.getComplemento());
            comandoSQL3.setString(4, c.getCep());
            comandoSQL3.setString(5, c.getUf());
            comandoSQL3.setString(6, c.getCidade());
            comandoSQL3.setString(7, c.getNumEndereco());

            int linhasAfetadas = comandoSQL1.executeUpdate() + comandoSQL2.executeUpdate() + comandoSQL3.executeUpdate();

            if (linhasAfetadas >= 3) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            try {
                if (comandoSQL1 != null || comandoSQL2 != null || comandoSQL3 != null) {
                    comandoSQL1.close();
                    comandoSQL2.close();
                    comandoSQL2.close();
                }
                Conexao.fecharConexao();
            } catch (SQLException e) {
            }
        }

        return retorno;
    }
/**
 * Conectando com o Banco e Atualizando os Dados no mesmo, como as informações do Cliente
 * 
 * @param c
 * @return 
 */
    public static boolean atualizar(Cliente c) {
        boolean retorno;
        Connection conexao = null;
        PreparedStatement comandoSQL1 = null;
        PreparedStatement comandoSQL2 = null;
        PreparedStatement comandoSQL3 = null;

        try {
            conexao = Conexao.abrirConexao();

            comandoSQL1 = conexao.prepareStatement("UPDATE contato SET email = ?, tipoTelefone = ?, ddd = ?, telefone = ? WHERE id_cliente = ?");
            comandoSQL2 = conexao.prepareStatement("UPDATE endereco SET logradouro = ?, bairro = ?, complemento = ?, cep = ?, uf = ?, cidade = ?, numEndereco = ? WHERE id_cliente = ?");
            comandoSQL3 = conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, nascimento = ?, sexo = ?, estadoCivil = ? WHERE id = ? ");

            //Contato
            comandoSQL1.setString(1, c.getEmail());
            comandoSQL1.setString(2, c.getTipoTelefone());
            comandoSQL1.setString(3, c.getDdd());
            comandoSQL1.setString(4, c.getTelefone());
            comandoSQL1.setInt(5, c.getId());
            
            //Endereço
            comandoSQL2.setString(1, c.getLogradouro());
            comandoSQL2.setString(2, c.getBairro());
            comandoSQL2.setString(3, c.getComplemento());
            comandoSQL2.setString(4, c.getCep());
            comandoSQL2.setString(5, c.getUf());
            comandoSQL2.setString(6, c.getCidade());
            comandoSQL2.setString(7, c.getNumEndereco());
            comandoSQL2.setInt(8, c.getId());

            //Dados Basicos
            comandoSQL3.setString(1, c.getNome());
            comandoSQL3.setString(2, c.getCpf());
            comandoSQL3.setDate(3, new java.sql.Date(c.getNascimento().getTime()));
            comandoSQL3.setString(4, c.getSexo());
            comandoSQL3.setString(5, c.getEstadoCivil());
            comandoSQL3.setInt(6, c.getId());

            int linhasAfetadas = comandoSQL1.executeUpdate() + comandoSQL2.executeUpdate() + comandoSQL3.executeUpdate();

            if (linhasAfetadas >= 3) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            try {
                if (comandoSQL1 != null || comandoSQL2 != null || comandoSQL3 != null) {
                    comandoSQL1.close();
                    comandoSQL2.close();
                    comandoSQL2.close();
                }
                Conexao.fecharConexao();
            } catch (SQLException e) {
            }
        }

        return retorno;
    }
/**
 * Utilizando o ID unico do Cliente para excluir o CADASTRO do cliente no banco de dados no qual tinha sido salvo
 * 
 * @param Id
 * @return 
 */
    public static boolean excluir(int Id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL1 = null;
        PreparedStatement comandoSQL2 = null;
        PreparedStatement comandoSQL3 = null;

        try {
            conexao = Conexao.abrirConexao();

            comandoSQL1 = conexao.prepareStatement("DELETE FROM contato WHERE id_cliente = ?");
            comandoSQL1.setInt(1, Id);

            comandoSQL2 = conexao.prepareStatement(" DELETE FROM endereco WHERE id_cliente = ? ");
            comandoSQL2.setInt(1, Id);

            comandoSQL3 = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?");
            comandoSQL3.setInt(1, Id);

            int linhasAfetadas = comandoSQL1.executeUpdate() + comandoSQL2.executeUpdate() + comandoSQL3.executeUpdate();

            if (linhasAfetadas >= 3) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            retorno = false;
        } finally {
            try {
                if (comandoSQL1 != null || comandoSQL2 != null || comandoSQL3 != null) {
                    comandoSQL1.close();
                    comandoSQL2.close();
                    comandoSQL3.close();
                }

                Conexao.fecharConexao();

            } catch (SQLException e) {
            }
        }

        return retorno;
    }
/**
 * Procura no banco de dados utilizando os parametros antes fornecidos e  mostra na tela o resultado
 * 
  * @param txtParametro
 * @param txtBusca
 * @return 
 */
    public static ArrayList<Cliente> consultarClientes(String txtParametro, String txtBusca) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        String parametro = "id";
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        switch (txtParametro) {
            case "Código":
                parametro = "id";
                break;
            default:
                parametro = txtParametro.toLowerCase();
                break;
        }

        try {
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT cliente.id, cliente.nome, cliente.cpf, cliente.nascimento, cliente.sexo, cliente.estadoCivil,"
                    + " contato.email, contato.tipoTelefone, contato.ddd, contato.telefone, "
                    + "endereco.logradouro, endereco.bairro, endereco.complemento, endereco.cep, endereco.uf, endereco.cidade, endereco.numEndereco "
                    + "FROM cliente INNER JOIN contato ON cliente.id = contato.id_cliente INNER JOIN endereco ON cliente.id = endereco.id_cliente WHERE " + parametro + " LIKE ?;");

            comandoSQL.setString(1, "%" + txtBusca + "%");

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();

                //Dados Basicos
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setNascimento(rs.getDate("nascimento"));
                c.setSexo(rs.getString("sexo"));
                c.setEstadoCivil(rs.getString("estadoCivil"));

                //Contato
                c.setEmail(rs.getString("email"));
                c.setTipoTelefone(rs.getString("tipoTelefone"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));

                //Endereco
                c.setLogradouro(rs.getString("logradouro"));
                c.setBairro(rs.getString("bairro"));
                c.setComplemento(rs.getString("complemento"));
                c.setCep(rs.getString("cep"));
                c.setUf(rs.getString("uf"));
                c.setCidade(rs.getString("cidade"));
                c.setNumEndereco(rs.getString("numEndereco"));

                listaClientes.add(c);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listaClientes = null;
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
        return listaClientes;
    }
    
}
