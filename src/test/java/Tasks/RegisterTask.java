package Tasks;

import FrameWork.FakersGenerator;
import FrameWork.FileOperation;
import FrameWork.TestBase;
import FrameWork.Waits;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTask extends TestBase {
    private static WebDriver driver;
    private static RegisterPage registerPage;
    private static Waits waits;
    private static FakersGenerator fakersGenerator;
    private static LoginPage loginPage;

    public RegisterTask(WebDriver driver){
        this.driver = driver;
        registerPage = new RegisterPage(this.driver);
        waits = new Waits(this.driver);
        fakersGenerator = new FakersGenerator(this.driver);
        loginPage = new LoginPage(this.driver);

    }

    public void registrarUsuario(){

        registerPage.getFirstName().sendKeys(fakersGenerator.getFirstName());
        registerPage.getLastName().sendKeys(fakersGenerator.getLastName());

        String userName = fakersGenerator.getUserName();
        registerPage.getUserName().sendKeys(userName);
        FileOperation.setProperties("login","usuario", userName);

        registerPage.getPassword().sendKeys(FileOperation.getProperties("login").getProperty("senhaValida"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
        driver.findElement(By.className("recaptcha-checkbox-border")).click();

        registerPage.getButtonRegister().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void voltarAoLogin(){
        registerPage.getButtonBackToLogin().click();
        validarSeFoiParaTelaDeLogin();
    }

    public void validarMensagemDeErro(){
        registerPage.getFirstName().sendKeys(fakersGenerator.getFirstName());
        registerPage.getLastName().sendKeys(fakersGenerator.getLastName());
        registerPage.getUserName().sendKeys(fakersGenerator.getUserName());
        registerPage.getPassword().sendKeys(FileOperation.getProperties("login").getProperty("senhaInvalida"));


        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
        driver.findElement(By.className("recaptcha-checkbox-border")).click();
        registerPage.getButtonRegister().click();

        String mensagemDeErroDaSenha = "Passwords must have at least one non alphanumeric character, " +
                "one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special " +
                "character and Password must be eight characters or longer.";

        String mensagemDeErro = waits.esperarCarregarElemento(registerPage.getMensagemSobrePassword()).getText();
        Assertions.assertEquals(mensagemDeErroDaSenha, mensagemDeErro);

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void validarSeFoiParaTelaDeLogin(){
        WebElement valida = waits.esperarCarregarElemento(loginPage.getLabelPassword());
        Assertions.assertTrue(valida.isDisplayed());

    }
}
