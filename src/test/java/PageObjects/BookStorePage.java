package PageObjects;

import FrameWork.FileOperation;
import FrameWork.TestBase;
import FrameWork.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage extends TestBase {
    private WebDriver driver;
    private Waits waits;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSearchBox(){
        return waits.esperarVisibilidadeDoElemento(By.id("searchBox"));
    }

    public WebElement getHeaderBookStore(){
        return waits.esperarVisibilidadeDoElemento(By.xpath("/html/body/div[1]/div/div/div[1]/div"));
    }
    public WebElement getListagemPelaBusca(){
        String livro = FileOperation.getProperties("livro").getProperty("titulo");
        return waits.esperarVisibilidadeDoElemento(By.id("see-book"+livro));
    }


}
