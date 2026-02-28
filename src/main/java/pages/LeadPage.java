package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LeadPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public LeadPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // ===== Locators =====
    private By actionsButton = By.cssSelector("button[data-tour='crm-actions']");
    private By createLeadOption = By.xpath("//span[@class='flex-1 whitespace-nowrap' and text()='Create Leads']");
    private By firstNameField = By.xpath("//textarea[@placeholder='First Name *']");
    private By lastNameField = By.xpath("//textarea[@placeholder='Last Name *']");
    private By emailField = By.xpath("//input[@placeholder='Email *']");
    private By phoneField = By.xpath("//input[@placeholder='Phone Number *']");
    private By saveButton = By.xpath("//button[text()='Save']");
    private By leadNameInList = By.xpath("//div[@class='lead-name']"); // replace if needed

    // ===== Actions =====
    public void clickActionsButton() {
        waitUtils.waitForClickability(actionsButton);
        driver.findElement(actionsButton).click();
    }

    public void clickCreateLead() {
        waitUtils.waitForClickability(createLeadOption);
        driver.findElement(createLeadOption).click();
    }

    public void enterFirstName(String firstName) {
        waitUtils.waitForVisibility(firstNameField);
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUtils.waitForVisibility(lastNameField);
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        waitUtils.waitForVisibility(emailField);
        driver.findElement(emailField).sendKeys(email);
    }


public void enterPhone(String phone) {
    waitUtils.waitForVisibility(phoneField);
    driver.findElement(phoneField).sendKeys(phone);
}

    public void clickSave() {
        waitUtils.waitForClickability(saveButton); // Wait until clickable

        try {
            driver.findElement(saveButton).click(); // normal click
        } catch (Exception e) {
            // fallback to JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(saveButton));

    }
    }

    // ===== Assertion Helpers =====
    public boolean isLeadPresentInList(String fullName) {
        By leadInList = By.xpath("//div[@class='lead-name' and text()='" + fullName + "']");
        try {
            waitUtils.waitForVisibility(leadInList);
            return driver.findElements(leadInList).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}