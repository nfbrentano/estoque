/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDAO;

import estoque.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import tabelas.Modelo;

/**
 *
 * @author Natanael
 */
public class HDAOmodelo {
    
    
     
     /**
     * Seleciona o preço com base no nome do produto
     *
     * @param modelo modelo do produto
     */
    public static Double selectPrecoModelo(String modelo) {
        List resultado = null;
        Double vlr = 0.00;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo WHERE nome = '" + modelo + "'");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                vlr = p.getValorcompra();

                System.out.println(vlr);
            }
            System.out.println(vlr);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return vlr;

    }
     /**
     * Seleciona o nome com base no id do produto
     *
     * @param modelo modelo do produto
     */
    public static String selectNomeModelo(String id) {
        List resultado = null;
        String resposta = null ;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo WHERE idmodelo = '" + id + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                resposta = p.getNome();
            }
            System.out.println("modelo select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;

    }
    /**
     * Selecina o ID do modelo buscando pelo nome
     * @param nome variavel utilizada para nome do modelo
     * @return 
     */
    
    public static int selectIdModelo(String nome) {

        List resultado = null;
       int id = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo WHERE nome = '" + nome + "'");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                id = p.getIdmodelo();

                System.out.println(id);
            }
            System.out.println(id);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return id;

    }
      /**
     * Seleciona a quantidade com base no nome do produto
     *
     * @param modelo modelo do produto
     */
    public static int selectQuantidadeModelo(String modelo) {
        List resultado = null;
        int resposta = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo WHERE nome = '" + modelo + "'");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                resposta = p.getQuantidade();
            }
            System.out.println("Quantidade select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;

    }
    
     /**
     * Seleciona a quantidade com base no nome do produto
     *
     * @param modelo modelo do produto
     */
    public static int selectQuantidadeModeloPorId(int id) {
        List resultado = null;
        int resposta = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Modelo WHERE idmodelo = '" + id + "'");
            resultado = q.list();

            for (Object o : resultado) {
                Modelo p = (Modelo) o;
                resposta = p.getQuantidade();
            }
            System.out.println("Quantidade select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;

    }
}
