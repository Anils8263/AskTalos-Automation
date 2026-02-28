package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test
    public void verifyUserSignupFlow() {

        SignupPage signupPage = new SignupPage(driver);

        signupPage.openSignupPage();

        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterEmail("testuser" + System.currentTimeMillis() + "@mail.com");
        signupPage.enterPhone("9876543210");
        signupPage.enterPassword("Test@123");
        signupPage.enterConfirmPassword("Test@123");

        signupPage.clickSignup();
    }
}