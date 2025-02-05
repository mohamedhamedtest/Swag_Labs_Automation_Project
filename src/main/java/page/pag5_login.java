package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.log;
import utilities.utility;

public class pag5_login {
    //  private static final Logger log = LogManager.getLogger(pag5_login.class);
    private final WebDriver Driver;
    private final By itmeTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By Total = By.className("summary_total_label");
    private final By finish = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");

    public pag5_login(WebDriver driver) {
        this.Driver = driver;
    }

    public Float itmetotal() {
        return Float.parseFloat(utility.get(Driver, itmeTotal).replace("Item total: $", ""));
    }

    public Float Tax() {
        log.info(utility.get(Driver, tax));
        return Float.parseFloat(utility.get(Driver, tax).replace("Tax: $", ""));
    }

    public Float total() {
       
        log.info("total" + utility.get(Driver, Total));

        return Float.parseFloat(utility.get(Driver, Total).replace("Total: $", ""));
    }

    public String pricetotal() {
        log.info("pricetotal" + " " + (itmetotal() + Tax()));

        return String.valueOf(itmetotal() + Tax());
    }

    public boolean COMPARE() {
        return pricetotal().equals(String.valueOf(total()));

    }

    public pag6_login finsh() {
        utility.click(Driver, finish);
        return new pag6_login(Driver);
    }
}
