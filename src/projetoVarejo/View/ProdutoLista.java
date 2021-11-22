/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoVarejo.View;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetoVarejo.DAO.ProdutoDAO;
import projetoVarejo.OBJECTS.Produto;

/**
 *
 * @author Deyvid Yancey
 */
public class ProdutoLista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProdutoLista
     */
    public ProdutoLista() {
        initComponents();
        listar();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel1.setBackground(new java.awt.Color(50, 66, 91));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 109, 127));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de  D e  P r o d u t o s");

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço de compra", "Preço de venda", "Estoque", "Fornecedor", "Unidade", "Porcentagem de lucro", "Tipo"
            }
        ));
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        jButton1.setText("Pesquisar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nome do Produto:");

        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
       /* jTabbedPane1.setSelectedIndex(0);
        tfCodigo.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0).toString());
        tfNome.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
        ftPRECODECOMPRA.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
        tfPRECODEVENDA.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
        tfESTOQUE.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 4).toString());
        cbFORNECEDOR.setSelectedItem(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 5).toString());
        tfUNIDADE.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 6).toString());
        tfPORCENTAGEM.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 7).toString());
        cbTIPO.setSelectedItem(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 8).toString());
*/
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void tfPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyPressed
     try {
            String nome = "%" + tfPesquisar.getText() + "%";
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> lista = dao.buscarProdutoPorNome(nome);
            DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
            dados.setNumRows(0);
            for (Produto c : lista) {
                dados.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getPrecoDeCompra(),
                    c.getPrecoDeVenda(),
                    c.getEstoque(),
                    c.getFornecedor(),
                    c.getUnidade(),
                    c.getPorcentagem(),
                    c.getTipo()
                });

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erro no formulario pesquisar" + e);
        }
    }//GEN-LAST:event_tfPesquisarKeyPressed

 public void listar() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarProduto();
        DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
        dados.setNumRows(0);
        for (Produto c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getPrecoDeCompra(),
                c.getPrecoDeVenda(),
                c.getEstoque(),
                c.getFornecedor(),
                c.getUnidade(),
                c.getPorcentagem(),
                c.getTipo()
            });

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}