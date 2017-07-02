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
public class paisDAO {
    /**
     * insere informações no cadastro de pais no banco de dados
     * @param idpais id do pais a ser cadastrado
     * @param nome  nome do pais a ser cadastrado
     */
        public static void insertCadastroPais(String idpais, String nome) {

        String sql = "INSERT INTO pais (idpais, nome)"
                + "VALUES ('" + idpais + "', '" + nome + "');";
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
      * atualiza informações de um cadastro de pais filtrando pelo id
      * @param nome nome do pais 
      * @param id  id do pais
      */
      public static void updateCadastroPais(String nome, String id) {
        String sql = "UPDATE pais"
                + " SET nome = '" + nome + "' WHERE idpais = '" + id + "';";
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
       * seleciona informações de um pais filtrando pelo nome
       * @param nome variavel utilizada na busca
       * @return retorno dos dados da busca
       */
      public static String selectPaisId(String nome) {
        ResultSet result;
        String sql = "SELECT idpais FROM pais WHERE nome = '" + nome + "';";
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
                id = result.getString("idpais");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
      }
}
