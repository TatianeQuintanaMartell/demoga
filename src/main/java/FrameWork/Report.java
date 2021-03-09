package FrameWork;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class Report {
    public static WebDriver driver;
    private static final String CAMINHO_RELATORIO = System.getProperty("user.dir") + File.separator + "relatorio";
    public static ExtentHtmlReporter htlmRelatorio;
    public static ExtentReports extentRelatorio;
    public static ExtentTest extentTeste;

    public static void configurarRelatorioExtent(){

        CreateFolder.criarPastaParaRelatorio(CAMINHO_RELATORIO);

        htlmRelatorio = new ExtentHtmlReporter(CAMINHO_RELATORIO + File.separator + "Meu relatorio.html");

        htlmRelatorio.config().setDocumentTitle("Relatório de Execução de Automação");
        htlmRelatorio.config().setReportName("Relatório de Execução");
        htlmRelatorio.config().setTheme(Theme.STANDARD); //cor para mostrar na tela
        htlmRelatorio.config().setEncoding("UTF-8"); //reconhece ascentos
        htlmRelatorio.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'\n");
        htlmRelatorio.config().setCSS("\".nav-wrapper \" +\n" +
                "        \"{ background-color: #1E317A !important; } \" +\n" +
                "        \".brand-logo { background-color: #1E317A !important; \" +\n" +
                "        \"padding: 0 10px 0 0 !important; \" +\n" +
                "        \"margin: 0 !important; \" +\n" +
                "        \"position: absolute !important } \" +\n" +
                "        \".report-name { margin-left: 80px !important } \" +\n" +
                "        \".blue.darken-3 { background-color: #1E317A !important; \" +\n" +
                "        \"color: #FFF !important;  \" +\n" +
                "        \"}\"");
        htlmRelatorio.config().setJS("\"$('.brand-logo').html('<img src=\\\\\\\"https://i.imgur.com/qDYwkD2.png\\\\\\\" class=\\\\\\\"db-logo\\\\\\\"/>');\n");
        extentRelatorio = new ExtentReports();
        extentRelatorio.attachReporter(htlmRelatorio);
    }

    public static void fecharRelatorio(){
        extentRelatorio.flush();
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }

    public static void inicializaRelatorioDeTeste(String descricao){
        extentTeste=extentRelatorio.createTest(descricao);

    }
}
