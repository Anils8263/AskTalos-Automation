package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Locators
    private By logo = By.xpath("//img[contains(@alt,'logo')]");
    private By popupCloseBtn = By.xpath("//svg[@class='lucide lucide-x']"); // Update if needed

    // Actions
    public void openHomePage(String url) {
        driver.get(url);
    }

    public void closePopupIfPresent() {
        try {
            if (driver.findElement(popupCloseBtn).isDisplayed()) {
                driver.findElement(popupCloseBtn).click();
                System.out.println("Popup closed successfully.");
            }
        } catch (NoSuchElementException e) {
            // Popup not present, nothing to do
            System.out.println("No popup found.");
        }
    }

    public boolean isLogoDisplayed() {
        waitUtils.waitForVisibility(logo);
        return driver.findElement(logo).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}