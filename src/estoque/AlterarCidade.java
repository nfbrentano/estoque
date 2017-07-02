/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.bairroDAO;
import DAO.cidadeDAO;
import DAO.estadoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class AlterarCidade extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarPais
     */
    public AlterarCidade() {
        initComponents();
        this.preencheJComboBoxCidade();
    }

    /**
     * Preenche o campo de cidades na tela com as informações cadastradas no
     * banco de dados
     */
    public void preencheJComboBoxCidade() {
        ResultSet result;
        String sql = "SELECT * FROM cidade ORDER BY nome";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBcidade.addItem(result.getString("nome"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Preenche as informações de Estado na tela com as informações cadastradas
     * no banco de dados
     */
    public void preencheJComboBoxEstado() {
        ResultSet result;
        String sql = "SELECT * FROM estado ORDER BY sigla";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBestado.addItem(result.getString("sigla"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Insere dados na tela referentes ao nome selecionado na busca
     *
     *
     */
    public void preencheCadastro(String nome) {
        ResultSet result;
        String sql = "SELECT c.idcidade, c.nome AS cidade, e.nome AS estado FROM cidade c INNER JOIN estado e ON (e.idestado = c.estado_idestado) WHERE c.nome ='" + nome + "';";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            System.out.println(sql);
            System.out.println("oi oi");
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jTidCidade.setText(result.getString("idcidade"));
                jTnomeCidade.setText(result.getString("cidade"));
                jCBestado.addItem(result.getString("estado"));
                this.preencheJComboBoxEstado();
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
        jTnomeCidade = new javax.swing.JTextField();
        jBsalvarCidade = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTidCidade = new javax.swing.JTextField();
        jCBestado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCBcidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Cidade");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar Cidade");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 24, 134, -1));

        jLabel2.setText("ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 109, -1, -1));

        jLabel3.setText("Nome do Cidade* :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 147, -1, -1));

        jTnomeCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnomeCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTnomeCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 144, 135, -1));

        jBsalvarCidade.setText("Alterar");
        jBsalvarCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvarCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel4.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jTidCidade.setEditable(false);
        jTidCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTidCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 106, 135, -1));

        getContentPane().add(jCBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 182, 135, -1));

        jLabel5.setText("Estado* :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 185, -1, -1));

        jLabel6.setText("Cidade* :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 71, -1, -1));

        jCBcidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBcidadeItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 68, 135, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTnomeCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnomeCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnomeCidadeActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jTidCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidCidadeActionPerformed

    private void jBsalvarCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarCidadeActionPerformed
       // recebe os dados da tela
        String id = jTidCidade.getText();
        String cidade = jTnomeCidade.getText();
        String estado = (String) jCBestado.getSelectedItem();
        estadoDAO.selectEstadoId(estado);
        System.out.println(estadoDAO.selectEstadoId(estado));
        String obrigatorio = "";
        boolean controle = false;
        //validação
        if (id.equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
            controle = true;
            System.out.println(id);
        }
        if (cidade.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome do Bairro";
            controle = true;
        }
        if (estado.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome da Cidade";
            controle = true;
        }
        if (controle == false) {
            //inserção dos dados da tela no banco
            cidadeDAO.updateCadastroCidade(cidade, estadoDAO.selectEstadoId(estado), id);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }
    }//GEN-LAST:event_jBsalvarCidadeActionPerformed

    private void jCBcidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBcidadeItemStateChanged
        //recebe informações da tela
        String cidade = (String) jCBcidade.getSelectedItem();
        String obrigatorio = "";
        boolean controle = false;
        //validação

        if (cidade.equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
            controle = true;

        }
        if (controle == false) {
            //preenche o cadastro na tela
            preencheCadastro((String) jCBcidade.getSelectedItem());

        } else {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }
    }//GEN-LAST:event_jCBcidadeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBsalvarCidade;
    private javax.swing.JComboBox<String> jCBcidade;
    private javax.swing.JComboBox<String> jCBestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTidCidade;
    private javax.swing.JTextField jTnomeCidade;
    // End of variables declaration//GEN-END:variables
}
