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
import tabelas.Funcionarios;

/**
 *
 * @author Natanael
 */
public class HDAOfuncionarios {
      /**
     * Seleciona o nome com base no id do funcionario
     *
     * @param modelo modelo do produto
     */
    public static String selectNomeFuncionario(String id) {
        List resultado = null;
        String resposta = null ;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Funcionarios WHERE idfuncionarios = '" + id + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Funcionarios f = (Funcionarios) o;
                resposta = f.getNome();
            }
            System.out.println("modelo select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;
    }
    /**
     * seleciona o id do funcionario com base no nome
     * @param nome variavel do nome do funcionario
     * @return 
     */
     public static int selectIdFuncionario(String nome) {
        List resultado = null;
        int resposta = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            org.hibernate.Query q = sessao.createQuery("FROM Funcionarios WHERE nome = '" + nome + "' ");
            resultado = q.list();

            for (Object o : resultado) {
                Funcionarios f = (Funcionarios) o;
                resposta = f.getIdfuncionarios();
            }
            System.out.println("modelo select " + resposta);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resposta;
    }
}

