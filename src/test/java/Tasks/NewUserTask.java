package Tasks;

import FrameWork.Waits;
import PageObjects.NewUserPage;
import org.openqa.selenium.WebDriver;

public class NewUserTask {
    private static WebDriver driver;
    private static NewUserPage newUserPage;
    private static Waits waits;

    public NewUserTask(WebDriver driver){
        this.driver = driver;
        newUserPage = new NewUserPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void criarNovoUsuario(){
        newUserPage.getButtonNewUser().click();
    }
}
