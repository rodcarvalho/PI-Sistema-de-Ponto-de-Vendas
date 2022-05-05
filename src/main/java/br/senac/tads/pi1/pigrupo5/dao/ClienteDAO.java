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
import java.sql.SQLException;

/**
 *
 * @author Kaio
 */
public class ClienteDAO {

    public static boolean salvar(Cliente c) {
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
            comandoSQL1.setString(3, c.getNascimento());
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
}
