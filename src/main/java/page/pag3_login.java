package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.log;
import utilities.utility;

import java.util.List;

public class pag3_login {

    static float totalPrice = 0;
    private final WebDriver Driver;
    private final By price = By.xpath("//button[contains(text(),'REMOVE')]/ancestor::div[contains(@class, 'cart_item')]//div[@class='inventory_item_price']");
    private final By checkout = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");

    public pag3_login(WebDriver Driver) {
        this.Driver = Driver;
    }

    public String GetPrice() {

        try {


            List<WebElement> Price = Driver.findElements(price);
            for (int element = 1; element <= Price.size(); element++) {
                By elements = By.xpath("(//button[contains(text(),'REMOVE')]/ancestor::div[contains(@class, 'cart_item')]//div[@class='inventory_item_price'])[" + element + "]");

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

    public boolean compare(String price) {
        return GetPrice().equals(price);
    }

    public pag4_login presSheckout() {
        utility.click(Driver, checkout);
        return new pag4_login(Driver);
    }
}
