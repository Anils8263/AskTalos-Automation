package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(ConfigReader.getProperty("explicitWait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Wait until element is visible
    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public void waitForClickability(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until page title contains text
    public void waitForTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    // Wait until URL changes
    public void waitForUrlToChange() {
        String currentUrl = driver.getCurrentUrl();
        wait.until(d -> !driver.getCurrentUrl().equals(currentUrl));
    }

    // ✅ Wait until element becomes invisible (useful for popups/overlays)
    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}