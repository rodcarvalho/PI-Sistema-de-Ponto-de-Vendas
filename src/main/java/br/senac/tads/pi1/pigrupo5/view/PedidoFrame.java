/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.pigrupo5.view;

import br.senac.tads.pi1.pigrupo5.model.Cliente;
import br.senac.tads.pi1.pigrupo5.model.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author rodrigocarvalho
 */
public class PedidoFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    public Cliente c;
    public ArrayList<Produto> itensLista = new ArrayList<Produto>();
    double total = 0.0;
    double desconto = 0.0;
    double subtotal = 0.0;
    
    public PedidoFrame() {
        initComponents();
        configuraTable();
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
        pnlOrderItens = new javax.swing.JScrollPane();
        tblOrderItens = new javax.swing.JTable();
        pnlValueLabels = new javax.swing.JPanel();
        lblDiscountValue = new javax.swing.JLabel();
        pnlDiscountLabel = new javax.swing.JPanel();
        lblDiscount = new javax.swing.JLabel();
        lblTotalValue = new javax.swing.JLabel();
        pnlTotalLabel = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        pnlSubtotalLabel = new javax.swing.JPanel();
        lblSubtotal = new javax.swing.JLabel();
        lblSubtotalValue = new javax.swing.JLabel();
        pnlOpenHeader = new javax.swing.JPanel();
        lblOpen = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        btnAddCustomer = new javax.swing.JButton();
        btnFinishOrder = new javax.swing.JButton();
        pnlItensButtons = new javax.swing.JPanel();
        btnDeleteItem = new javax.swing.JButton();
        btnEditItem = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlCliente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblHeaderInfo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuBuscaCliente = new javax.swing.JMenuItem();
        mnuCadastroCLiente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblOrderItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Valor Unitário", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlOrderItens.setViewportView(tblOrderItens);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlOrderItens, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOrderItens)
        );

        pnlValueLabels.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDiscountValue.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblDiscountValue.setText("00,00");

        pnlDiscountLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDiscount.setBackground(new java.awt.Color(51, 51, 51));
        lblDiscount.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblDiscount.setForeground(new java.awt.Color(153, 0, 0));
        lblDiscount.setText("Desconto");

        javax.swing.GroupLayout pnlDiscountLabelLayout = new javax.swing.GroupLayout(pnlDiscountLabel);
        pnlDiscountLabel.setLayout(pnlDiscountLabelLayout);
        pnlDiscountLabelLayout.setHorizontalGroup(
            pnlDiscountLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiscountLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDiscountLabelLayout.setVerticalGroup(
            pnlDiscountLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiscountLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTotalValue.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTotalValue.setText("00,00");

        pnlTotalLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 153));
        lblTotal.setText("Total");

        javax.swing.GroupLayout pnlTotalLabelLayout = new javax.swing.GroupLayout(pnlTotalLabel);
        pnlTotalLabel.setLayout(pnlTotalLabelLayout);
        pnlTotalLabelLayout.setHorizontalGroup(
            pnlTotalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTotalLabelLayout.setVerticalGroup(
            pnlTotalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal)
                .addContainerGap())
        );

        pnlSubtotalLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSubtotal.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblSubtotal.setText("Subtotal");

        javax.swing.GroupLayout pnlSubtotalLabelLayout = new javax.swing.GroupLayout(pnlSubtotalLabel);
        pnlSubtotalLabel.setLayout(pnlSubtotalLabelLayout);
        pnlSubtotalLabelLayout.setHorizontalGroup(
            pnlSubtotalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtotalLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSubtotalLabelLayout.setVerticalGroup(
            pnlSubtotalLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtotalLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSubtotal)
                .addContainerGap())
        );

        lblSubtotalValue.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblSubtotalValue.setText("00,00");

        javax.swing.GroupLayout pnlValueLabelsLayout = new javax.swing.GroupLayout(pnlValueLabels);
        pnlValueLabels.setLayout(pnlValueLabelsLayout);
        pnlValueLabelsLayout.setHorizontalGroup(
            pnlValueLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValueLabelsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValueLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSubtotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlValueLabelsLayout.createSequentialGroup()
                        .addGroup(pnlValueLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalValue)
                            .addComponent(lblDiscountValue, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(pnlDiscountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlValueLabelsLayout.setVerticalGroup(
            pnlValueLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValueLabelsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSubtotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtotalValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDiscountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiscountValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalValue)
                .addContainerGap())
        );

        pnlOpenHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOpen.setBackground(new java.awt.Color(0, 0, 255));
        lblOpen.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblOpen.setForeground(new java.awt.Color(0, 0, 0));
        lblOpen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOpen.setText("Caixa Aberto");

        javax.swing.GroupLayout pnlOpenHeaderLayout = new javax.swing.GroupLayout(pnlOpenHeader);
        pnlOpenHeader.setLayout(pnlOpenHeaderLayout);
        pnlOpenHeaderLayout.setHorizontalGroup(
            pnlOpenHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOpenHeaderLayout.setVerticalGroup(
            pnlOpenHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAddCustomer.setText("Adicionar o cliente");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnFinishOrder.setText("Finalizar Pedido");

        pnlItensButtons.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 4, true));
        pnlItensButtons.setForeground(new java.awt.Color(255, 255, 255));

        btnDeleteItem.setText("Excluir Item");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        btnEditItem.setText("Editar Quantidade");
        btnEditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditItemActionPerformed(evt);
            }
        });

        btnAddItem.setText("Adicionar Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlItensButtonsLayout = new javax.swing.GroupLayout(pnlItensButtons);
        pnlItensButtons.setLayout(pnlItensButtonsLayout);
        pnlItensButtonsLayout.setHorizontalGroup(
            pnlItensButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItensButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlItensButtonsLayout.setVerticalGroup(
            pnlItensButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlItensButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddItem, btnDeleteItem});

        jButton1.setText("Aplicar Desconto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(btnFinishOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlItensButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlItensButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinishOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddCustomer, btnFinishOrder, jButton1});

        pnlCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNome.setText("Nome:");

        lblCPF.setText("CPF:");

        lblDataNascimento.setText("Data de Nascimento:");

        lblCEP.setText("CEP:");

        lblLogradouro.setText("Logradouro: ");

        lblTelefone.setText("Telefone:");

        lblEmail.setText("E-mail:");

        lblCidade.setText("Endereço:");

        lblHeaderInfo.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblHeaderInfo.setForeground(new java.awt.Color(51, 51, 51));
        lblHeaderInfo.setText("Informações do Cliente");

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCPF)
                            .addComponent(lblDataNascimento)
                            .addComponent(lblLogradouro))
                        .addGap(209, 209, 209)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addComponent(lblTelefone)
                            .addComponent(lblCEP)
                            .addComponent(lblEmail)))
                    .addComponent(lblHeaderInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeaderInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCidade))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogradouro)))
                .addContainerGap())
        );

        jMenu1.setText("Produtos");

        mnuProduto.setText("Produtos");
        mnuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(mnuProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        mnuBuscaCliente.setText("Buscar Cliente");
        mnuBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBuscaClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuBuscaCliente);

        mnuCadastroCLiente.setText("Cadastrar Cliente");
        mnuCadastroCLiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroCLienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCadastroCLiente);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        mnuRelatorio.setText("Relatórios");
        mnuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatorioActionPerformed(evt);
            }
        });
        jMenu3.add(mnuRelatorio);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlValueLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlOpenHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOpenHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlValueLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void preencheInfoCliente(Cliente c) { 
        this.lblNome.setText("Nome: " + c.getNome());
        this.lblCPF.setText("CPF: " + c.getCpf());
        this.lblDataNascimento.setText("Data de Nascimento: " + c.getNascimento());
        this.lblLogradouro.setText("Logradouro: " + c.getLogradouro() + ", " + c.getNumEndereco());
        this.lblCidade.setText("Cidade: " + c.getCidade());
        this.lblCEP.setText("CEP: " + c.getCep());
        this.lblEmail.setText("E-mail: " + c.getEmail());
        this.lblTelefone.setText("Telefone: (" + c.getDdd() + ")" + c.getTelefone());
    }
    
    public void calculaSubtotal() {
        subtotal = 0;
        for (Produto p: itensLista) {
            int qtd = p.getQtdEstoque();
            double valorUnit = p.getValor();
            
            double valorItem = qtd * valorUnit;
            
            subtotal += valorItem;
        }
        this.lblSubtotalValue.setText(Double.toString(subtotal));
    }
    
    public void inserirDesconto(double desc) {
        desconto = desc;
        
        if (desconto > 0) {
            this.lblDiscountValue.setText(Double.toString(desconto));
        }
        
        atualizaTable();
    }
    
    public void calculaTotal() {
        calculaSubtotal();
        total = subtotal - desconto;
        
        this.lblTotalValue.setText(Double.toString(total));
    }
    
    public void alteraNaLista(Produto p,int index) {
        itensLista.get(index).setQtdEstoque(p.getQtdEstoque());
        atualizaTable();
    }
    
    public void addItemNaLista(Produto p) {
        if (itensLista.isEmpty()){
            itensLista.add(p);
        } else {
            boolean naoExiste = true;
            for (Produto prod: itensLista) {
                if (prod.getId() == p.getId()) {
                    naoExiste = false;
                    prod.setQtdEstoque(prod.getQtdEstoque() + p.getQtdEstoque());
                }
            }
            if (naoExiste) {
                itensLista.add(p);
            }
        }
        
        atualizaTable();
    }
    
    private void configuraTable() {
        DefaultTableModel tmItens = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tmItens.addColumn("Código");
        tmItens.addColumn("Nome");
        tmItens.addColumn("Quantidade");
        tmItens.addColumn("Valor Unitário");
        tmItens.addColumn("Valor do Item");
        tblOrderItens.setModel(tmItens);
        
        tmItens.setRowCount(0);
        
        tblOrderItens.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblOrderItens.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblOrderItens.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblOrderItens.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblOrderItens.getColumnModel().getColumn(4).setPreferredWidth(10);
    }
    public void atualizaTable() {
        DefaultTableModel tmItens = (DefaultTableModel) tblOrderItens.getModel();
        tmItens.setRowCount(0);
        for (Produto p: itensLista) {
            tmItens.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getQtdEstoque(),
                p.getValor(),
                p.getQtdEstoque() * p.getValor()
            });
        }
        
        calculaTotal();
    }
    
    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        SelecionarProdutoFrame SelecionarProduto = new SelecionarProdutoFrame(this);
        SelecionarProduto.setVisible(true);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        if (tblOrderItens.getRowCount() > 0) {
            int linha = tblOrderItens.getSelectedRow();
            if (linha >= 0) {
                itensLista.remove(linha);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um item da lista");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não existem itens na lista");
        }
        atualizaTable();
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void mnuCadastroCLienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroCLienteActionPerformed
        CadastroClienteFrame CadastroCliente  = new CadastroClienteFrame();
        CadastroCliente.setVisible(true);
    }//GEN-LAST:event_mnuCadastroCLienteActionPerformed

    private void mnuBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBuscaClienteActionPerformed
        BuscaClienteFrame BuscaCliente  = new BuscaClienteFrame();
        BuscaCliente.setVisible(true);
    }//GEN-LAST:event_mnuBuscaClienteActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        SelecionarClienteFrame SelecionarCliente  = new SelecionarClienteFrame(this);
        SelecionarCliente.setVisible(true);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void mnuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutoActionPerformed
        BuscarProdutoFrame BuscaProduto = new BuscarProdutoFrame();
        BuscaProduto.setVisible(true);
    }//GEN-LAST:event_mnuProdutoActionPerformed

    private void mnuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorioActionPerformed
        BuscaRelatorioFrame BuscaRelatorio = new BuscaRelatorioFrame();
        BuscaRelatorio.setVisible(true);
    }//GEN-LAST:event_mnuRelatorioActionPerformed

    private void btnEditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditItemActionPerformed
        if (tblOrderItens.getRowCount() > 0) {
            int linha = tblOrderItens.getSelectedRow();
            if (linha >= 0) {
                Produto p = itensLista.get(linha);
                SelecionarProdutoFrame SelecionarProduto = new SelecionarProdutoFrame(this, p, linha);
                SelecionarProduto.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um item da lista");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não existem itens na lista");
        }
        atualizaTable();
    }//GEN-LAST:event_btnEditItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DescontoFrame descontoFrame = new DescontoFrame(this);
        descontoFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnEditItem;
    private javax.swing.JButton btnFinishOrder;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDiscountValue;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHeaderInfo;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOpen;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalValue;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalValue;
    private javax.swing.JMenuItem mnuBuscaCliente;
    private javax.swing.JMenuItem mnuCadastroCLiente;
    private javax.swing.JMenuItem mnuProduto;
    private javax.swing.JMenuItem mnuRelatorio;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlDiscountLabel;
    private javax.swing.JPanel pnlItensButtons;
    private javax.swing.JPanel pnlOpenHeader;
    private javax.swing.JScrollPane pnlOrderItens;
    private javax.swing.JPanel pnlSubtotalLabel;
    private javax.swing.JPanel pnlTotalLabel;
    private javax.swing.JPanel pnlValueLabels;
    private javax.swing.JTable tblOrderItens;
    // End of variables declaration//GEN-END:variables
}
