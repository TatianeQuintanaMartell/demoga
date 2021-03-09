package Tasks;

import FrameWork.FileOperation;
import FrameWork.Waits;
import PageObjects.BookStoreDetailsPage;
import PageObjects.BookStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreTask {
    private static WebDriver driver;
    private static Waits waits;
    private static BookStorePage bookStorePage;
    private static BookStoreDetailsPage bookStoreDetailsPage;

    public BookStoreTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        bookStorePage = new BookStorePage(this.driver);
        bookStoreDetailsPage = new BookStoreDetailsPage(this.driver);
    }

    public void buscarLivro(){
        bookStorePage.getSearchBox().sendKeys(FileOperation.getProperties("livro").getProperty("titulo"));
        bookStorePage.getListagemPelaBusca().click();
        validarSeFoiParaTelaDeDetailsBook();
    }

    public void validarSeFoiParaTelaDeDetailsBook(){
        WebElement validar = waits.esperarCarregarElemento(bookStoreDetailsPage.getButtontAddToYourCollection());
        Assertions.assertTrue(validar.isDisplayed());
    }
}
