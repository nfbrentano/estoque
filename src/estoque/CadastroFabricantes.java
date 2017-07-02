/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.bairroDAO;
import DAO.cidadeDAO;
import DAO.estadoDAO;
import DAO.fabricantesDAO;
import DAO.funcionariosDAO;
import DAO.paisDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class CadastroFabricantes extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CadastroFabricantes() {
        initComponents();

        this.preencheID();
    }

    /**
     * Preenche campo de ID na tela do sistema
     */
    public void preencheID() {
        ResultSet result;
        String sql = "select max(idfabricantes+1) from fabricantes";

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
     * Preenche campo de endereço de rua no sistema
     */
    public void preencheJComboBoxEndereco(String bairro) {
        ResultSet result;
        String sql = "SELECT * FROM endereco WHERE bairro_idbairro = '" + bairroDAO.selectBairroId(bairro) + "';";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                jCBrua.addItem(result.getString("rua"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Preenche campo de Bairro no sistema
     */
    public void preencheJComboBoxBairro(String cidade) {
        ResultSet result;
        String sql = "SELECT * FROM bairro WHERE cidade_idcidade = '" + cidadeDAO.selectCidadeId(cidade) + "'; ";

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
     * Preenche campo de cidade na tela do sistema
     */
    public void preencheJComboBoxCidade(String estado) {
        ResultSet result;
        String sql = "SELECT * FROM cidade where estado_idestado = '" + estadoDAO.selectEstadoId(estado) + "';";

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
     * Preenche o campo de estado na tela do sistema
     */
    public void preencheJComboBoxEstado(String pais) {
        ResultSet result;
        String sql = "SELECT * FROM estado WHERE pais_idpais = '" + paisDAO.selectPaisId(pais) + "';";
        System.out.println(sql);
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
     * Preenche o campo de Pais na tela do sistema
     */
    public void preencheJComboBoxPais() {
        ResultSet result;
        String sql = "SELECT * FROM pais";

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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTrazaoSocial = new javax.swing.JTextField();
        jTcnpj = new JtextFieldSomenteNumeros(11);
        jBsalvar = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTnumero = new JtextFieldSomenteNumeros(10);
        jLabel12 = new javax.swing.JLabel();
        jCBrua = new javax.swing.JComboBox<>();
        jCBpais = new javax.swing.JComboBox<>();
        jCBestado = new javax.swing.JComboBox<>();
        jCBcidade = new javax.swing.JComboBox<>();
        jCBbairro = new javax.swing.JComboBox<>();
        jBpais = new javax.swing.JButton();
        jBestado = new javax.swing.JButton();
        jBcidade = new javax.swing.JButton();
        jBbairro = new javax.swing.JButton();
        jBrua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fabricantes");
        setMinimumSize(new java.awt.Dimension(900, 495));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemFabrica.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 325, 501));

        jLabel2.setText("Razão Social* :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 133, -1, -1));

        jLabel3.setText("CNPJ *:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 179, -1, -1));

        jLabel4.setText("Rua *:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        jLabel5.setText("Cidade *:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        jTrazaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTrazaoSocialActionPerformed(evt);
            }
        });
        getContentPane().add(jTrazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 128, 200, -1));

        jTcnpj.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTcnpjInputMethodTextChanged(evt);
            }
        });
        jTcnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcnpjActionPerformed(evt);
            }
        });
        getContentPane().add(jTcnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 174, 200, -1));

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 70, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 70, -1));

        jLabel6.setText("Bairro *:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel7.setText("Tela de Cadastro de Fabricantes");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 240, -1));

        jLabel8.setText("ID :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 87, -1, -1));

        jTid.setEditable(false);
        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 82, 200, -1));

        jLabel9.setText("Pais* :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 225, -1, -1));

        jLabel10.setText("Estado *:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 259, -1, -1));

        jLabel11.setText("Número* :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));
        getContentPane().add(jTnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 200, -1));

        jLabel12.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 470, -1, -1));

        jCBrua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBruaMousePressed(evt);
            }
        });
        getContentPane().add(jCBrua, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 200, -1));

        jCBpais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBpaisMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBpaisMousePressed(evt);
            }
        });
        jCBpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBpaisActionPerformed(evt);
            }
        });
        getContentPane().add(jCBpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 200, -1));

        jCBestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBestadoMousePressed(evt);
            }
        });
        getContentPane().add(jCBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 200, -1));

        jCBcidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBcidadeMousePressed(evt);
            }
        });
        getContentPane().add(jCBcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 200, -1));

        jCBbairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBbairroMousePressed(evt);
            }
        });
        getContentPane().add(jCBbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 200, -1));

        jBpais.setText("Cadas. Pais");
        jBpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpaisActionPerformed(evt);
            }
        });
        getContentPane().add(jBpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 100, -1));

        jBestado.setText("Cadas. Estado");
        jBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBestadoActionPerformed(evt);
            }
        });
        getContentPane().add(jBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 100, -1));

        jBcidade.setText("Cadas. Cidade");
        jBcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jBcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 100, -1));

        jBbairro.setText("Cadas. Bairro");
        jBbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbairroActionPerformed(evt);
            }
        });
        getContentPane().add(jBbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 100, -1));

        jBrua.setText("Cadas. Rua");
        jBrua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBruaActionPerformed(evt);
            }
        });
        getContentPane().add(jBrua, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 380, 100, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTrazaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTrazaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTrazaoSocialActionPerformed

    private void jTcnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcnpjActionPerformed
           }//GEN-LAST:event_jTcnpjActionPerformed

    private void jTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        //Busca informações dos campos preenchidos na tela
        String razaoSocial = jTrazaoSocial.getText();
        String cnpj = jTcnpj.getText();
        String numeroendereco = jTnumero.getText();
        String pais = (String) jCBpais.getSelectedItem();
        String estado = (String) jCBestado.getSelectedItem();
        String cidade = (String) jCBcidade.getSelectedItem();
        String bairro = (String) jCBbairro.getSelectedItem();
        String rua = (String) jCBrua.getSelectedItem();
        int contPais = jCBpais.getItemCount();
        int contEstado = jCBestado.getItemCount();
        int contCidade = jCBcidade.getItemCount();
        int contBairro = jCBbairro.getItemCount();
        int contRua = jCBrua.getItemCount();
        String obrigatorio = "";
        boolean controle = false;
        //validação
        if (contPais < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre o Pais!";
            controle = true;
        }
        if (contEstado < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre o Estado!";
            controle = true;
        }
        if (contCidade < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre a Cidade!";
            controle = true;
        }
        if (contBairro < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre o Bairro!";
            controle = true;
        }
        if (contRua < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre a Rua!";
            controle = true;
        }
        if (razaoSocial.equals("")) {
            obrigatorio = obrigatorio + "\n - Razão Social";
            controle = true;
        }
        if (cnpj.equals("")) {
            obrigatorio = obrigatorio + "\n - CNPJ";
            controle = true;
        }
        if (numeroendereco.equals("")) {
            obrigatorio = obrigatorio + "\n - Numero do Endereço";
            controle = true;
        }
        if (controle == false) {
            //Insere os dados da tela no banco
            fabricantesDAO.insertCadastroFabricante(razaoSocial, cnpj, pais, estado, cidade, bairro, bairro, numeroendereco);
            dispose();
        } else {
            //Mostra quais campos não tem valores
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }

        System.out.println("teste1");    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jTcnpjInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTcnpjInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTcnpjInputMethodTextChanged

    private void jBpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpaisActionPerformed
        new CadastrarPais().setVisible(true);
    }//GEN-LAST:event_jBpaisActionPerformed

    private void jBestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBestadoActionPerformed
        new CadastrarEstado().setVisible(true);
    }//GEN-LAST:event_jBestadoActionPerformed

    private void jBcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcidadeActionPerformed
        new CadastrarCidade().setVisible(true);

    }//GEN-LAST:event_jBcidadeActionPerformed

    private void jBbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbairroActionPerformed
        new CadastrarBairro().setVisible(true);
    }//GEN-LAST:event_jBbairroActionPerformed

    private void jBruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBruaActionPerformed
        new CadastrarRua().setVisible(true);
    }//GEN-LAST:event_jBruaActionPerformed

    private void jCBpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBpaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBpaisActionPerformed

    private void jCBpaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBpaisMouseClicked

    }//GEN-LAST:event_jCBpaisMouseClicked

    private void jCBpaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBpaisMousePressed
         //preenche dados na tela referrente ao pais
        this.jCBpais.removeAllItems();
        this.preencheJComboBoxPais();

    }//GEN-LAST:event_jCBpaisMousePressed

    private void jCBestadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBestadoMousePressed
         //preenche dados na tela referrente ao estado
        this.jCBestado.removeAllItems();
        this.preencheJComboBoxEstado((String) jCBpais.getSelectedItem());

    }//GEN-LAST:event_jCBestadoMousePressed

    private void jCBcidadeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBcidadeMousePressed
         //preenche dados na tela referrente a cidade
        this.jCBcidade.removeAllItems();
        this.preencheJComboBoxCidade((String) jCBestado.getSelectedItem());
    }//GEN-LAST:event_jCBcidadeMousePressed

    private void jCBbairroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBbairroMousePressed
         //preenche dados na tela referrente ao bairro
        this.jCBbairro.removeAllItems();
        this.preencheJComboBoxBairro((String) jCBcidade.getSelectedItem());

    }//GEN-LAST:event_jCBbairroMousePressed

    private void jCBruaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBruaMousePressed
 //preenche dados na tela referrente a rua
 this.jCBrua.removeAllItems();
        this.preencheJComboBoxEndereco((String) jCBbairro.getSelectedItem());
    }//GEN-LAST:event_jCBruaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbairro;
    private javax.swing.JButton jBcidade;
    private javax.swing.JButton jBestado;
    private javax.swing.JButton jBpais;
    private javax.swing.JButton jBrua;
    private javax.swing.JButton jBsair;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jCBbairro;
    private javax.swing.JComboBox<String> jCBcidade;
    private javax.swing.JComboBox<String> jCBestado;
    private javax.swing.JComboBox<String> jCBpais;
    private javax.swing.JComboBox<String> jCBrua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTcnpj;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTnumero;
    private javax.swing.JTextField jTrazaoSocial;
    // End of variables declaration//GEN-END:variables
}
