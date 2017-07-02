/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import HibernateDAO.HDAOmodelo;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import tabelas.Modelo;
import tabelas.Vendas;

/**
 *
 * @author nfbrentano
 */
public class CancelarVendas extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CancelarVendas() {
        initComponents();
        this.preencheJComboBoxID();
    }

    /**
     * preenche o combobox de id de vendas
     */
    public void preencheJComboBoxID() {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Vendas WHERE disponibilidade = true");
            resultado = q.list();

            for (Object o : resultado) {
                Vendas v = (Vendas) o;
                jCBid.addItem( Integer.toString(v.getIdvendas()));
                
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

     public void preencheDados(String id) {
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Vendas WHERE idvendas = '" + id + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Vendas v = (Vendas) o;
                jTproduto.setText(HibernateDAO.HDAOmodelo.selectNomeModelo(Integer.toString(v.getModelo_idmodelo())));
                jTquantidade.setText(Integer.toString(v.getQuantidade_quantidademodelo()));
                jTvalor.setText(Double.toString(v.getValorvenda()));
                jTcliente.setText(v.getNomerazaosocial());
                jTdocumento.setText(v.getDocumento());
                
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
            int disponivel = HDAOmodelo.selectQuantidadeModelo(jTproduto.getText());

            String quantidade = jTquantidade.getText();
            System.out.println("TESTE" + HDAOmodelo.selectQuantidadeModelo(jTproduto.getText()));
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
    
    
     public void cancelaVenda (int id) {
    List resultado = null;
    Session sessao = null;
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        
        
        org.hibernate.Query query = sessao.createQuery("FROM Vendas WHERE idvendas = '" + id + "'");
        resultado = query.list();
        for (Object obj : resultado) {
            Vendas v = (Vendas) obj;
            v.setIdvendas(id);
            v.setDocumento(jTdocumento.getText());
            v.setModelo_idmodelo(HibernateDAO.HDAOmodelo.selectIdModelo(jTproduto.getText()));
            v.setNomerazaosocial(jTcliente.getText());
            v.setQuantidade_quantidademodelo(Integer.parseInt(jTquantidade.getText()));
            v.setValorvenda(Double.parseDouble(jTvalor.getText()));
            v.setDisponibilidade(false);
            updateQuantidadeModelo(HDAOmodelo.selectIdModelo(jTproduto.getText()));
            sessao.update(v);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
        }
    } catch (HibernateException hibEx) {
        hibEx.printStackTrace();
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
        jBcancelar = new javax.swing.JButton();
        jBsair = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTvalor = new javax.swing.JTextField();
        jTcliente = new javax.swing.JTextField();
        jTdocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTquantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTproduto = new javax.swing.JTextField();
        jCBid = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Setores");
        setMinimumSize(new java.awt.Dimension(740, 380));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 495));
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venda.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 325, 240));

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jBcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 90, -1));

        jBsair.setText("Sair");
        jBsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsairActionPerformed(evt);
            }
        });
        getContentPane().add(jBsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 70, -1));

        jLabel7.setText("Cancelamento de Vendas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 24, -1, -1));

        jLabel12.setText("* Campos Obrigatórios.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        jTvalor.setEditable(false);
        getContentPane().add(jTvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 100, -1));

        jTcliente.setEditable(false);
        getContentPane().add(jTcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 100, -1));

        jTdocumento.setEditable(false);
        getContentPane().add(jTdocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 100, -1));

        jLabel3.setText("Documento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, 20));

        jLabel4.setText("Produto :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel6.setText("Valor:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, 20));

        jLabel9.setText("Cliente :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 20));

        jTquantidade.setEditable(false);
        jTquantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTquantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(jTquantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 100, -1));

        jLabel8.setText("Quantidade :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 20));

        jTproduto.setEditable(false);
        getContentPane().add(jTproduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 100, -1));

        jCBid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBidItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBid, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 100, -1));

        jLabel2.setText("Cód. Venda* :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsairActionPerformed
        dispose();
    }//GEN-LAST:event_jBsairActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        System.out.println("Apertei botao CANCELA");
        cancelaVenda(Integer.parseInt((String) jCBid.getSelectedItem()));
        dispose();



    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jTquantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTquantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTquantidadeActionPerformed

    private void jCBidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBidItemStateChanged
        
        System.out.println((String) jCBid.getSelectedItem());
        preencheDados((String) jCBid.getSelectedItem());
    }//GEN-LAST:event_jCBidItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBsair;
    private javax.swing.JComboBox<String> jCBid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTcliente;
    private javax.swing.JTextField jTdocumento;
    private javax.swing.JTextField jTproduto;
    private javax.swing.JTextField jTquantidade;
    private javax.swing.JTextField jTvalor;
    // End of variables declaration//GEN-END:variables
}
