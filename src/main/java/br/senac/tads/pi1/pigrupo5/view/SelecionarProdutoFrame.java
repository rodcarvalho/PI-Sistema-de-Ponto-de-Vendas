/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.view;

import br.senac.tads.pi1.pigrupo5.dao.ProdutoDAO;
import br.senac.tads.pi1.pigrupo5.model.Produto;
import br.senac.tads.pi1.pigrupo5.utils.Validador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaio
 */
public class SelecionarProdutoFrame extends javax.swing.JFrame {

    /**
     * Creates new form SelecionarProdutoFrame
     */
    private Validador validadorCod = new Validador();
    private Validador validadorQtd = new Validador();
    
    private boolean codValido = false;
    private boolean qtdValida = false;
    
    PedidoFrame frame;
    ArrayList<Produto> objProdutos;
    Produto prod;
    int index = -1;
    
    public SelecionarProdutoFrame(PedidoFrame f) {
        initComponents();
        setLocationRelativeTo(null);
        frame = f;
    }
    
    public SelecionarProdutoFrame(PedidoFrame f, Produto p, int i) {
        initComponents();
        frame = f;
        prod = p;
        index = i;
        
        txfCodProduto.setText(Integer.toString(prod.getId()));
        txfCodProduto.setEnabled(false);
        txfQtdProduto.setText(Integer.toString(prod.getQtdEstoque()));
        btnAdicionar.setText("Alterar");
    }

    private SelecionarProdutoFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfCodProduto = new javax.swing.JTextField();
        txfQtdProduto = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cód. Produto:");

        jLabel2.setText("Quantidade:");

        txfCodProduto.setName("Código Produto"); // NOI18N
        txfCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodProdutoActionPerformed(evt);
            }
        });
        txfCodProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodProdutoKeyTyped(evt);
            }
        });

        txfQtdProduto.setName("Quantidade"); // NOI18N
        txfQtdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfQtdProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfQtdProduto)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void buscarProduto(int idProduto) {
        objProdutos = ProdutoDAO.buscaProduto(idProduto);
        if (!objProdutos.isEmpty()) {
            prod = objProdutos.get(0);
        }
    }
    
    private void verificaQtd(int qtdPedida) {
        if (prod.getQtdEstoque() >= qtdPedida) {
            prod.setQtdEstoque(qtdPedida);
            if (index >= 0) {
                frame.alteraNaLista(prod, index);
            } else {
                frame.addItemNaLista(prod);
            }
            this.setVisible(false);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "QUANTIDADE INSUFICIENTE DE: " + prod.getNome()
                                          + "\n Quantidade  estoque: " + prod.getQtdEstoque()
                                          + "\n Quantidade solicitada: " + qtdPedida);
        }
    }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        codValido = validadorCod.ValidarInteiro(this.txfCodProduto);
        qtdValida = validadorQtd.ValidarInteiro(this.txfQtdProduto);
        
        if (codValido && qtdValida) {
            buscarProduto(Integer.parseInt(txfCodProduto.getText()));
            verificaQtd(Integer.parseInt(txfQtdProduto.getText()));
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txfCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodProdutoActionPerformed
        
    }//GEN-LAST:event_txfCodProdutoActionPerformed

    private void txfQtdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfQtdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfQtdProdutoActionPerformed

    private void txfCodProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodProdutoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodProdutoKeyTyped

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
            java.util.logging.Logger.getLogger(SelecionarProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionarProdutoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfCodProduto;
    private javax.swing.JTextField txfQtdProduto;
    // End of variables declaration//GEN-END:variables
}
