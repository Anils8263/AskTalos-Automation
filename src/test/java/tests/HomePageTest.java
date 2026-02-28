package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigReader;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoadsSuccessfully() {

        HomePage homePage = new HomePage(driver);

        // Open the homepage
        homePage.openHomePage(ConfigReader.getProperty("baseUrl"));

        // Close popup if it appears
        homePage.closePopupIfPresent();

        // Verify homepage logo is displayed
        Assert.assertTrue(
                homePage.isLogoDisplayed(),
                "Homepage logo was expected to be visible but was not displayed."
        );

        // Verify page title
        Assert.assertTrue(
                homePage.getPageTitle().contains("AskTalos"),
                "Homepage title does not contain expected text. Actual title: "
                        + homePage.getPageTitle()
        );
    }
}