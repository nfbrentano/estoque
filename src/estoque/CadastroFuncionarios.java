/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.bairroDAO;
import DAO.cidadeDAO;
import DAO.estadoDAO;
import DAO.funcionariosDAO;
import DAO.paisDAO;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nfbrentano
 */
public class CadastroFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CadastroFuncionarios() {
        initComponents();
        this.preencheID();

    }

    /**
     * Preenche campo de ID na tela do sistema
     */
    public void preencheID() {
        ResultSet result;
        String sql = "select max(idfuncionarios+1) from funcionarios";

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
     * Preenche campo de Endereço na tela do sistema
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
     * Preenche campo de bairro na tela do sistema
     */
    public void preencheJComboBoxBairro(String cidade) {
        ResultSet result;
        String sql = "SELECT * FROM bairro WHERE cidade_idcidade = '" + cidadeDAO.selectCidadeId(cidade) + "';";

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
     * Preenche campo de estado na tela do sistema
     */
    public void preencheJComboBoxEstado(String pais) {
        ResultSet result;
        String sql = "SELECT * FROM estado WHERE pais_idpais = '" + paisDAO.selectPaisId(pais) + "';";

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
     * Preenche campo de pais na tela do sistema
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
        jTnome = new JtextFieldSomenteLetras(50);
        jTcpf = new JtextFieldSomenteNumeros(11);
        jBsalvar = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCBrua = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jCBbairro = new javax.swing.JComboBox<>();
        jCBpais = new javax.swing.JComboBox<>();
        jCBcidade = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCBestado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTnumero = new JtextFieldSomenteNumeros(10);
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTsobrenome1 = new JtextFieldSomenteLetras(50);
        jBpais = new javax.swing.JButton();
        jBestado = new javax.swing.JButton();
        jBcidade = new javax.swing.JButton();
        jBbairro = new javax.swing.JButton();
        jBrua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setMaximumSize(new java.awt.Dimension(900, 520));
        setMinimumSize(new java.awt.Dimension(900, 520));
        setPreferredSize(new java.awt.Dimension(900, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 520));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ImagemOperario.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 0, 236, 495));

        jLabel2.setText("Nome* :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        jLabel3.setText("CPF*:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel4.setText("Rua* :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, 15));

        jLabel5.setText("Cidade* :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        jTnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 190, -1));

        jTcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcpfActionPerformed(evt);
            }
        });
        getContentPane().add(jTcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 190, -1));

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 70, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 70, -1));

        jLabel6.setText("Bairro* :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        jCBrua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBruaMousePressed(evt);
            }
        });
        jCBrua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBruaActionPerformed(evt);
            }
        });
        getContentPane().add(jCBrua, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 190, -1));

        jLabel7.setText("Tela de Cadastro de Funcionários");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 33, -1, -1));

        jLabel8.setText("ID :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jTid.setEditable(false);
        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 190, -1));

        jCBbairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBbairroMousePressed(evt);
            }
        });
        jCBbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBbairroActionPerformed(evt);
            }
        });
        getContentPane().add(jCBbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 190, -1));

        jCBpais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBpaisMousePressed(evt);
            }
        });
        jCBpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBpaisActionPerformed(evt);
            }
        });
        getContentPane().add(jCBpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 190, -1));

        jCBcidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBcidadeMousePressed(evt);
            }
        });
        jCBcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBcidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jCBcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 190, -1));

        jLabel9.setText("Pais* :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        jLabel10.setText("Estado* :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        jCBestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCBestadoMousePressed(evt);
            }
        });
        jCBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBestadoActionPerformed(evt);
            }
        });
        getContentPane().add(jCBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 190, -1));

        jLabel11.setText("Número* :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, -1, -1));
        getContentPane().add(jTnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 190, -1));

        jLabel12.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 477, -1, -1));

        jLabel13.setText("Sobrenome* :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jTsobrenome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTsobrenome1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTsobrenome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 190, -1));

        jBpais.setText("Cadas. Pais");
        jBpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpaisActionPerformed(evt);
            }
        });
        getContentPane().add(jBpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 100, -1));

        jBestado.setText("Cadas. Estado");
        jBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBestadoActionPerformed(evt);
            }
        });
        getContentPane().add(jBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 100, -1));

        jBcidade.setText("Cadas. Cidade");
        jBcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jBcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 100, -1));

        jBbairro.setText("Cadas. Bairro");
        jBbairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbairroActionPerformed(evt);
            }
        });
        getContentPane().add(jBbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 100, -1));

        jBrua.setText("Cadas. Rua");
        jBrua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBruaActionPerformed(evt);
            }
        });
        getContentPane().add(jBrua, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 100, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTnomeActionPerformed

    private void jTcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTcpfActionPerformed

    private void jTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jCBruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBruaActionPerformed

    private void jCBbairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBbairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBbairroActionPerformed

    private void jCBpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBpaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBpaisActionPerformed

    private void jCBcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBcidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBcidadeActionPerformed

    private void jCBestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBestadoActionPerformed


    }//GEN-LAST:event_jCBestadoActionPerformed

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        //busca informações nos campos da tela
        String nome = jTnome.getText();
        String sobrenome = jTcpf.getText();
        String numero = jTnumero.getText();
        String cpf = jTcpf.getText();
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
        if (nome.equals("")) {
            obrigatorio = obrigatorio + "\n - Nome";
            controle = true;
        }
        if (sobrenome.equals("")) {
            obrigatorio = obrigatorio + "\n - Sobrenome";
            controle = true;
        }
        if (numero.equals("")) {
            obrigatorio = obrigatorio + "\n - Numero do Endereço";
            controle = true;
        }
        if (cpf.equals("")) {
            obrigatorio = obrigatorio + "\n - CPF";
            controle = true;
        }

        if (controle == false) {
            //insere informações da tela no banco de dados
            funcionariosDAO.insertCadastroFuncionarios(nome, sobrenome, cpf, pais, estado, cidade, bairro, rua, numero);
            dispose();
        } else {
            //mostra mensagem com nome dos campos sem valores
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }

    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jTsobrenome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTsobrenome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTsobrenome1ActionPerformed

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

    private void jCBpaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBpaisMousePressed
        //preenche dados na tela referrente ao pais
        this.jCBpais.removeAllItems();
        this.preencheJComboBoxPais();    }//GEN-LAST:event_jCBpaisMousePressed

    private void jCBestadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBestadoMousePressed
        //preenche dados na tela referrente ao estado
        this.jCBestado.removeAllItems();
        this.preencheJComboBoxEstado((String) jCBpais.getSelectedItem());    }//GEN-LAST:event_jCBestadoMousePressed

    private void jCBcidadeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBcidadeMousePressed
        //preenche dados na tela referrente a cidade
        this.jCBcidade.removeAllItems();
        this.preencheJComboBoxCidade((String) jCBestado.getSelectedItem());    }//GEN-LAST:event_jCBcidadeMousePressed

    private void jCBbairroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBbairroMousePressed
        //preenche dados na tela referrente ao bairro
        this.jCBbairro.removeAllItems();
        this.preencheJComboBoxBairro((String) jCBcidade.getSelectedItem());    }//GEN-LAST:event_jCBbairroMousePressed

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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTcpf;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTnumero;
    private javax.swing.JTextField jTsobrenome1;
    // End of variables declaration//GEN-END:variables
}
