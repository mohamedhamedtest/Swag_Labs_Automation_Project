package test;


import Listeners.iinvokedmethod;
import Listeners.itest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.pag1_login;
import page.pag2_login;
import utilities.json;
import utilities.log;
import utilities.utility;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static DriverFactory.DriverFactory.*;
import static utilities.utility.getALLCookis;
import static utilities.utility.restoreSession;

@Listeners({iinvokedmethod.class, itest.class})

public class tc2_login {
    private WebDriver Driver;
    private Set<Cookie> cookies;

    @BeforeClass
    public void cookies() throws Exception {
        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().manage().window().maximize();

        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new pag1_login(getDriver())
                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton();
        cookies = getALLCookis(getDriver());
        quite();

    }


    @BeforeMethod
    public void setUp() throws Exception {

        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().manage().window().maximize();

        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        restoreSession(getDriver(), cookies);
        getDriver().get(json.GETPropertriesData("pro", "url2"));
        getDriver().navigate().refresh();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkproducts() throws IOException {

        new pag2_login(getDriver())

                .AddToCart();
        //  utility.screenShoot(getDriver(), "GAZrrAR");

        Assert.assertTrue(new pag2_login(getDriver()).chick());
    }

    @Test
    public void addProduct() throws IOException {

        new pag2_login(getDriver())

                .addRandomProducte(4, 6);

        //utility.screenShoot(getDriver(), "GAZrrAR");
        // Assert.assertNotEquals(getDriver().getCurrentUrl(), json.GETPropertriesData("pro", "url2"));

        Assert.assertTrue(new pag2_login(getDriver()).chick());
    }

    @Test
    public void buttonUrl() throws IOException {

        new pag2_login(getDriver())

                .clickButton();
        //  .addRandomProducte(4, 6);

        //utility.screenShoot(getDriver(), "GAZrrAR");
        // Assert.assertNotEquals(getDriver().getCurrentUrl(), json.GETPropertriesData("pro", "url2"));

        //Assert.assertTrue(new pag2_login(getDriver()).pageUrl(json.GETPropertriesData("pro", "url3")));
        Assert.assertTrue(utility.pageUrl(getDriver(), json.GETPropertriesData("pro", "url3")));

    }


    /* @BeforeMethod
    public void setUp() throws Exception {

        setDriver(json.GETPropertriesData("pro", "browser"));
        log.info("open pag");
        getDriver().manage().window().maximize();

        getDriver().get(json.GETPropertriesData("pro", "url"));
        log.info("page is open ");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkproducts() throws IOException {

        new pag1_login(getDriver())
                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton()
                .AddToCart();
        //  utility.screenShoot(getDriver(), "GAZrrAR");

        Assert.assertTrue(new pag2_login(getDriver()).chick());
    }

    @Test
    public void addProduct() throws IOException {

        new pag1_login(getDriver())
                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton()
                .addRandomProducte(4, 6);

        //utility.screenShoot(getDriver(), "GAZrrAR");
        // Assert.assertNotEquals(getDriver().getCurrentUrl(), json.GETPropertriesData("pro", "url2"));

        Assert.assertTrue(new pag2_login(getDriver()).chick());
    }

    @Test
    public void buttonUrl() throws IOException {

        new pag1_login(getDriver())
                .username(json.GetJsonData("login", "username"))
                .password(json.GetJsonData("login", "password"))
                .botton()
                .clickButton();
        //  .addRandomProducte(4, 6);

        //utility.screenShoot(getDriver(), "GAZrrAR");
        // Assert.assertNotEquals(getDriver().getCurrentUrl(), json.GETPropertriesData("pro", "url2"));

        //Assert.assertTrue(new pag2_login(getDriver()).pageUrl(json.GETPropertriesData("pro", "url3")));
        Assert.assertTrue(utility.pageUrl(getDriver(), json.GETPropertriesData("pro", "url3")));

    }

*/
    @AfterMethod
    public void quit() throws Exception {
        quite();
    }

    @AfterClass
    public void quitE() throws Exception {
        cookies.clear();
    }
}
