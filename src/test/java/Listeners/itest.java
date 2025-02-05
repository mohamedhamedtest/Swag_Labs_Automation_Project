package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class itest implements ITestListener {

    private static final Logger log = LogManager.getLogger(itest.class);

    public void onTestStart(ITestResult result) {
        log.info("test case " + result.getName() + "start");
    }

    public void onTestSuccess(ITestResult result) {

        log.info("test case" + result.getName() + "pass");


    }


    public void onTestSkipped(ITestResult result) {
        log.info("test case " + result.getName() + "skipp");

    }


}
