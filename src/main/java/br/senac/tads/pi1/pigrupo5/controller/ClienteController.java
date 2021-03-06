/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.controller;

import br.senac.tads.pi1.pigrupo5.dao.ClienteDAO;
import br.senac.tads.pi1.pigrupo5.model.Cliente;
import java.util.Date;

/**
 *
 * @author Kaio
 */
public class ClienteController {

    // 0 - Adicionar
    // 1 - Atualizar
    // Id = 0 para adicionar
    /**
     * Cadastrar ou Adicionar Novo Cliente e Gaurdar ele no Banco, 
     * utilizando os parametros dados abaixo como informações guardadas no banco.
     * 
     * @param parametro
     * @param id
     * @param nome
     * @param cpf
     * @param nascimento
     * @param sexo
     * @param estadoCivil
     * @param email
     * @param tipoTelefone
     * @param ddd
     * @param telefone
     * @param logradouro
     * @param bairro
     * @param complemento
     * @param cep
     * @param uf
     * @param cidade
     * @param numEndereco
     * @return 
     */
    public static boolean salvar(int parametro, int id, String nome, String cpf, Date nascimento, String sexo, String estadoCivil,
            String email, String tipoTelefone, String ddd, String telefone,
            String logradouro, String bairro, String complemento, String cep, String uf, String cidade, String numEndereco) {

        Cliente obj = new Cliente();

        //Id
        if (id > 0) {
            obj.setId(id);
        }

        //Dados Basicos
        obj.setNome(nome);
        obj.setCpf(cpf);
        obj.setNascimento(nascimento);
        obj.setSexo(sexo);
        obj.setEstadoCivil(estadoCivil);

        //Contato
        obj.setEmail(email);
        obj.setTipoTelefone(tipoTelefone);
        obj.setDdd(ddd);
        obj.setTelefone(telefone);

        //Endereço
        obj.setLogradouro(logradouro);
        obj.setBairro(bairro);
        obj.setComplemento(complemento);
        obj.setCep(cep);
        obj.setUf(uf);
        obj.setCidade(cidade);
        obj.setNumEndereco(numEndereco);

        if (parametro == 0) {
            return ClienteDAO.adicionar(obj);
        } else {
            return ClienteDAO.atualizar(obj);
        }
    }

}
