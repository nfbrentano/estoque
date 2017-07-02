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
public class estadoDAO {
/**
 * insere no banco de dados no cadastro de estado
 * @param idestado id do estado
 * @param sigla sigla do estado a ser cadastrado
 * @param nome nome do estado a ser cadastrado
 * @param pais_idpais  id do pais a que pertence o estado
 */
    public static void insertCadastroEstado(String idestado, String sigla, String nome, String pais_idpais) {

        String sql = "INSERT INTO estado (idestado, sigla, nome, pais_idpais)"
                + "VALUES ('" + idestado + "', '" + sigla + "', '" + nome + "', '" + pais_idpais + "');";
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
 * atualiza um cadastro de estado no banco filtrando pelo id do estado
 * @param sigla sigla do estado cadastrado
 * @param nome nome do estado cadastrado
 * @param pais_idpais id do pais a qual o estado pertence
 * @param id  id do estado
 */
    public static void updateCadastroEstado(String sigla, String nome, String pais_idpais, String id) {
        String sql = "UPDATE estado"
                + " SET sigla = '" + sigla + "', nome = '" + nome + "', pais_idpais = '" + pais_idpais + "' WHERE idestado = '" + id + "';";
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
     * seleciona o estado filtrando pelo sigla
     * @param sigla variavel utilizada para o filtro pela sigla
     * @return retorna os valores encontrados
     */
    public static String selectEstadoId(String sigla) {
        ResultSet result;
        String sql = "SELECT idestado FROM estado WHERE sigla = '" + sigla + "';";
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
                id = result.getString("idestado");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
