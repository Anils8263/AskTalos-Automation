package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By postLoginIndicator = By.xpath("//span[text()='CRM']");
    private By overlay = By.cssSelector("div[data-state='open']"); // optional overlay

    public void openLoginPage() {
        driver.get("https://ai.asktalos.com");
    }

    public void enterEmail(String email) {
        waitUtils.waitForVisibility(emailField);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();

        // ✅ Wait for CRM menu visible OR overlay gone
        int retries = 5;
        for (int i = 0; i < retries; i++) {
            try {
                // Dismiss overlay if present
                if (driver.findElements(overlay).size() > 0) {
                    waitUtils.waitForInvisibility(overlay);
                }
                // Break loop if post-login element is visible
                if (driver.findElements(postLoginIndicator).size() > 0) {
                    waitUtils.waitForVisibility(postLoginIndicator);
                    break;
                }
            } catch (Exception e) {
                // Retry
            }
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}