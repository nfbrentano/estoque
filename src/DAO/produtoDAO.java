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
public class produtoDAO {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     * Insere informações do produto dentro do banco de dados do sistema
     *
     * @param nome Cadastro do nome do produto
     * @param valorcompra Cadastro do valor de compra do produto
     * @param quantidade Cadastro da quantidade de produtos adquiridos
     * @param tipoproduto_idtipoproduto Cadastro do tipo de produto pela
     * informação da ID
     * @param fabricantes_idfabricantes Cadastro do fabricante pela informação
     * da ID
     */
    public static void insertCadastroProduto(String nome, String valorcompra, String quantidade, String tipoproduto_idtipoproduto, String fabricantes_idfabricantes) {

        String sql = "INSERT INTO modelo (nome, valorcompra, quantidade, tipoproduto_idtipoproduto, fabricantes_idfabricantes, disponibilidade )"
                + "VALUES ('" + nome + "', '" + valorcompra + "', '" + quantidade + "' ,'" + tipoproduto_idtipoproduto + "', '" + fabricantes_idfabricantes + "','true');";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste produto");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    /**
     * Busca informações do ID de grandeza pelo seu nome
     *
     * @param grandeza Nome da grandeza a ser cadastrada o produto EX.: KG, CM
     * @return
     */
    public static String selectGrandezaId(String grandeza) {
        ResultSet result;
        String sql = "SELECT idtipoprodutos FROM tipoproduto WHERE grandeza = '" + grandeza + "';";
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
                id = result.getString("idtipoprodutos");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }

    /**
     * Atualiza informação do produto
     *
     * @param nome Cadastro do nome do produto
     * @param valorcompra Cadastro do valor de compra do produto
     * @param quantidade Cadastro da quantidade de produtos adquiridos
     * @param tipoproduto_idtipoproduto Cadastro do tipo de produto pela
     * informação da ID
     * @param fabricantes_idfabricantes Cadastro do fabricante pela informação
     * da ID
     * @param idmodelo Cadastro do ID do modelo do produto
     */
    public static void updateCadastroProduto(String nome, String valorcompra, String quantidade, String tipoproduto_idtipoproduto, String fabricantes_idfabricantes, String idmodelo) {

        String sql = "UPDATE modelo"
                + " SET nome = '" + nome + "',valorcompra = '" + valorcompra + "',quantidade = '" + quantidade + "' , tipoproduto_idtipoproduto ='" + tipoproduto_idtipoproduto + "', fabricantes_idfabricantes = '" + fabricantes_idfabricantes + "'WHERE idmodelo = '" + idmodelo + "';";
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
     * Desabilita o produto do sistema, filtrando pela ID de cadastro
     *
     * @param id ID do cadastro do produto
     */
    public static void deleteCadastroProdutos(String id) {
        String sql = "UPDATE modelo"
                + " SET disponibilidade = false WHERE idmodelo = '" + id + "';";
        System.out.println(sql);
        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("teste deleta");
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca informação do ID do modelo por seu nome
     */
    public static String selectIdModelo(String nome) {

        ResultSet result;
        String sql = "SELECT idmodelo FROM modelo WHERE nome = '" + nome + "';";
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
                id = result.getString("idmodelo");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
