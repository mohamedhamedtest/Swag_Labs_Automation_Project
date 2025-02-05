package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.utility;

import java.util.List;
import java.util.Set;

import static utilities.utility.generalWep;
import static utilities.utility.generateUniqueNumber;

public class pag2_login {
    private static final Logger log = LogManager.getLogger(pag2_login.class);
    // private static final Logger log = LogManager.getLogger(pag2_login.class);
    static float totalPrice = 0;
    private static List<WebElement> order;
    private static List<WebElement> check;
    private final WebDriver Driver;
    private final By AddToChart = By.xpath("// button[@class]");
    private final By removeChart = By.xpath("//button[contains(text(),'REMOVE')]");
    private final By price = By.xpath("//button[contains(text(),'REMOVE')]/ancestor::div[contains(@class, 'inventory_item')]//div[@class='inventory_item_price']");
    private final By shopping = By.className("shopping_cart_badge");
    private final By carIcon = By.className("shopping_cart_link");


    public pag2_login(WebDriver Driver) {
        this.Driver = Driver;
    }

    public By getAddToshopping() {
        return shopping;
    }

    public pag2_login AddToCart() {

        order = Driver.findElements(AddToChart);
        log.info("number of products in cart: " + order.size());
        for (int i = 1; i <= order.size(); i++) {
            By AddToChart = By.xpath("(//button[@class])[" + i + "]"); // dynamic locator
            utility.click(Driver, AddToChart);

        }
        return this;

    }

    public String getname() {
        try {
            log.info("number of products in select: " + utility.get(Driver, shopping));
            return utility.get(Driver, shopping);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        }


    }

    //هنا بيعرفني انا ضغط ع button or not
    public String seletname() {
        try {
            check = Driver.findElements(removeChart);
            log.info("number of products : {}", check.size());

            return String.valueOf(check.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        }


    }

    public pag2_login addRandomProducte(int upperBound, int totalnumber) {
        Set<Integer> random = generateUniqueNumber(upperBound, totalnumber);
        for (int rand : random) {
            log.info("start to random" + rand);
            By AddToChart = By.xpath("(//button[@class])[" + rand + "]"); // dynamic locator
            utility.click(Driver, AddToChart);
        }
        return this;
    }

    public boolean chick() {
        return getname().equals(seletname());
    }

    public pag3_login clickButton() {
        utility.click(Driver, carIcon);
        // Driver.findElement(login).click();
        return new pag3_login(Driver);
    }

    public boolean pageUrl(String url) {
        try {


            generalWep(Driver).until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getPrice() {

        try {


            List<WebElement> Price = Driver.findElements(price);
            for (int element = 1; element <= Price.size(); element++) {
                By elements = By.xpath("(//button[contains(text(),'REMOVE')]/ancestor::div[contains(@class, 'inventory_item')]//div[@class='inventory_item_price'])[" + element + "]");

                String text = utility.get(Driver, elements);
                log.info("price : " + text);
                totalPrice += Float.parseFloat(text.replace("$", ""));
            }
            log.info("total price : " + totalPrice);

            return String.valueOf(totalPrice);
        } catch (Exception e) {
            log.error(e.getMessage());
            return "0";
        }


    }

}
