/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class RelatorioMovimentacoesData {

    public static void BuscarData(String data) throws ClassNotFoundException, SQLException {

        ResultSet result;

        String sql
                = "SELECT mv.idmovimentacoes, mv.tipo, mv.datamovimentacao, mv.horamovimentacao, m.nome AS Produto, "
                + "f.nome AS Funcionario, p.nome AS Ponto_Imobilziado "
                + "from movimentacoes mv INNER JOIN modelo m ON (m.idmodelo = mv.modelo_idmodelo) INNER JOIN funcionarios f ON (f.idfuncionarios = mv.funcionarios_idfuncionarios) INNER JOIN pontoimobilizado p ON (p.idpontoimobilizado = mv.pontoimobilizado_idpontoimobilizado)"
                + "WHERE mv.datamovimentacao = '"+data+"' ;";
        System.out.println(sql);
        try {

            String url = "jdbc:postgresql://localhost:5432/trabalho";

            String usuario = "postgres";

            String senha = "postgres";

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, usuario, senha);

            Statement stm = con.createStatement();

            result = stm.executeQuery(sql);

            JRResultSetDataSource relatResult = new JRResultSetDataSource(result);

            JasperPrint jpPrint = JasperFillManager.fillReport("iReport/report5.jasper", new HashMap(), relatResult);

            JasperViewer jpViewer = new JasperViewer(jpPrint, false); //false - não encerra a aplicação ao fechar a janela

            jpViewer.setVisible(true);

            jpViewer.toFront(); //apresenta o relatório acima das outras janelas

        } catch (JRException jpExc) {

            JOptionPane.showMessageDialog(null, "Erro ao chamar o relatório!\nErro: " + jpExc);

        }

    }
}
