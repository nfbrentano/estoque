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
public class funcionariosDAO {
    /**
     * Insere no cadastro de funcionários
     * @param nome Nome do funcionario
     * @param cpf Cadastro do CPF
     * @param sobrenome Cadastro do sobrenome
     * @param pais Cadastro do Pais
     * @param estado Cadastro do Estado
     * @param cidade Cadastro da Cidade
     * @param bairro Cadastro do Bairro
     * @param endereco Cadastro da rua
     * @param numeroendereco  Cadastro do numero da residencia
     */

    public static void insertCadastroFuncionarios(String nome, String cpf, String sobrenome, String pais,
            String estado, String cidade, String bairro, String endereco, String numeroendereco) {

        String sql = "INSERT INTO funcionarios (nome, sobrenome, cpf, pais, estado, cidade, bairro, endereco, numeroendereco, disponibilidade)"
                + "VALUES ('" + nome + "', '" + sobrenome + "', '" + cpf + "' ,'" + pais + "','" + estado + "','" + cidade + "', '" + bairro + "', '" + endereco + "', '" + numeroendereco + "','true' );";
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
     *   Atualização do cadastro de funcionario
     * @param nome Nome do funcionario
     * @param cpf Cadastro do CPF
     * @param sobrenome Cadastro do sobrenome
     * @param pais Cadastro do Pais
     * @param estado Cadastro do Estado
     * @param cidade Cadastro da Cidade
     * @param bairro Cadastro do Bairro
     * @param endereco Cadastro da rua
     * @param numeroendereco  Cadastro do numero da residencia
     * @param id Cadastro do ID do funcionario
 */
    public static void updateCadastroFuncionarios(String nome, String sobrenome, String cpf, String pais,
            String estado, String cidade, String bairro, String endereco, String numeroendereco, String id) {
        String sql = "UPDATE funcionarios"
                + " SET nome = '" + nome + "', sobrenome ='" + sobrenome + "', cpf = '" + cpf + "' , pais ='" + pais + "', estado = '" + estado + "', cidade= '" + cidade + "', bairro = '" + bairro + "', endereco = '" + endereco + "', numeroendereco = '" + numeroendereco + "' WHERE idfuncionarios = '" + id + "';";
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
     * Busca informação do id e muda o campo disponibilidade
     * dentro do cadastro de funcinario para FALSE desabilitando o seu cadastro
     * @param id ID do funcionario
     */
    
    public static void deleteCadastroFuncionarios(String id) {
        String sql = "UPDATE funcionarios"
                + " SET disponibilidade = false WHERE idfuncionarios = '" + id + "';";
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
         * Busca informação do ID do funcionario por seu nome
         */
 public static String selectIdfuncionarios(String nome) {
        
        ResultSet result;
        String sql = "SELECT idfuncionarios FROM funcionarios WHERE nome = '" + nome + "';";
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
                id = result.getString("idfuncionarios");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
