/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import HibernateDAO.HDAOfabricantes;
import HibernateDAO.HDAOfuncionarios;
import HibernateDAO.HDAOmodelo;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import tabelas.Modelo;
import tabelas.Reparo;
import tabelas.Vendas;

/**
 *
 * @author nfbrentano
 */
public final class CancelarReparo extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CancelarReparo() {
        initComponents();
        this.preencheJComboBoxID();

    }

    public void preencheDados(String id) {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Reparo WHERE idreparos = '" + id + "'  ");
            resultado = q.list();

            for (Object o : resultado) {
                Reparo r = (Reparo) o;
                jTdataReparo.setText(r.getDatareparo());
                jTfabricante.setText(HDAOfabricantes.selectNomeFabricante(Integer.toString(r.getFabricantes_idfabricantes())));
                jTfuncionario.setText(HDAOfuncionarios.selectNomeFuncionario(Integer.toString(r.getFuncionarios_idfuncionarios())));
                jTmodelo.setText(HibernateDAO.HDAOmodelo.selectNomeModelo(Integer.toString(r.getModelo_idmodelo())));
                jTquantidade.setText(Integer.toString(r.getQuantidade()));
                jTvalorReparo.setText(Double.toString(r.getValorreparo()));
                jTid.setText(Integer.toString(r.getIdreparos()));

            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    /**
     * Update da quantidade de produtos no cadastro de modelo
     *
     * @param id
     */
    private void updateQuantidadeModelo(int id) {

        List resultado = null;
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int disponivel = HDAOmodelo.selectQuantidadeModelo(jTmodelo.getText());

            String quantidade = jTquantidade.getText();
            System.out.println("TESTE" + HDAOmodelo.selectQuantidadeModelo(jTmodelo.getText()));
            System.out.println(quantidade);
            int d = disponivel;
            System.out.println("quantidade disponivel!!!!" + d);
            int q = Integer.parseInt(quantidade);
            int quantidadeFinal = d + q;
            System.out.println("finallll" + quantidadeFinal);

            org.hibernate.Query query = sessao.createQuery("FROM Modelo WHERE idmodelo = " + id );
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
     * preenche o combobox de id de reparo
     */
    public void preencheJComboBoxReparo() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Reparo ORDER BY idreparos");
            resultado = q.list();

            for (Object o : resultado) {
                Reparo r = (Reparo) o;
                jCBcodReparo.addItem(Integer.toString(r.getIdreparos()));
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
        //jTdataReparo.setText(dataFormat.format(new Date()));

    }

    public void cancelaReparo(int id) {
        List resultado = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();

            org.hibernate.Query query = sessao.createQuery("FROM Reparo WHERE idreparos = '" + id + "'");
            resultado = query.list();
            for (Object obj : resultado) {
                Reparo r = (Reparo) obj;
                r.setDatareparo(jTdataReparo.getText());
                r.setFabricantes_idfabricantes(HDAOfabricantes.selectIdFabricante(jTfabricante.getText()));
                r.setFuncionarios_idfuncionarios(HDAOfuncionarios.selectIdFuncionario(jTfuncionario.getText()));
                r.setIdreparos(Integer.parseInt(jTid.getText()));
                r.setModelo_idmodelo(HDAOmodelo.selectIdModelo(jTmodelo.getText()));
                r.setQuantidade(Integer.parseInt(jTquantidade.getText()));
                r.setValorreparo(Double.parseDouble(jTvalorReparo.getText()));
                r.setDisponibilidade(false);

                sessao.update(r);
                updateQuantidadeModelo(HDAOmodelo.selectIdModelo(jTmodelo.getText()));

                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }
    }

    /**
     * preenche o combobox de produtos com o nome do produto
     */
    public void preencheJComboBoxID() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Reparo WHERE disponibilidade = true");
            resultado = q.list();

            for (Object o : resultado) {
                Reparo r = (Reparo) o;
                jCBcodReparo.addItem(Integer.toString(r.getIdreparos()));

            }

        } catch (HibernateException he) {
            he.printStackTrace();
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

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jTdataReparo = new javax.swing.JTextField();
        jBcancelarReparo = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTvalorReparo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTquantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTmodelo = new javax.swing.JTextField();
        jTfuncionario = new javax.swing.JTextField();
        jTfabricante = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jCBcodReparo = new javax.swing.JComboBox<>();

        jLabel12.setText("* Campos Obrigatórios.");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Reparos");
        setMinimumSize(new java.awt.Dimension(740, 385));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ReparoProduto.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -70, 280, 495));

        jLabel4.setText("Data Reparo :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        jTid.setEditable(false);
        jTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidActionPerformed(evt);
            }
        });
        getContentPane().add(jTid, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 200, -1));

        jTdataReparo.setEditable(false);
        jTdataReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTdataReparoActionPerformed(evt);
            }
        });
        getContentPane().add(jTdataReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 200, -1));

        jBcancelarReparo.setText("Cancelar");
        jBcancelarReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarReparoActionPerformed(evt);
            }
        });
        getContentPane().add(jBcancelarReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 80, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 80, -1));

        jLabel7.setText("Tela de Cadastro de Reparos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel8.setText("Modelo :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        jLabel9.setText("Fabricante :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel10.setText("Valor Reparo :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jTvalorReparo.setEditable(false);
        jTvalorReparo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTvalorReparoActionPerformed(evt);
            }
        });
        getContentPane().add(jTvalorReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 200, -1));

        jLabel13.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 477, -1, -1));

        jLabel5.setText("Funcionario :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel2.setText("* Campos Obrigatorios .");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));

        jTquantidade.setEditable(false);
        getContentPane().add(jTquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 200, -1));

        jLabel6.setText("ID :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel11.setText("Quantidade :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, 20));

        jTmodelo.setEditable(false);
        jTmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTmodeloActionPerformed(evt);
            }
        });
        getContentPane().add(jTmodelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 200, -1));

        jTfuncionario.setEditable(false);
        getContentPane().add(jTfuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 200, -1));

        jTfabricante.setEditable(false);
        getContentPane().add(jTfabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 200, -1));

        jLabel14.setText("Cód. Reparo:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jCBcodReparo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBcodReparoItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBcodReparo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 200, -1));

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

    private void jTvalorReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTvalorReparoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTvalorReparoActionPerformed

    private void jBcancelarReparoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarReparoActionPerformed
        System.out.println("Apertei botao CANCELA");
        cancelaReparo(Integer.parseInt((String) jCBcodReparo.getSelectedItem()));

        dispose();
    }//GEN-LAST:event_jBcancelarReparoActionPerformed

    private void jTmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTmodeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTmodeloActionPerformed

    private void jCBcodReparoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBcodReparoItemStateChanged
        preencheDados((String) jCBcodReparo.getSelectedItem());
    }//GEN-LAST:event_jCBcodReparoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancelarReparo;
    private javax.swing.JButton jBsair;
    private javax.swing.JComboBox<String> jCBcodReparo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTdataReparo;
    private javax.swing.JTextField jTfabricante;
    private javax.swing.JTextField jTfuncionario;
    private javax.swing.JTextField jTid;
    private javax.swing.JTextField jTmodelo;
    private javax.swing.JTextField jTquantidade;
    private javax.swing.JTextField jTvalorReparo;
    // End of variables declaration//GEN-END:variables
}
