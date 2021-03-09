package Tasks;

import FrameWork.FileOperation;
import FrameWork.TestBase;
import FrameWork.Waits;
import PageObjects.BookStoreDetailsPage;
import PageObjects.BookStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreDetailsTask extends TestBase {
    private static WebDriver driver;
    private static Waits waits;
    private static BookStoreDetailsPage bookStoreDetailsPage;
    private static BookStorePage bookStorePage;

    public BookStoreDetailsTask(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
        bookStoreDetailsPage = new BookStoreDetailsPage(this.driver);
        bookStorePage = new BookStorePage(this.driver);
    }

    public void salvarCodigoEAutor(){
        String autor = bookStoreDetailsPage.getAutor().getText();
        FileOperation.setProperties("livro","autor", autor);

        String isbn = bookStoreDetailsPage.getCodigoIsbn().getText();
        FileOperation.setProperties("livro", "isbn", isbn);
    }

    public void validarCodigoEAutor(){
        salvarCodigoEAutor();

        String autorDoProperties = FileOperation.getProperties("livro").getProperty("autor");
        String autorDaTela = waits.esperarCarregarElemento(bookStoreDetailsPage.getAutor()).getText();
        Assertions.assertEquals(autorDoProperties, autorDaTela);

        String isbnDoProperties = FileOperation.getProperties("livro").getProperty("isbn");
        String isbnDaTela = waits.esperarCarregarElemento(bookStoreDetailsPage.getCodigoIsbn()).getText();
        Assertions.assertEquals(isbnDoProperties, isbnDaTela);

    }

    public void adiconarLivroAColecao(){
        bookStoreDetailsPage.getButtontAddToYourCollection().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        bookStoreDetailsPage.getButtonBackToBookStore().click();
        validarSeFoiParaBookStore();
    }

    public void validarSeFoiParaBookStore(){
        WebElement validar = waits.esperarCarregarElemento(bookStorePage.getHeaderBookStore());
        Assertions.assertTrue(validar.isDisplayed());
    }


}
