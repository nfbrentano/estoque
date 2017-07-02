/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.cidadeDAO;
import DAO.estadoDAO;
import DAO.paisDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class AlterarEstado extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarPais
     */
    public AlterarEstado() {
        initComponents();
        this.preencheJComboBoxEstado();
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
 * preenche o combobox com dados dos paises cadastrados
 */
    public void preencheJComboBoxPais() {
        ResultSet result;
        String sql = "SELECT * FROM pais ORDER BY nome";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBpais.addItem(result.getString("nome"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Insere dados na tela referentes ao ID digitado na busca
     *
     * @param id do bairro cadastrado
     */
    public void preencheCadastro(String sigla) {
        ResultSet result;
        String sql = "SELECT e.idestado, e.sigla AS estado, e.nome AS nome, p.nome AS pais FROM estado e INNER JOIN pais p ON (p.idpais = e.pais_idpais) WHERE e.sigla ='" + sigla + "';";

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
                jTidEstado.setText(result.getString("idestado"));
                jTnomeEstado.setText(result.getString("nome"));
                jTsiglaEstado.setText(result.getString("estado"));
                jCBpais.setSelectedItem(result.getString("pais"));
                this.preencheJComboBoxPais();
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
        jTsiglaEstado = new javax.swing.JTextField();
        jBalterarEstado = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCBpais = new javax.swing.JComboBox<>();
        jTidEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTnomeEstado = new javax.swing.JTextField();
        jCBestado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Estado");
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar Estado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 145, -1));

        jLabel2.setText("ID* :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setText("Sigla* :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jTsiglaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTsiglaEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jTsiglaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 140, -1));

        jBalterarEstado.setText("Alterar");
        jBalterarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(jBalterarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel4.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        getContentPane().add(jCBpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, -1));

        jTidEstado.setEditable(false);
        getContentPane().add(jTidEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, -1));

        jLabel5.setText("Pais* :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel6.setText("Nome Estado* :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        getContentPane().add(jTnomeEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));

        jCBestado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBestadoItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 140, -1));

        jLabel7.setText("Estado* :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTsiglaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTsiglaEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTsiglaEstadoActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBalterarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarEstadoActionPerformed
        //recebe os dados da tela
        System.out.println("iniciando botao");
        String id = jTidEstado.getText();
        String nome = jTnomeEstado.getText();
        String estado = jTsiglaEstado.getText();
        String pais = (String) jCBpais.getSelectedItem();

        //paisDAO.selectPaisId(pais);
        //System.out.println(paisDAO.selectPaisId(pais));
        String obrigatorio = "";
        boolean controle = false;
        //validação
        if (id.equals("")) {
            obrigatorio = obrigatorio + "\n - ID";
            controle = true;
            System.out.println("ID");
        }
        if (nome.equals(" ")) {
            obrigatorio = obrigatorio + "\n - Nome do Estado";
            controle = true;
            System.out.println("NOME ");
            System.out.println(nome);
        }
        if (estado.equals("")) {
            obrigatorio = obrigatorio + "\n - Sigla do Estado";
            controle = true;
            System.out.println("ESTADO");
            System.out.println(estado);
        }
        if (pais.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome do Pais";
            controle = true;
            System.out.println("PAIS");
            System.out.println(pais);
        }
        if (controle == false) {
            //inserção dos dados da tela no banco
            System.out.println("envia...");
            estadoDAO.updateCadastroEstado(estado, nome, paisDAO.selectPaisId(pais), id);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }
    }//GEN-LAST:event_jBalterarEstadoActionPerformed

    private void jCBestadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBestadoItemStateChanged
        //recebe informaçoes da tela
        String sigla = (String) jCBestado.getSelectedItem();
        System.out.println(sigla);
        String obrigatorio = "";
        System.out.println(obrigatorio);
        boolean controle = false;
        //validação

        if (sigla.equals("")) {
            obrigatorio = obrigatorio + "\n - UF";
            controle = true;
            System.out.println("sigla true");
        }
        if (controle == false) {
            System.out.println("opssss");
            preencheCadastro((String) jCBestado.getSelectedItem());

        } else {
            System.out.println("mensagem");
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }    }//GEN-LAST:event_jCBestadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalterarEstado;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JComboBox<String> jCBestado;
    private javax.swing.JComboBox<String> jCBpais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTidEstado;
    private javax.swing.JTextField jTnomeEstado;
    private javax.swing.JTextField jTsiglaEstado;
    // End of variables declaration//GEN-END:variables
}
