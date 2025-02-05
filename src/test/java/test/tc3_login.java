package test;

import Listeners.iinvokedmethod;
import Listeners.itest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.pag1_login;
import page.pag2_login;
import page.pag3_login;
import utilities.json;
import utilities.log;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({itest.class, iinvokedmethod.class})

public class tc3_login {
    private WebDriver Driver;


    @BeforeMethod
    public void setUp() throws Exception {

        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void login() throws IOException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String Total = new pag1_login(getDriver())

                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton()
                .addRandomProducte(2, 6)
                .getPrice();
        new pag2_login(getDriver()).clickButton();

        Assert.assertTrue(new pag3_login(getDriver()).compare(Total));
    }

    @AfterMethod
    public void quit() throws Exception {
        quite();
    }
}


