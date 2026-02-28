package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CRMPage;
import pages.LeadPage;
import pages.LoginPage;

public class LeadTest extends BaseTest {

    @Test
    public void verifyLeadCreation() {

        // ===== Page Objects =====
        LoginPage loginPage = new LoginPage(driver);
        CRMPage crmPage = new CRMPage(driver);
        LeadPage leadPage = new LeadPage(driver);

        // ===== Step 1: Login =====
        loginPage.openLoginPage();
        loginPage.enterEmail("anilshindepatil8263@gmail.com");
        loginPage.enterPassword("@Anils8263");
        loginPage.clickLogin();

        // ===== Step 2: Navigate to CRM → Leads safely =====
        // Overlay handling is done inside CRMPage
        crmPage.clickCRM();
        crmPage.clickLeads();

        // ===== Step 3: Create a new lead =====
        // ===== Step 3: Create a new lead =====
        leadPage.clickActionsButton(); // open the actions dropdown
        leadPage.clickCreateLead();    // select "Create Leads"
        leadPage.enterFirstName("Test");
        leadPage.enterLastName("User");
        leadPage.enterEmail("testuser123@mail.com");
        leadPage.enterPhone("8263804186"); // ✅ fill phone number
        leadPage.clickSave();

        // ===== Step 4: Validation =====
        // Wait until the lead appears in the list
        String expectedLeadName = "Test User";

        boolean isLeadCreated = leadPage.isLeadPresentInList(expectedLeadName);
        Assert.assertTrue(isLeadCreated, "Lead creation failed: " + expectedLeadName + " not found in the list.");

        System.out.println("Lead created successfully: " + expectedLeadName);
    }
}