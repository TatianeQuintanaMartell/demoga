package FrameWork;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import java.util.Locale;

public class FakersGenerator {
    private Faker fake;
    private String firstName;
    private String lastName;
    private String userName;

    public FakersGenerator(WebDriver driver){
        fake= new Faker(new Locale("pt-BR"));
    }

    public String getFirstName(){
        return firstName = fake.name().firstName();
    }

    public String getLastName(){
        return lastName = fake.name().lastName();
    }

    public String getUserName(){
        return userName = fake.name().username();
    }

}
