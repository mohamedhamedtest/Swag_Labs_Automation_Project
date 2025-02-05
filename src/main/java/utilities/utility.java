package utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class utility {

    public static void senData(WebDriver Driver, By locator, String x) {
        new WebDriverWait(Driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Driver.findElement(locator).sendKeys(x);


    }

    public static void click(WebDriver Driver, By locator) {
        new WebDriverWait(Driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        Driver.findElement(locator).click();


    }

    public static String get(WebDriver Driver, By locator) {
        new WebDriverWait(Driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        return Driver.findElement(locator).getText();


    }

    public static WebDriverWait generalWep(WebDriver Driver) {
        return new WebDriverWait(Driver, Duration.ofSeconds(5));


    }

    public static void scrolling(WebDriver Driver, By locator) {

        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView();", ByWepElement(Driver, locator));

    }


    public static WebElement ByWepElement(WebDriver Driver, By locator) {
        return Driver.findElement(locator);


    }

    public static void drobDown(WebDriver Driver, By locator, String option) {
        new Select(ByWepElement(Driver, locator)).selectByVisibleText(option);


    }

    public static String getTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ssa");
        return LocalDateTime.now().format(formatter);
    }


    public static void screenShoot(WebDriver Driver, String s) throws IOException {
        try {
            if (Driver == null) {
                System.out.println("Driver is NULL! Cannot take screenshot.");
                return;
            }

            String path = "Test_output/screenShot/";
            File src = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
            File tage = new File(path + s + "-" + getTimeStamp() + ".png");

            FileUtils.copyFile(src, tage);
            Allure.addAttachment(s, Files.newInputStream(Path.of(tage.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void takescreenShoot(WebDriver Driver, By locator) throws IOException {
        try {
            String path = "Test_output/screenShot/";

            Shutterbug.shootPage(Driver, Capture.FULL_SCROLL)
                    .highlight(ByWepElement(Driver, locator))
                    .save(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int generateRandomNumber(int upperBound) {

        return new Random().nextInt(upperBound) + 1;
    }

    //upperBound :5      ;totalnumber:50
    public static Set<Integer> generateUniqueNumber(int upperBound, int totalnumber) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < upperBound) {
            set.add(generateRandomNumber(totalnumber));
        }
        return set;
    }

    public static boolean pageUrl(WebDriver Driver, String url) {
        try {


            generalWep(Driver).until(ExpectedConditions.urlToBe(url));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Set<Cookie> getALLCookis(WebDriver Driver) {
        return Driver.manage().getCookies();
    }

    public static void restoreSession(WebDriver Driver, Set<Cookie> COOKIES) {
        for (Cookie cookie : COOKIES) {
            Driver.manage().addCookie(cookie);
        }
    }


    //log in allure
    public static File getLateFile(String folderpath) {
        File Folder = new File(folderpath);
        File[] files = Folder.listFiles();
        assert files != null;
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


}
