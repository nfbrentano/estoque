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
/**
 * Insere no cadastro de bairro do banco de dados
 * @author Natanael BrasRede
 */
public class bairroDAO {
     public static void insertCadastroBairro(String idbairro, String nome, String cidade_idcidade) {

        String sql = "INSERT INTO bairro (idbairro, nome, cidade_idcidade)"
                + "VALUES ('" + idbairro + "', '" + nome + "', '" + cidade_idcidade + "');";
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println(sql);
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     /**
      * atualiza o cadastro de bairro no banco de dados
      * @param nome campo no banco do nome do bairro
      * @param cidade_idcidade campo no banco do codigo da cidade que o bairro pertence
      * @param id id do bairro no banco de dados
      */
      public static void updateCadastroBairro(String nome, String cidade_idcidade, String id) {
        String sql = "UPDATE bairro"
                + " SET nome = '" + nome + "', cidade_idcidade = '" + cidade_idcidade + "' WHERE idbairro = '" + id + "';";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste conecta");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      /**
       * seleciona informações do bairro filtrando por nome
       * @param nome variavel do nome do bairro para realizar a busca
       * @return 
       */
      public static String selectBairroId(String nome) {
        ResultSet result;
        String sql = "SELECT idbairro FROM bairro WHERE nome = '" + nome + "';";
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
                id = result.getString("idbairro");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
      }
}