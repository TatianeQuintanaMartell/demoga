package PageObjects;

import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;
    private Waits waits;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getFirstName(){
        return waits.esperarVisibilidadeDoElemento(By.id("firstname"));
    }

    public WebElement getLastName(){
        return waits.esperarVisibilidadeDoElemento(By.id("lastname"));
    }

    public WebElement getUserName(){
        return waits.esperarVisibilidadeDoElemento(By.id("userName"));
    }

    public WebElement getPassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("password"));
    }

    public WebElement getButtonBackToLogin(){
        return waits.esperarVisibilidadeDoElemento(By.id("gotologin"));
    }

    public WebElement getButtonRegister(){
        return waits.esperarVisibilidadeDoElemento(By.id("register"));
    }

    public WebElement getLabelLastName(){
        return waits.esperarVisibilidadeDoElemento(By.id("lastname-label"));
    }

    public WebElement getMensagemSobrePassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("name"));
    }


}
