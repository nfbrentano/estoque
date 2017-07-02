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
 * insere informações no cadastro de bairro
 * @author Natanael BrasRede
 */
public class enderecoDAO {
     public static void insertCadastroEndereco(String idendereco, String rua, String bairro_idbairro) {

        String sql = "INSERT INTO endereco (idendereco, rua, bairro_idbairro)"
                + "VALUES ('" + idendereco + "', '" + rua + "', '" + bairro_idbairro + "');";
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
 * atualiza do endereço
 * @param rua nome da rua
 * @param bairro_idbairro id do bairro que pertence
 * @param id id da rua
 */     
      public static void updateCadastroEndereco(String rua, String bairro_idbairro, String id) {
        String sql = "UPDATE endereco"
                + " SET rua = '" + rua + "', bairro_idbairro = '" + bairro_idbairro + "' WHERE idendereco = '" + id + "';";
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
       * seleciona informações da rua filtrando pelo nome
       * @param rua variavel utilizada para filtrar o nome da rua
       * @return 
       */
      public static String selectEndereco(String rua) {
        ResultSet result;
        String sql = "SELECT idendereco FROM endereco WHERE rua = '" + rua + "';";
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
                id = result.getString("idendereco");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
      }
}