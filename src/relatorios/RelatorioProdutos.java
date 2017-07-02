/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Natanael BrasRede
 */
/**
 * Busca informações de select no banco de dados para 
 * encaminhar ao iReport e entção mostrar na tela
 * @author Natanael BrasRede
 */
public class RelatorioProdutos {
 public static String selectProdutos() throws ClassNotFoundException, SQLException {
        ResultSet result;
        String sql
                = " SELECT m." + "nome" + " AS Produto, m." + "valorcompra"
                + " AS Valor, m." + "quantidade"
                + " AS Quantidade, t." + "grandeza"
                + " AS Grandeza, f." + "razaosocial"
                + " AS Fabricante FROM modelo m INNER JOIN fabricantes f ON (f.idfabricantes = m.fabricantes_idfabricantes) INNER JOIN tipoproduto t ON (t.idtipoprodutos = m.tipoproduto_idtipoproduto) WHERE m.disponibilidade = true ORDER BY m.nome;";

        try {
            String url = "jdbc:postgresql://localhost:5432/trabalho";
            String usuario = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement stm = con.createStatement();
            result = stm.executeQuery(sql);
            JRResultSetDataSource relatResult = new JRResultSetDataSource(result);
            JasperPrint jpPrint = JasperFillManager.fillReport("iReport/report1.jasper", new HashMap(), relatResult);
            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //false - não encerra a aplicação ao fechar a janela
            jpViewer.setVisible(true);
            jpViewer.toFront(); //apresenta o relatório acima das outras janelas
        } catch (JRException jpExc) {

            JOptionPane.showMessageDialog(null, "Erro ao chamar o relatório!\nErro: " + jpExc);

        }
        return null;

    }
    
}
