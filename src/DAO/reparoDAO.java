/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Natanael BrasRede
 */
public class reparoDAO {
    /**
     * Insere no banco de dados informaçoes pertinentes aos envios à reparos
     * @param datareparo data do reparo cadastrado
     * @param modelo_idmodelo modelo de produto enviado para reparo
     * @param valorreparo valor do reparo
     * @param funcionarios_idfuncionarios funcionario responsavel pela solicitação do reparo
     * @param fabricantes_idfabricantes  fabricante do produto 
     */
    public static void insertReparo( String datareparo,  String modelo_idmodelo, String valorreparo, String funcionarios_idfuncionarios, String fabricantes_idfabricantes) {

        String sql = "INSERT INTO reparo (datareparo, modelo_idmodelo, valorreparo, funcionarios_idfuncionarios, fabricantes_idfabricantes)" +
"VALUES ('"+ datareparo+"','"+ modelo_idmodelo+"','"+valorreparo+"','" +funcionarios_idfuncionarios+"','"+ fabricantes_idfabricantes+"');";
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
}
