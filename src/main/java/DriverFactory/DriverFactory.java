package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static ThreadLocal<WebDriver> Driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return Driver.get();
    }

    public static void setDriver(String browser) {
        switch (browser) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start---maxmize");
                Driver.set(new ChromeDriver(options));
                break;
            default:
                EdgeOptions option = new EdgeOptions();
                option.addArguments("start---maxmize");
                Driver.set(new EdgeDriver(option));
        }

    }

    public static void quite() {
        getDriver().quit();
        Driver.remove();
    }
}
