package com.automation.espn.tests;

import com.automation.espn.pages.CreateAccountModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automation.espn.utils.constants.RepetitiveExecutionMessages.EMAIL_MESSAGE_INPUT;

public class CreateAccount {
    CreateAccountModal createAccountModal;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        createAccountModal = new CreateAccountModal(driver);
        driver = createAccountModal.chromeDriverConnection();
        driver.get("https://www.espn.com/?src=co&_adblock=true");
    }

    @Test(description = "Sucesful user creation - id=00001", dataProvider = "dataProvider")
    public void sucessfulUserCreation(String name, String lastname, String email, String password, boolean showpass,
                                      boolean newsletter) {
        createAccountModal.openTheRegistryModal();
        createAccountModal.fillTheRegistryForm(name, lastname, email, password, showpass, newsletter);
        Assert.assertEquals(createAccountModal.createdUserName(), name);
        createAccountModal.logOutOfThePlatform();
    }

    @Test(description = "Failed user creation - id=00002")
    public void failedUserCreation() {
        createAccountModal.openTheRegistryModal();
        createAccountModal.noTofillTheRegistryForm();
        Assert.assertEquals(createAccountModal.allMandatoryFields(), true);
    }

    @Test(description = "failed user creation with an already taken email adress - id=00003", dataProvider =
            "dataProviderEmail")
    public void failedUserCreationWithAnAlreadyTakenEmailAdress(String name, String lastname, String email, String password, boolean showpass,
                                                                boolean newsletter) {
        createAccountModal.openTheRegistryModal();
        createAccountModal.fillTheRegistryForm(name, lastname, email, password, showpass, newsletter);
        Assert.assertEquals(createAccountModal.usedEmail(), EMAIL_MESSAGE_INPUT);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Serenity", "Garza", "serenity.garzo2@example.com", "secretpassword12", true, true}
        };
    }

    @DataProvider
    public Object[][] dataProviderEmail() {
        return new Object[][]{
                new Object[]{"Serenity", "Garza", "serenity.garzo2@example.com", "secretpassword12", true, true}
        };
    }

    @AfterTest
    public void tearDown() {
        createAccountModal.closeBrowser();
    }
}
