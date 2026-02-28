package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.time.Duration;

public class CRMPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // ===== Constructor =====
    public CRMPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // ===== Locators =====
    private By crmMenu = By.xpath("//span[text()='CRM']");
    private By leadsTab = By.cssSelector("button[data-tour='crm-tab-leads']");
    private By overlay = By.cssSelector("div[data-state='open']"); // overlay div

    // ===== Actions =====
    public void handleOverlayIfPresent() {
        int attempts = 5; // max retries
        for (int i = 0; i < attempts; i++) {
            try {
                // Check if overlay is visible
                if (driver.findElements(overlay).size() > 0) {
                    waitUtils.waitForInvisibility(overlay); // wait until gone
                } else {
                    break; // no overlay, proceed
                }
            } catch (Exception e) {
                // just continue and retry
            }
        }
    }

    public void clickCRM() {
        handleOverlayIfPresent();       // ✅ robust overlay handling
        waitUtils.waitForClickability(crmMenu);
        driver.findElement(crmMenu).click();
    }

    public void clickLeads() {
        waitUtils.waitForClickability(leadsTab);
        driver.findElement(leadsTab).click();
    }
}