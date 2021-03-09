package PageObjects;

import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {
    private WebDriver driver;
    private Waits waits;

    public NewUserPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    public WebElement getButtonNewUser(){
        return waits.esperarVisibilidadeDoElemento(By.id("newUser"));
    }
}
