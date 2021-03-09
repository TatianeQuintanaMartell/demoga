package FrameWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import static FrameWork.Report.configurarRelatorioExtent;
import static FrameWork.Report.fecharRelatorio;

public class TestBase extends DriverManager{

    private static WebDriver driver;
    private static FileOperation fileOperation = new FileOperation();

    public static WebDriver pegarDriver(){
        driver = setDriver(TypeDriver.CHROME);
        return driver;

    }

    @BeforeEach
    public void iniciar(){
        pegarDriver().get(fileOperation.getProperties("url").getProperty("url"));
        configurarRelatorioExtent();

    }

    @AfterEach
    public void terminar(){
        fecharRelatorio();
        fecharDriver();

    }
}
