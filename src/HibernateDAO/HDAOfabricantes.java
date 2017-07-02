/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDAO;

import estoque.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import tabelas.Fabricantes;
import tabelas.Funcionarios;
import tabelas.Modelo;

/**
 *
 * @author Natanael
 */
public class HDAOfabricantes {
      /**
     * Seleciona o nome com base no id do fabricante
     *
     * @param modelo modelo do produto
     */
    public static String selectNomeFabricante(String id) {
        List resultado = null;
        String resposta = null ;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Fabricantes WHERE idfabricantes = '" + id + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Fabricantes f = (Fabricantes) o;
                resposta = f.getRazaosocial();
            }
            System.out.println("modelo select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;
    }
    
    /**
     * seleciona o id do fabricante com base no nome
     * @param nome variavel do nome do fabricante
     * @return 
     */
     public static int selectIdFabricante(String id) {
        List resultado = null;
        int resposta = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Fabricantes WHERE razaosocial = '" + id + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Fabricantes f = (Fabricantes) o;
                resposta = f.getIdfabricantes();
            }
            System.out.println("modelo select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;
    }
}
