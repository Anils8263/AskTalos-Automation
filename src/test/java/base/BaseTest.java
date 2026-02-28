package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot on failure
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed: " + result.getName());
            takeScreenshot(result.getName());
        }


        DriverFactory.quitDriver();
    }

    // ===== Screenshot helper =====
    private void takeScreenshot(String testName) {
        try {
            // Cast driver to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Timestamp for uniqueness
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dest = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

            FileUtils.copyFile(source, new File(dest));
            System.out.println("Screenshot saved at: " + dest);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}