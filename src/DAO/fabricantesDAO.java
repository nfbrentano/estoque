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
public class fabricantesDAO {

    /**
     * Insere no cadastro de fabricantes
     *
     * @param razaosocial Cadastro do Nome do fabricante
     * @param cnpj Cadastro do CNPJ
     * @param pais Cadastro do Pais
     * @param estado Cadstro do Estado
     * @param cidade Cadastro da Cidade
     * @param bairro Cadastro do Bairro
     * @param endereco Cadastro do nome de rua
     * @param numeroendereco Cadastro do numero do endereço do estabelecimento
     */
    public static void insertCadastroFabricante(String razaosocial, String cnpj, String pais, String estado, String cidade, String bairro, String endereco, String numeroendereco) {

        String sql = "INSERT INTO fabricantes (razaosocial, cnpj, pais, estado, cidade, bairro, endereco, numeroendereco, disponibilidade)"
                + "VALUES ('" + razaosocial + "', '" + cnpj + "', '" + pais + "','" + estado + "','" + cidade + "', '" + bairro + "', '" + endereco + "', '" + numeroendereco + "', 'true');";
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("testeFabricante");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 * atualiza o cadastro de um fabricante no banco de dados
 * @param razaoSocial razao social da fabricante
 * @param cnpj cnpj da fabricante
 * @param pais pais de cadastro da fabricante
 * @param estado estado de cadastro da fabricante
 * @param cidade cidade de cadastro da fabricante
 * @param bairro bairro de cadastro da fabricante
 * @param endereco rua de cadastro da fabricante
 * @param numeroendereco numero do endereço de cadastro da fabricante
 * @param id id da empresa
 */
    public static void updateCadastroFabricantes(String razaoSocial, String cnpj, String pais,
            String estado, String cidade, String bairro, String endereco, String numeroendereco, String id) {
        String sql = "UPDATE fabricantes"
                + " SET razaosocial = '" + razaoSocial + "', cnpj = '" + cnpj + "' , pais ='" + pais + "', estado = '" + estado + "', cidade= '" + cidade + "', bairro = '" + bairro + "', endereco = '" + endereco + "', numeroendereco = '" + numeroendereco + "' WHERE idfabricantes = '" + id + "';";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste conecta fabricantes");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 * desabilita o cadastro do fabricante filtrando pela id
 * @param id variavel utilizada para  o filtro
 */
    public static void deleteCadastroFabricantes(String id) {
        String sql = "UPDATE fabricantes"
                + " SET disponibilidade = false WHERE idfabricantes = '" + id + "';";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste deleta fabricantes");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 * seleciona o nome do fabricante filtrando pela id
 * @param idfabricantes variavel utilizada no filtro
 * @return 
 */
    public static String selectFabricanteNome(String idfabricantes) {
        ResultSet result;
        String sql = "SELECT razaosocial FROM fabricantes WHERE idfabricantes = '" + idfabricantes + "';";
        String id = " ";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            while (result.next()) {
                id = result.getString("razaosocial");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
    
     /**
     * Busca informação do id de fabricante a partir do seu nome
     *
     * @param razaosocial Nome do fabricante
     * @return
     */
    public static String selectFabricantesId(String razaosocial) {
        ResultSet result;
        String sql = "SELECT idfabricantes FROM fabricantes WHERE razaosocial = '" + razaosocial + "';";
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
                id = result.getString("idfabricantes");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
