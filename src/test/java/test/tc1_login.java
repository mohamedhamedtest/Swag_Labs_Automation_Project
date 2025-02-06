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
import utilities.json;
import utilities.log;
import utilities.utility;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({itest.class, iinvokedmethod.class})

public class tc1_login {
    //private static final Logger log = LogManager.getLogger(tc1_login.class);
    private WebDriver Driver;


    @BeforeMethod()
    public void setUp() throws Exception {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : json.GETPropertriesData("pro", "browser");
        log.info(System.getProperty("browser"));


        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("Browser: " + json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }






    /*@BeforeMethod
    public void setUp() throws Exception {

        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }*/

    @Test(alwaysRun = true)
    public void login() throws IOException {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        new pag1_login(getDriver())

                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton();
        log.info("page is opefqewen ");
        utility.screenShoot(getDriver(), "GAZAR");
        Assert.assertTrue(new pag1_login(getDriver()).Assert(json.GETPropertriesData("pro", "url2")));
    }

    @AfterMethod()
    public void quit() throws Exception {
        quite();
    }
}
