package PageObjects;

import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    public WebElement getUserName(){
        return waits.esperarVisibilidadeDoElemento(By.id("userName"));
    }
    public WebElement getPassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("password"));
    }
    public WebElement getButtonNewUser(){
        return waits.esperarVisibilidadeDoElemento(By.id("newUser"));
    }
    public WebElement getButtonLogin(){
        return waits.esperarVisibilidadeDoElemento(By.id("login"));
    }
    public WebElement getLabelPassword(){
        return waits.esperarVisibilidadeDoElemento(By.id("password-label"));
    }

}
