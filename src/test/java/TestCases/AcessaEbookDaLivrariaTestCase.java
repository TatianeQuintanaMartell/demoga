package TestCases;

import FrameWork.Report;
import FrameWork.TestBase;
import Tasks.BookStoreDetailsTask;
import Tasks.BookStoreTask;
import Tasks.LoginTask;
import Tasks.ProfileTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class AcessaEbookDaLivrariaTestCase extends TestBase {
    private WebDriver driver = this.pegarDriver();
    LoginTask loginTask = new LoginTask(driver);
    ProfileTask profileTask = new ProfileTask(driver);
    BookStoreTask bookStoreTask = new BookStoreTask(driver);
    BookStoreDetailsTask bookStoreDetailsTask = new BookStoreDetailsTask(driver);

    @Test
    public void acessarEbookDaLivraria(){
        try {
            Report.inicializaRelatorioDeTeste("Acessando Ebook da livraria");
            loginTask.realizarLogin();
            profileTask.irParaLivraria();
            bookStoreTask.buscarLivro();
            bookStoreDetailsTask.validarCodigoEAutor();
            bookStoreDetailsTask.adiconarLivroAColecao();
            profileTask.irParaItemProfile();

        }
        catch (Exception e){
            Report.extentTeste.log(Status.ERROR, e.getMessage());
        }
    }

}
