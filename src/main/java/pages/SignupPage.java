package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SignupPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // ===== Locators =====
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signupButton = By.cssSelector("button[type='submit']");

    // ===== Actions =====
    public void openSignupPage() {
        driver.get("https://ai.asktalos.com/signup");
    }

    public void enterFirstName(String firstName) {
        waitUtils.waitForVisibility(firstNameField);
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }
}