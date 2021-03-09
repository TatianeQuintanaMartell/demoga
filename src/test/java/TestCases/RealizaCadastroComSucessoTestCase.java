package TestCases;

import FrameWork.Report;
import FrameWork.TestBase;
import Tasks.LoginTask;
import Tasks.RegisterTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizaCadastroComSucessoTestCase extends TestBase {
    private WebDriver driver = this.pegarDriver();
    LoginTask loginTask = new LoginTask(driver);
    RegisterTask registerTask = new RegisterTask(driver);


    @Test
    public void realizarCadastroComSucesso(){

        try {
            Report.inicializaRelatorioDeTeste("Realizando Cadastro com sucesso");
            loginTask.criarNovoUsuário();
            registerTask.registrarUsuario();
            registerTask.voltarAoLogin();
            loginTask.realizarLogin();

        }
        catch (Exception e){
            Report.extentTeste.log(Status.ERROR, e.getMessage());
        }

    }


}
