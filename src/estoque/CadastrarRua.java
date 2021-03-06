/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.bairroDAO;
import DAO.cidadeDAO;
import DAO.enderecoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class CadastrarRua extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarPais
     */
    public CadastrarRua() {
        initComponents();
        this.preencheID();
        this.preencheJComboBoxBairro();
    }

    /**
     * Preenche o campo de bairros na tela com as informações cadastradas no
     * banco de dados
     */
    public void preencheJComboBoxBairro() {
        ResultSet result;
        String sql = "SELECT * FROM bairro ORDER BY nome";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBbairro.addItem(result.getString("nome"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * preenche o campo de id na tela adicionando 1 para ser o proximo id
     * disponivel de cadastro
     */
    public void preencheID() {
        ResultSet result;
        String sql = "select max(idendereco+1) from endereco";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jTidRua.setText((result.getString("max")));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTidRua = new javax.swing.JTextField();
        jTnomeRua = new javax.swing.JTextField();
        jBsalvarBairro = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBbairro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Bairro");
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Rua");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 135, -1));

        jLabel2.setText("ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 85, -1, -1));

        jLabel3.setText("Nome do Rua* :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTidRua.setEditable(false);
        jTidRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidRuaActionPerformed(evt);
            }
        });
        getContentPane().add(jTidRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 85, 140, -1));

        jTnomeRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnomeRuaActionPerformed(evt);
            }
        });
        getContentPane().add(jTnomeRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, -1));

        jBsalvarBairro.setText("Salvar");
        jBsalvarBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarBairroActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvarBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabel9.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        jLabel4.setText("Bairro* :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jCBbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBbairroActionPerformed(evt);
            }
        });
        getContentPane().add(jCBbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 140, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTidRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidRuaActionPerformed

    private void jTnomeRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnomeRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnomeRuaActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBsalvarBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarBairroActionPerformed
        //variaveis para armazenar informações dos campos da tela
        String id = jTidRua.getText();
        String rua = jTnomeRua.getText();
        String bairro = (String) jCBbairro.getSelectedItem();
        bairroDAO.selectBairroId(bairro);
        String obrigatorio = "";
        boolean controle = false;
        //validação
        if (bairro.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome do Bairro";
            controle = true;
        }
        if (rua.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome da Rua";
            controle = true;
        }
        if (controle == false) {
            //insere informaçoes de cadastro de rua no banco de dados
            enderecoDAO.insertCadastroEndereco(id, rua, bairroDAO.selectBairroId(bairro));
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }

    }//GEN-LAST:event_jBsalvarBairroActionPerformed

    private void jCBbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBbairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBbairroActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBsalvarBairro;
    private javax.swing.JComboBox<String> jCBbairro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTidRua;
    private javax.swing.JTextField jTnomeRua;
    // End of variables declaration//GEN-END:variables
}
