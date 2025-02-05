package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class pag1_login {

    private final By userName = By.id("user-name");
    private final By Password = By.id("password");
    private final By login = By.xpath("//*[@id=\"login-button\"]");
    private WebDriver Driver;

    public pag1_login(WebDriver driver) {
        Driver = driver;
    }


    public pag1_login username(String nametext) {


        utility.senData(Driver, userName, nametext);
        //  Driver.findElement(a).sendKeys(nametext);
        return this;
    }

    public pag1_login password(String passwordtext) {

        utility.senData(Driver, Password, passwordtext);

        return this;

    }

    public pag2_login botton() {

        utility.click(Driver, login);
        // Driver.findElement(login).click();
        return new pag2_login(Driver);


    }

    public boolean Assert(String url) {
        return Driver.getCurrentUrl().equals(url);
    }
}


