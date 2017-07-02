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
 * Seleciona o nome da grandeza baseada no seu ID de cadastro no banco de dados
 * @author Natanael BrasRede
 */
public class grandezaDAO {
     public static String selectGrandeza(String idgrandeza) {
        ResultSet result;
        String sql = "SELECT grandeza FROM tipoproduto WHERE idtipoprodutos = '" + idgrandeza + "';";
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
                id = result.getString("grandeza");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
}
