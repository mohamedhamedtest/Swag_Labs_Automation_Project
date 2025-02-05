package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pag6_login {
    private static final Logger log = LogManager.getLogger(pag6_login.class);
    private final WebDriver Driver;
    private final By thank = By.cssSelector("#checkout_complete_container > h2");

    public pag6_login(WebDriver driver) {
        this.Driver = driver;
    }

    public boolean finsh() {
        log.info("THANK YOU FOR YOUR ORDE");
        return Driver.findElement(thank).isDisplayed();
    }
}
