package com.automation.espn.tests;

import com.automation.espn.pages.DeleteAccountModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteAccount {

    private DeleteAccountModal deleteAccountModal;
    private WebDriver driver;

    @BeforeClass
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

    /*@Test(description = "failed account elimination id=00005", dataProvider = "dataProviderAccount")
    public void failedAccountElimination(String name, String email, String password) throws InterruptedException {
        deleteAccountModal.openTheRegistryModal();
        deleteAccountModal.signInPlatform(email, password);
        deleteAccountModal.goToUserAdministationCenterClosed();
        Assert.assertEquals(deleteAccountModal.noDeletedUser(), name);
    }*/

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"serenity.garzz12@example.com", "secretpassword12"}
        };
    }

    @DataProvider
    public Object[][] dataProviderAccount() {
        return new Object[][]{
                new Object[]{"Serenity", "serenity.garze16@example.com", "secretpassword12"}
        };
    }

    @AfterTest
    public void tearDown() {
        deleteAccountModal.closeBrowser();
    }
}
