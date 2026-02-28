package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserLoginFlow() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.enterEmail("anilshindepatil8263@gmail.com");
        loginPage.enterPassword("@Anils8263");

        loginPage.clickLogin();

        // ✅ Better validation
       // Assert.assertFalse(
                //loginPage.getCurrentUrl().contains("login"),
                //"Login failed - Still on login page"
      //  );
    }
}