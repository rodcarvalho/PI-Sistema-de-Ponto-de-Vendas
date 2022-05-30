/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.view;

import br.senac.tads.pi1.pigrupo5.model.Cliente;
import br.senac.tads.pi1.pigrupo5.dao.ClienteDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Kaio
 */
public class BuscaClienteFrame extends javax.swing.JFrame {

    Cliente objCliente;

    /**
     * Creates new form BuscaCliente
     */
    public BuscaClienteFrame() {
        initComponents();

        setLocationRelativeTo(null);
        objCliente = new Cliente();

        CarregarJTableCliente("Código", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblBusca = new javax.swing.JLabel();
        txtParametro = new javax.swing.JComboBox<>();
        btnPesquisa = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        txtBusca = new javax.swing.JFormattedTextField();

        jButton4.setText("Adicionar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "Email", "Telefone", "CEP"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(tblClientes);

    lblBusca.setText("Busca por:");

    txtParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "CPF", "Email", "Telefone", "CEP" }));
    txtParametro.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            txtParametroItemStateChanged(evt);
        }
    });
    txtParametro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtParametroActionPerformed(evt);
        }
    });

    btnPesquisa.setText("Pesquisar");
    btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPesquisaActionPerformed(evt);
        }
    });

    btnExcluir.setText("Excluir");
    btnExcluir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExcluirActionPerformed(evt);
        }
    });

    btnAdicionar.setText("Adicionar");
    btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAdicionarActionPerformed(evt);
        }
    });

    btnAlterar.setText("Alterar");
    btnAlterar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAlterarActionPerformed(evt);
        }
    });

    txtBusca.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtBuscaActionPerformed(evt);
        }
    });
    txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtBuscaKeyTyped(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblBusca)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtBusca)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnPesquisa))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(txtParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Cadastro do Cliente.
 * @param evt 
 */
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        CadastroClienteFrame CadastroCliente = new CadastroClienteFrame();
        CadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed
/**
 * Buscar Cliente
 * @param evt 
 */
    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        CarregarJTableCliente(txtParametro.getSelectedItem().toString(), txtBusca.getText());
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void txtParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParametroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParametroActionPerformed
/**
 * Excluir Cliente
 * @param evt 
 */
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblClientes.getRowCount() > 0) {
            int linha = tblClientes.getSelectedRow();

            if (linha >= 0) {
                int Id = Integer.parseInt(tblClientes.getModel().getValueAt(linha, 0).toString());

                if (ClienteDAO.excluirContatoEndereco(Id)) {
                    if(ClienteDAO.excluirDadosContato(Id)){
                        JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Cliente vinculado a um pedido, foi armazenado os dados basicos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Falha ao excluir cliente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não existem clientes cadastrados neste parametro!");
        }

        CarregarJTableCliente("Código", "");
    }//GEN-LAST:event_btnExcluirActionPerformed
/**
 * Alterar dados do Cliente
 * @param evt 
 */
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tblClientes.getRowCount() > 0) {
            int linha = tblClientes.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(tblClientes.getModel().getValueAt(linha, 0).toString());
                String nome = tblClientes.getModel().getValueAt(linha, 1).toString();
                String cpf = tblClientes.getModel().getValueAt(linha, 2).toString();
                String nascimento = tblClientes.getModel().getValueAt(linha, 3).toString();
                String sexo = tblClientes.getModel().getValueAt(linha, 4).toString();
                String estadoCivil = tblClientes.getModel().getValueAt(linha, 5).toString();
                String email = tblClientes.getModel().getValueAt(linha, 6).toString();
                //Linha 7 é somente para Jtable
                String tipoTelefone = tblClientes.getModel().getValueAt(linha, 8).toString();
                String ddd = tblClientes.getModel().getValueAt(linha, 9).toString();
                String telefone = tblClientes.getModel().getValueAt(linha, 10).toString();
                String logradouro = tblClientes.getModel().getValueAt(linha, 11).toString();
                String bairro = tblClientes.getModel().getValueAt(linha, 12).toString();
                String complemento = tblClientes.getModel().getValueAt(linha, 13).toString();
                String cep = tblClientes.getModel().getValueAt(linha, 14).toString();
                String uf = tblClientes.getModel().getValueAt(linha, 15).toString();
                String cidade = tblClientes.getModel().getValueAt(linha, 16).toString();
                String numEndereco = tblClientes.getModel().getValueAt(linha, 17).toString();

                //Id
                objCliente.setId(id);

                //Dados Básicos
                objCliente.setNome(nome);
                objCliente.setCpf(cpf);
                try {
                    objCliente.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(nascimento));
                } catch (ParseException ex) {
                    Logger.getLogger(BuscaClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                objCliente.setSexo(sexo);
                objCliente.setEstadoCivil(estadoCivil);

                //Contato
                objCliente.setEmail(email);
                objCliente.setTipoTelefone(tipoTelefone);
                objCliente.setDdd(ddd);
                objCliente.setTelefone(telefone);

                //Endereço
                objCliente.setLogradouro(logradouro);
                objCliente.setBairro(bairro);
                objCliente.setComplemento(complemento);
                objCliente.setCep(cep);
                objCliente.setUf(uf);
                objCliente.setCidade(cidade);
                objCliente.setNumEndereco(numEndereco);

                CadastroClienteFrame cadastroCliente = new CadastroClienteFrame(objCliente);
                cadastroCliente.modoTela = "Alterar";

                cadastroCliente.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não existem clientes cadastrados neste parametro!");
        }

        CarregarJTableCliente("Código", "");

    }//GEN-LAST:event_btnAlterarActionPerformed
/**
 * Buscar por Cliente urilizando Informações no Banco
 * @param evt 
 */
    private void txtParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtParametroItemStateChanged
        String parametro = txtParametro.getSelectedItem().toString();
        String texto = txtBusca.getText().trim().replace(".", "").replace("-", "");
        MaskFormatter mask = null;
        DefaultFormatter defaultMask = new DefaultFormatter();;
        defaultMask.install(txtBusca);

        switch (parametro) {
            case ("CPF"): 
                try {
                mask = new MaskFormatter("###.###.###-##");
                mask.install(txtBusca);
            } catch (ParseException ex) {
                Logger.getLogger(BuscaClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case ("Telefone"): 
                try {
                mask = new MaskFormatter("#####-####");
                mask.install(txtBusca);
            } catch (ParseException ex) {
                Logger.getLogger(BuscaClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;

            case ("CEP"):
                try {
                mask = new MaskFormatter("#####-###");
                mask.install(txtBusca);
            } catch (ParseException ex) {
                Logger.getLogger(BuscaClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            default:
                txtBusca.setText(texto);
                break;
        }


    }//GEN-LAST:event_txtParametroItemStateChanged

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        if ((txtBusca.getText() + evt.getKeyChar()).length() > 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaClienteFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaClienteFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaClienteFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaClienteFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaClienteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txtBusca;
    private javax.swing.JComboBox<String> txtParametro;
    // End of variables declaration//GEN-END:variables
/**
 * Buscar Clientes Utilizando dados no Banco.
 * 
 * @param parametro = Parametro da Busca "CPF"
 * @param busca = Valor dentro do parametro para Busca
 */
    private void CarregarJTableCliente(String parametro, String busca) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Cliente> listaClientes = ClienteDAO.consultarClientes(parametro, busca);

        DefaultTableModel tmClientes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //Id
        tmClientes.addColumn("Código");

        //Dados Básicos
        tmClientes.addColumn("Nome");
        tmClientes.addColumn("CPF");
        tmClientes.addColumn("Nascimento");
        tmClientes.addColumn("Sexo");
        tmClientes.addColumn("Estado Civil");

        //Contato
        tmClientes.addColumn("Email");
        tmClientes.addColumn("Telefone"); //DDD+Telefone
        tmClientes.addColumn("Tipo Telefone");
        tmClientes.addColumn("DDD");
        tmClientes.addColumn("Telefone");

        //Endereço
        tmClientes.addColumn("Logradouro");
        tmClientes.addColumn("Bairro");
        tmClientes.addColumn("Complemento");
        tmClientes.addColumn("CEP");
        tmClientes.addColumn("UF");
        tmClientes.addColumn("Cidade");
        tmClientes.addColumn("Número Endereço");
        tblClientes.setModel(tmClientes);

        tmClientes.setRowCount(0);

        for (Cliente c : listaClientes) {
            tmClientes.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), formatador.format(c.getNascimento()), c.getSexo(), c.getEstadoCivil(),
                c.getEmail(), "(" + c.getDdd() + ") " + c.getTelefone(), c.getTipoTelefone(), c.getDdd(), c.getTelefone(),
                c.getLogradouro(), c.getBairro(), c.getComplemento(), c.getCep(), c.getUf(), c.getCidade(), c.getNumEndereco()});
        }

        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(10); //ID
        //Dados Basicos
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(50); //Nome
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(60); //CPF
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(3)); //Nascimento
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(3)); //Sexo
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(3)); //Estado Civil

        //Contato
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(45); //Email
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(75); //(DDD) + Telefone
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //Tipo Telefone
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //DDD
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //Telefone

        //Endereco
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //Logradouro
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //Bairro
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(5)); //Complemento
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(35); //CEP
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(6)); //UF
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(6)); //Cidade
        tblClientes.removeColumn(tblClientes.getColumnModel().getColumn(6)); //NumEndereco
    }
}
