package com.automation.espn.tests;

import com.automation.espn.pages.DeleteAccountModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DeleteAccount {

    private DeleteAccountModal deleteAccountModal;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        deleteAccountModal = new DeleteAccountModal(driver);
        driver = deleteAccountModal.chromeDriverConnection();
        driver.get("https://www.espn.com/?src=co&_adblock=true");
    }

    @Test(description = "successful account elimination id=00004", dataProvider = "dataProvider")
    public void successfulAccountElimination(String email, String password) {
        deleteAccountModal.openTheRegistryModal();
        deleteAccountModal.signInPlatform(email, password);
        deleteAccountModal.goToUserAdministrationCenter();
        Assert.assertEquals(deleteAccountModal.userDeleted(), "Welcome!");
    }

    @Test(description = "failed account elimination id=00005", dataProvider = "dataProviderAccount")
    public void failedAccountElimination(String name, String email, String password) {
        deleteAccountModal.openTheRegistryModal();
        deleteAccountModal.signInPlatform(email, password);
        deleteAccountModal.goToUserAdministrationCenterClosed();
        Assert.assertEquals(deleteAccountModal.noDeletedUser(), name);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"serenity.garzu87@example.com", "secretpassword13"}
        };
    }

    @DataProvider
    public Object[][] dataProviderAccount() {
        return new Object[][]{
                new Object[]{"Serenity", "serenity.garzu@example.com", "secretpassword13"}
        };
    }

    @AfterMethod
    public void tearDown() {
        deleteAccountModal.closeBrowser();
    }
}
