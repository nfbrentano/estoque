/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import DAO.fabricantesDAO;
import DAO.funcionariosDAO;
import HibernateDAO.HDAOmodelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import tabelas.Fabricantes;
import tabelas.Modelo;
import tabelas.Funcionarios;
import tabelas.Reparo;

/**
 *
 * @author nfbrentano
 */
public final class TelaReparo extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public TelaReparo() {
        initComponents();
        this.preencheID();
        this.data();
        this.preencheJComboBoxFabricantes();
        this.preencheJComboBoxFuncionarios();
        this.preencheJComboBoxProduto();
    }

    /**
     * Preenche campo de ID na tela do sistema
     */
    public void preencheID() {
        ResultSet result;
        String sql = "select max(idreparos+1) from reparo";

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

    /*
  Update da quantidade de produtos no cadastro de modelo  
     */
    private void updateQuantidadeModelo(int id) {

        List resultado = null;
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            String disponivel = jTdisponivel.getText();
            String quantidade = jTquantidade.getText();
            System.out.println(disponivel);
            System.out.println(quantidade);
            int d = Integer.parseInt(disponivel);
            int q = Integer.parseInt(quantidade);
            int quantidadeFinal = d - q;

            org.hibernate.Query query = sessao.createQuery("FROM Modelo WHERE idmodelo = " + id);
            resultado = query.list();
            for (Object obj : resultado) {
                Modelo mod = (Modelo) obj;
                mod.setQuantidade(quantidadeFinal);
                sessao.update(mod);
                transacao.commit();
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }

    }


    /**
     * preenche o combobox dos funcionarios
     */
    public void preencheJComboBoxFuncionarios() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Funcionarios ORDER BY nome");
            resultado = q.list();

            for (Object o : resultado) {
                Funcionarios f = (Funcionarios) o;
                jCBfuncionarios.addItem(f.getNome());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * preenche o combobox de produtos com o nome do produto
     */
    public void preencheJComboBoxProduto() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo ORDER BY nome");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                jCBidModelo.addItem(p.getNome());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    /**
     * preenche combobox dos fabricantes
     */
    public final void preencheJComboBoxFabricantes() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Fabricantes ORDER BY razaosocial");
            resultado = q.list();

            for (Object o : resultado) {
                Fabricantes f = (Fabricantes) o;
                jCBidFabricante.addItem(f.getRazaosocial());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    /**
     * preenche a data no campo de data da tela
     */
    public void data() {

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        jTdataReparo.setText(dataFormat.format(new Date()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jTdataReparo = new javax.swing.JTextField();
        jBsalvar = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCBidModelo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCBidFabricante = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTvalorReparo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jCBfuncionarios = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTquantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTdisponivel = new javax.swing.JTextField();

        jLabel12.setText("* Campos Obrigatórios.");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Reparos");
        setMinimumSize(new java.awt.Dimension(740, 385));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ReparoProduto.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -70, 280, 495));

        jLabel3.setText("Disponível:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, 20));

        jLabel4.setText("Data Reparo* :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jTid.setEditable(false);
        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 200, -1));

        jTdataReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTdataReparoActionPerformed(evt);
            }
        });
        getContentPane().add(jTdataReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 200, -1));

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 70, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 70, -1));

        jLabel7.setText("Tela de Cadastro de Reparos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel8.setText("Modelo* :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jCBidModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBidModeloItemStateChanged(evt);
            }
        });
        jCBidModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBidModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jCBidModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 200, -1));

        jLabel9.setText("Fabricante* :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jCBidFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBidFabricanteActionPerformed(evt);
            }
        });
        getContentPane().add(jCBidFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 200, -1));

        jLabel10.setText("Valor Reparo* :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jTvalorReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTvalorReparoActionPerformed(evt);
            }
        });
        getContentPane().add(jTvalorReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 200, -1));

        jLabel13.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 477, -1, -1));

        getContentPane().add(jCBfuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 200, -1));

        jLabel5.setText("Funcionario* :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jLabel2.setText("* Campos Obrigatorios .");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));
        getContentPane().add(jTquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 200, -1));

        jLabel6.setText("ID :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        jLabel11.setText("Quantidade* :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, 20));
        getContentPane().add(jTdisponivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 40, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidActionPerformed

    private void jTdataReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTdataReparoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTdataReparoActionPerformed

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jCBidModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBidModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBidModeloActionPerformed

    private void jCBidFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBidFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBidFabricanteActionPerformed

    private void jTvalorReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTvalorReparoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTvalorReparoActionPerformed

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed

        //recebe os dados da tela 
        String id = jTid.getText();
        int modelo = HibernateDAO.HDAOmodelo.selectIdModelo((String) jCBidModelo.getSelectedItem());
        String dataReparo = jTdataReparo.getText();
        String quantidade = jTquantidade.getText();
        String disponivel = jTdisponivel.getText();
        String fabricante = fabricantesDAO.selectFabricantesId((String) jCBidFabricante.getSelectedItem());
        String funcionario = funcionariosDAO.selectIdfuncionarios((String) jCBfuncionarios.getSelectedItem());
        String valorReparo = jTvalorReparo.getText();
        int contFabricante = jCBidFabricante.getItemCount();
        int contFuncionario = jCBfuncionarios.getItemCount();
        String obrigatorio = "";
        boolean controle = false;
        //validação
        //validação
        int d = 0;
        if (disponivel.equals("0")) {
            obrigatorio = obrigatorio + "\n - Precisa ter produtos disponíveis.";
            controle = true;
        } else {
            d = Integer.parseInt(disponivel);
        }

        int q = 0;
        if (quantidade.equals("")) {
            obrigatorio = obrigatorio + "\n - Quantidade.";
            controle = true;
        } else {
            q = Integer.parseInt(quantidade);
        }
        int quantidadeFinal = d - q;
        if (quantidadeFinal < 0) {
            obrigatorio = obrigatorio + "\n - Quantidade maior que o estoque disponível!";
            controle = true;
        }

        if (modelo < 0) {
            obrigatorio = obrigatorio + "\n - Modelo";
            controle = true;
        }
        if (dataReparo.equals("")) {
            obrigatorio = obrigatorio + "\n - Data Reparo";
            controle = true;
        }

        if (valorReparo.equals("")) {
            obrigatorio = obrigatorio + "\n - Valor do reparo";
            controle = true;
        }
        if (contFabricante < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre ao menos um Fabricante!";
            controle = true;
        }
        if (contFuncionario < 1) {
            obrigatorio = obrigatorio + "\n - Cadastre ao menos um Funcionario!";
            controle = true;
        }
        if (controle == false) {
            //Insere os dados da tela no banco
            Session sessao = null;
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();
                Reparo r = new Reparo();
                r.setDatareparo(dataReparo);
                r.setFabricantes_idfabricantes(Integer.parseInt(fabricante));
                r.setFuncionarios_idfuncionarios(Integer.parseInt(funcionario));
                r.setModelo_idmodelo(modelo);
                r.setQuantidade(Integer.parseInt(quantidade));
                r.setValorreparo(Double.parseDouble(valorReparo));
                r.setDisponibilidade(true);
                sessao.save(r);
                t.commit();
                updateQuantidadeModelo(modelo);
                JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
                dispose();
            } catch (HibernateException he) {
                he.printStackTrace();
            } finally {
                sessao.close();
            }
        } else {
            //Mostra quais campos não tem valores
            JOptionPane.showMessageDialog(this, "Campos obrigatorios:" + obrigatorio);
        }
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jCBidModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBidModeloItemStateChanged
        int quantidade = HDAOmodelo.selectQuantidadeModelo((String) jCBidModelo.getSelectedItem());
        jTdisponivel.setText(Integer.toString(quantidade));

    }//GEN-LAST:event_jCBidModeloItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsair;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jCBfuncionarios;
    private javax.swing.JComboBox<String> jCBidFabricante;
    private javax.swing.JComboBox<String> jCBidModelo;
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
    private javax.swing.JTextField jTdataReparo;
    private javax.swing.JTextField jTdisponivel;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTquantidade;
    private javax.swing.JTextField jTvalorReparo;
    // End of variables declaration//GEN-END:variables
}
