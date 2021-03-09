package PageObjects;

import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    private WebDriver driver;
    private Waits waits;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getButtonGoToBookStore(){
        return waits.esperarElementoFicarClicavel(By.id("gotoStore"));
    }

    public WebElement getOptionProfile(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
    }

    public WebElement getButtonDeleteAllBooks(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div[3]/button"));

    }

}
