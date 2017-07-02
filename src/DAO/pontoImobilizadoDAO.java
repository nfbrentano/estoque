/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Natanael BrasRede
 */
public class pontoImobilizadoDAO {
    /**
     * Insere informação do nome do ponto imobilizado no banco de dados
     * @param nome nome do ponto imobilizado
     */
        public static void insertpontoImobilizado(String nome) {
            
        String sql = "INSERT INTO pontoImobilizado (nome)"
                + "VALUES ('" + nome + "');";
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste2");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
         /**
     * Busca informação do ID do ponto por seu nome
     */
 public static String selectIdPontoImobilizado(String nome) {
        
        ResultSet result;
        String sql = "SELECT idpontoimobilizado FROM pontoimobilizado WHERE nome = '" + nome + "';";
        String id = " ";
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                id = result.getString("idpontoimobilizado");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
