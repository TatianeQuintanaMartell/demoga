package Tasks;

import FrameWork.TestBase;
import FrameWork.Waits;
import PageObjects.BookStorePage;
import PageObjects.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class  ProfileTask extends TestBase{
    private static WebDriver driver;
    private static Waits waits;
    private static ProfilePage profilePage;
    private static BookStorePage bookStorePage;

    public ProfileTask(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        profilePage = new ProfilePage(this.driver);
        bookStorePage = new BookStorePage(this.driver);

    }

    public void irParaLivraria() {
        profilePage.getButtonGoToBookStore().click();
        validarIdaParaLivraria();
    }

    public void irParaItemProfile(){
        profilePage.getOptionProfile().isSelected();
    }

    public void validarIdaParaLivraria(){
        WebElement validar = waits.esperarCarregarElemento(bookStorePage.getHeaderBookStore());
        Assertions.assertTrue(validar.isDisplayed());
    }

}
