package Tasks;

import FrameWork.FileOperation;
import FrameWork.Waits;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import PageObjects.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTask {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static Waits waits;
    private static RegisterPage registerPage;
    private static ProfilePage profilePage;

    public LoginTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        loginPage = new LoginPage(this.driver);
        registerPage = new RegisterPage(this.driver);
        profilePage = new ProfilePage(this.driver);

    }

    public void criarNovoUsuário(){
        loginPage.getButtonNewUser().click();
        validarNovoRegistroDeUsuario();
    }

    public void realizarLogin(){
        loginPage.getUserName().sendKeys(FileOperation.getProperties("login").getProperty("usuario"));
        loginPage.getPassword().sendKeys(FileOperation.getProperties("login").getProperty("senhaValida"));
        loginPage.getButtonLogin().click();
        validarTelaDeProfile();
    }

    public void validarNovoRegistroDeUsuario(){
        WebElement validar = waits.esperarCarregarElemento(registerPage.getLabelLastName());
        Assertions.assertTrue(validar.isDisplayed());
    }

    public void validarTelaDeProfile(){
        WebElement validar = waits.esperarCarregarElemento(profilePage.getButtonDeleteAllBooks());
        Assertions.assertTrue(validar.isDisplayed());
    }
}
