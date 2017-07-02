/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.fabricantesDAO;
import DAO.funcionariosDAO;
import DAO.grandezaDAO;
import DAO.produtoDAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class AlterarProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public AlterarProduto() {
        initComponents();
        this.preencheJComboBoxProduto();

    }

    /**
     * preenche o combobox de produtos com o nome do produto
     */
    public void preencheJComboBoxProduto() {
        ResultSet result;
        String sql = "SELECT * FROM modelo WHERE disponibilidade = true ORDER BY nome";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBprodutos.addItem(result.getString("nome"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Preenche o campo de ID na tela do sistema
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
     * Preenche o campo de fabricantes na tela do sistema com as informações
     * cadastradas no banco de dados
     */
    public void preencheJComboBoxFabricantes() {
        ResultSet result;
        String sql = "SELECT * FROM fabricantes WHERE disponibilidade = true ORDER BY razaosocial";

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
     * Busca informações dos funcionarios filtrando pela ID
     *
     * @param id ID do cadastro de cada funcionario
     */
    public void idFabricante(String id) {
        ResultSet result;
        String sql = "SELECT * FROM fabricantes WHERE idfabricantes =" + id + ";";

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
     * Preenche as informações na tela filtrando pelo ID de cadastro
     *
     * @param id ID de cadastro do produto
     */
    public void preencheCadastro(String produto) {
        ResultSet result;
        String sql = "SELECT * FROM modelo WHERE nome ='" + produto + "' AND disponibilidade = true ORDER BY nome ";
        this.jCBfabricantes.removeAllItems();
        this.preencheJComboBoxFabricantes();
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            System.out.println("oi oi");
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);

            while (result.next()) {
                jTid.setText(result.getString("idmodelo"));
                jTmodelo.setText(result.getString("nome"));
                jTvalorCompra.setText(result.getString("valorcompra"));
                jTquantidade.setText(result.getString("quantidade"));
                String fabricante = result.getString("fabricantes_idfabricantes");
                jCBfabricantes.setSelectedItem(fabricantesDAO.selectFabricanteNome(fabricante));
                String grandeza = result.getString("tipoproduto_idtipoproduto");
                jCBgrandeza.setSelectedItem(grandezaDAO.selectGrandeza(grandeza));
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
        jBsair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCBgrandeza = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCBfabricantes = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jBalterar = new javax.swing.JButton();
        jBdeletar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCBprodutos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setMinimumSize(new java.awt.Dimension(900, 495));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AlterarProduto.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 270, 420));

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

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 70, -1));

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

        jLabel7.setText("Tela de Alteração de Cadastro de Produtos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 33, -1, -1));

        jLabel8.setText("ID* :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 190, -1));

        jLabel12.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 477, -1, -1));

        getContentPane().add(jCBfabricantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 190, -1));

        jLabel9.setText("Quantidade* :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jBalterar.setText("Alterar");
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));

        jBdeletar.setText("Deletar");
        jBdeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBdeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        jLabel2.setText("Produtos* :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jCBprodutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBprodutosItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBprodutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 190, -1));

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

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        // busca informações dos itens que estão na tela
        String id = jTid.getText();
        String nome = jTmodelo.getText();
        String valorcompra = jTvalorCompra.getText();
        String quantidade = jTquantidade.getText();
        String tipoproduto_idtipoproduto = produtoDAO.selectGrandezaId((String) jCBgrandeza.getSelectedItem());
        System.out.println(tipoproduto_idtipoproduto);
        String fabricante_idfabricante = fabricantesDAO.selectFabricantesId((String) jCBfabricantes.getSelectedItem());
        int contFabricante = jCBfabricantes.getItemCount();
        String obrigatorio = "";
        boolean controle = false;
        //validação

        if (id.equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
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
        if (contFabricante < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre ao menos um Fabricante!";
            controle = true;
        }

        if (controle == false) {
            //atualiza cadastro do produto no banco de dados
            produtoDAO.updateCadastroProduto(nome, valorcompra, quantidade, tipoproduto_idtipoproduto, fabricante_idfabricante, id);
            dispose();
        } else {
            //mostra campos que não foram preenchidos
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }

    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBdeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdeletarActionPerformed
        String obrigatorio = "";
        boolean controle = false;
        //validação

        if (jTid.getText().equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
            controle = true;

        }
        if (controle == false) {
            // desabilita no banco de dados produto selecionado
            produtoDAO.deleteCadastroProdutos(jTid.getText());
            dispose();;
        } else {
            //mostra mensagem de campo que não foi preenchido
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);

        }


    }//GEN-LAST:event_jBdeletarActionPerformed

    private void jCBprodutosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBprodutosItemStateChanged
        //recebe dados da tela
        String produto = (String) jCBprodutos.getSelectedItem();
        String obrigatorio = "";
        boolean controle = false;
        //validação

        if (produto.equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
            controle = true;

        }
        if (controle == false) {
            // preenche as informações da tela com dados do banco
            preencheCadastro(produto);

        } else {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }    }//GEN-LAST:event_jCBprodutosItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBdeletar;
    private javax.swing.JButton jBsair;
    private javax.swing.JComboBox<String> jCBfabricantes;
    private javax.swing.JComboBox<String> jCBgrandeza;
    private javax.swing.JComboBox<String> jCBprodutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
