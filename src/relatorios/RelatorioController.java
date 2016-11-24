package relatorios;

import forfoodmvc.modelo.JpaUtil;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static forfoodmvc.modeloAntigo.ConnectionFactory.getConnection;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class RelatorioController {

    public static void geraRelatorio(final String jrxml, final HashMap param, JFrame frame) {
        //Gera ProgressBar
        GlassPaneWorker worker = new GlassPaneWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");
                    Connection con = getConnection();
                    Map parameters = param;
                    JasperReport report = JasperCompileManager.compileReport("src/relatorios/" + jrxml + ".jrxml");
                    JasperPrint impressao = JasperFillManager.fillReport(report, parameters, con );
                    JasperExportManager.exportReportToPdfFile(impressao, "relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
                    File arquivo = new File("relatorios/" + jrxml + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
                    Desktop.getDesktop().open(arquivo);
                } catch (IOException | JRException e  ) {
                    JOptionPane.showMessageDialog(null, "Erro ao Gerar o Relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(e.getMessage());
                }
                Thread.sleep(2500);
                return null;
            }
        };
        worker.execute(frame, "Gerando relatório...");
    }

   


    public static void geraRelatorioFluxoCaixa(String data, JFrame frame) {
        HashMap params = new HashMap<>();
        params.put("dataConsulta", data);
        geraRelatorio("Fluxojrxml", params, frame);
    }
    
    public static void geraRelatorioPratos(JFrame frame){
        geraRelatorio("RelatorioPratos", null, frame);
    }
     public static void geraRelatorioPedidoDia(String data, JFrame frame) {
        HashMap params = new HashMap<>();
        params.put("data", data);
        geraRelatorio("PedidosDia", params, frame);
    }
    public static void geraFuncionarioMes(String data, String data2, JFrame frame) {
        HashMap params = new HashMap<>();
        params.put("dataInicio", data);
        params.put("dataFinal", data2);
        geraRelatorio("Funcionario", params, frame);
    }
    public static void geraPratoVendido(String data, String data2, JFrame frame) {
        HashMap params = new HashMap<>();
        params.put("dataInicio", data);
        params.put("dataFinal", data2);
        geraRelatorio("RelatorioPratoVendido", params, frame);
    }
    
    public static void geraRelatorioClientes(JFrame frame){
        geraRelatorio("Clientes", null, frame);
    }

   

}
