package PageObjects;

import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreDetailsPage {
    private WebDriver driver;
    private Waits waits;

    public BookStoreDetailsPage(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getButtontAddToYourCollection(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/div[2]/button"));
    }

    public WebElement getCodigoIsbn(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/label"));
    }

    public WebElement getAutor(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div[2]/label"));
    }

    public WebElement getButtonBackToBookStore(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/div[1]/button"));
    }
}
