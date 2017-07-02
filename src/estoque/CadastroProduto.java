/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.fabricantesDAO;
import DAO.produtoDAO;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class CadastroProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
        initComponents();
        this.preencheJComboBoxFabricantes();
        this.preencheID();
    }

    /**
     * Preenche campo de ID na tela do sistema
     */
    public void preencheID() {
        ResultSet result;
        String sql = "select max(idmodelo+1) from modelo";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jTid.setText((result.getString("max")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * Preenche campo de fabricantes na tela do sistema
     */
    public void preencheJComboBoxFabricantes() {
        ResultSet result;
        String sql = "SELECT * FROM fabricantes WHERE disponibilidade = true";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBfabricantes.addItem(result.getString("razaosocial"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTmodelo = new javax.swing.JTextField();
        jTvalorCompra = new JtextFieldSomenteNumeros(20);
        jTquantidade = new JtextFieldSomenteNumeros(20);
        jBsalvar = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCBgrandeza = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCBfabricantes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setMaximumSize(new java.awt.Dimension(900, 495));
        setMinimumSize(new java.awt.Dimension(900, 495));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NovoProduto.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 270, 495));

        jLabel3.setText("Modelo* :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel4.setText("Valor de compra* :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLabel5.setText("Fabricante*:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jTmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTmodeloActionPerformed(evt);
            }
        });
        getContentPane().add(jTmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 190, -1));

        jTvalorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTvalorCompraActionPerformed(evt);
            }
        });
        getContentPane().add(jTvalorCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 190, -1));

        jTquantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTquantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 190, -1));

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 434, 70, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 434, 70, -1));

        jLabel6.setText("Grandeza* :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        jCBgrandeza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CM", "M", "KM", "G", "KG", "UN" }));
        jCBgrandeza.setToolTipText("");
        jCBgrandeza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBgrandezaActionPerformed(evt);
            }
        });
        getContentPane().add(jCBgrandeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 190, -1));

        jLabel7.setText("Tela de Cadastro de Produtos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 33, -1, -1));

        jLabel8.setText("ID :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jTid.setEditable(false);
        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 190, -1));

        jLabel12.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 477, -1, -1));

        jCBfabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBfabricantesActionPerformed(evt);
            }
        });
        getContentPane().add(jCBfabricantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 190, -1));

        jLabel9.setText("Quantidade* :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTmodeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTmodeloActionPerformed

    private void jTvalorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTvalorCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTvalorCompraActionPerformed

    private void jTquantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTquantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTquantidadeActionPerformed

    private void jCBgrandezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBgrandezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBgrandezaActionPerformed

    private void jTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        //busca informações dos campos na tela
        String nome = jTmodelo.getText();
        String valorcompra = jTvalorCompra.getText();
        String quantidade = jTquantidade.getText();
        int tipoproduto = jCBgrandeza.getItemCount();
        int fabricante = jCBfabricantes.getItemCount();
        String tipoproduto_idtipoproduto = produtoDAO.selectGrandezaId((String) jCBgrandeza.getSelectedItem());
        System.out.println(tipoproduto_idtipoproduto);
        String fabricante_idfabricante = fabricantesDAO.selectFabricantesId((String) jCBfabricantes.getSelectedItem());
        int contFabricante = jCBfabricantes.getItemCount();
        String obrigatorio = "";
        boolean controle = false;
        //validação
        if (contFabricante < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre ao menos um Fabricante!";
            controle = true;
        }
        if (nome.equals("")) {
            obrigatorio = obrigatorio + "\n - Modelo";
            controle = true;
        }
        if (valorcompra.equals("")) {
            obrigatorio = obrigatorio + "\n - Valor de Compra";
            controle = true;
        }
        if (quantidade.equals("")) {
            obrigatorio = obrigatorio + "\n - Quantidade";
            controle = true;
        }
        if (tipoproduto < 0) {
            obrigatorio = obrigatorio + "\n - Cadastre antes uma Grandeza";
            controle = true;
        }
        if (fabricante < 0) {
            obrigatorio = obrigatorio + "\n - Cadastre antes um Fabricante!";
            controle = true;
        }
        if (controle == false) {
            //insere informaçoes dos campos no banco de dados
            produtoDAO.insertCadastroProduto(nome, valorcompra, quantidade, tipoproduto_idtipoproduto, fabricante_idfabricante);
            dispose();
        } else {
            //Mostra mensagem dos campos da tela sem valores
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }

    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jCBfabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBfabricantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBfabricantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsair;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jCBfabricantes;
    private javax.swing.JComboBox<String> jCBgrandeza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTmodelo;
    private javax.swing.JTextField jTquantidade;
    private javax.swing.JTextField jTvalorCompra;
    // End of variables declaration//GEN-END:variables
}