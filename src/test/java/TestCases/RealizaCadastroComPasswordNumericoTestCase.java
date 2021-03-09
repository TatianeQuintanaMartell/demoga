package TestCases;

import FrameWork.TestBase;
import Tasks.LoginTask;
import Tasks.RegisterTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import FrameWork.Report;

public class RealizaCadastroComPasswordNumericoTestCase extends TestBase {

    private WebDriver driver = this.pegarDriver();
    LoginTask loginTask = new LoginTask(driver);
    RegisterTask registerTask = new RegisterTask(driver);


    @Test
    public void realizarCadastroComPasswordNumerico(){

        try {
            Report.inicializaRelatorioDeTeste("Realizando Cadastro com password numérico inválido");
            loginTask.criarNovoUsuário();
            registerTask.validarMensagemDeErro();

        }
        catch (Exception e){
            Report.extentTeste.log(Status.ERROR, e.getMessage());
        }

    }

}
