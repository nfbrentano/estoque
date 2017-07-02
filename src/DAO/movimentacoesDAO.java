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
public class movimentacoesDAO {
    /**
     * Insere informações de movimentações de produtos no banco de dados
     * @param tipo Cadastro do tipo de movimentação ( saida S, ou entrada E)
     * @param datamovimentacao Cadastro da data de movimentação
     * @param horamovimentacao Cadastro da hora da movimentação
     * @param modelo_idmodelo Cadastro do modelo a ser movimentado
     * @param funcionarios_idfuncionarios Cadastro do ID do funcionario responsavel
     * pela retirada do ou entrada do protudo
     * @param pontoimobilizado_idpontoimobilizado  Cadastro do id do setor ao qual foi encaminhdo o produto
     */
    public static void insertMovimentacoes(String tipo, String datamovimentacao, String horamovimentacao, String modelo_idmodelo, String funcionarios_idfuncionarios, String pontoimobilizado_idpontoimobilizado) {

        String sql = "INSERT INTO movimentacoes (tipo, datamovimentacao, horamovimentacao, modelo_idmodelo, funcionarios_idfuncionarios, pontoimobilizado_idpontoimobilizado)" +
"VALUES ('"+tipo+"','"+ datamovimentacao+"','"+ horamovimentacao+"','"+ modelo_idmodelo+"','" +funcionarios_idfuncionarios+"','"+ pontoimobilizado_idpontoimobilizado+"');";
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
 * Busca o ID do ponto imobilizado pelo nome
 * @param nome variavel utilizada na busca
 * @return retorno dos dados da busca
 */
    public static String selectIdPontoImobilizado(String nome) {
        
        ResultSet result;
        String sql = "SELECT idpontoimobilizado FROM pontoimobilizado WHERE nome = '" + nome + "';";
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
                id = result.getString("idpontoimobilizado");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
  
    

}
