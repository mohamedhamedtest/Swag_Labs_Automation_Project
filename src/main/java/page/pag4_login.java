package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class pag4_login {
    private final WebDriver Driver;

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By Code = By.id("postal-code");
    private final By Continue = By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input");

    public pag4_login(WebDriver driver) {
        this.Driver = driver;

    }

    public pag4_login totalname(String firstname, String lastname, String code) {
        utility.senData(Driver, firstName, firstname);
        utility.senData(Driver, lastName, lastname);
        utility.senData(Driver, Code, code);
        return this;
    }

    public pag5_login CONTINUE() {
        utility.click(Driver, Continue);
        return new pag5_login(Driver);
    }


}
