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
public class cidadeDAO {
    /**
     * insere no banco de dados cadastro de cidade
     * @param idcidade id da nova cidade
     * @param nome nome da cidade
     * @param estado_idestado  id do estado a qual pertence
     */
   public static void insertCadastroCidade(String idcidade, String nome, String estado_idestado) {

        String sql = "INSERT INTO cidade (idcidade, nome, estado_idestado)"
                + "VALUES ('" + idcidade + "', '" + nome + "', '" + estado_idestado + "');";
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
    * atualiza o cadastro da cidade buscando por id a cidade
    * @param nome nome da cidade
    * @param estado_idestado id do estado a qual ela pertence
    * @param id  id da cidade
    */  
   
      public static void updateCadastroCidade(String nome, String estado_idestado, String id) {
        String sql = "UPDATE cidade"
                + " SET nome = '" + nome + "', estado_idestado = '" + estado_idestado + "' WHERE idcidade = '" + id + "';";
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
     * busca informações de uma cidade filtrando por nome 
     * @param nome variavel utilizada na busca
     * @return 
     */
     public static String selectCidadeId(String nome) {
        ResultSet result;
        String sql = "SELECT idcidade FROM cidade WHERE nome = '" + nome + "';";
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
                id = result.getString("idcidade");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
      }
}

