package Listeners;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import utilities.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static DriverFactory.DriverFactory.getDriver;
import static utilities.utility.screenShoot;


public class iinvokedmethod implements IInvokedMethodListener {


    private static final Logger log = LogManager.getLogger(iinvokedmethod.class);

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        //System.out.println(method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
       
        String path = "Test_output/logs";

        File logFile = utility.getLateFile(path);
        try {

            assert logFile != null;
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            screenShoot(getDriver(), testResult.getName());
            // utility.takescreenShoot(getDriver(), new pag2_login(getDriver()).getAddToshopping());


            if (testResult.getStatus() == ITestResult.FAILURE) {
                log.info("Test Failed!");
            } else if (testResult.getStatus() == ITestResult.SUCCESS) {
                log.info("Test Passed Successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // System.out.println(testResult.getStatus());
        String path = "Test_output/logs";

        File logFile = utility.getLateFile(path);
        try {
            assert logFile != null;
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));

            screenShoot(getDriver(), testResult.getName());
            if (testResult.getStatus() == ITestResult.FAILURE) {
                log.info("Test Failed!");

            } else if (testResult.getStatus() == ITestResult.SUCCESS) {

                // utility.takescreenShoot(getDriver(), new pag2_login(getDriver()).getAddToshopping());
                log.info("Test Passed Successfully!");


                // يمكنك تنفيذ أي كود إضافي هنا في حالة نجاح الاختبار
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}






