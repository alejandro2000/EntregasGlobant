package com.automation.espn.tests;

import com.automation.espn.pages.CreateAccountModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.automation.espn.utils.constants.RepetitiveExecutionMessages.EMAIL_MESSAGE_INPUT;

public class CreateAccount {
    private CreateAccountModal createAccountModal;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        createAccountModal = new CreateAccountModal(driver);
        driver = createAccountModal.chromeDriverConnection();
        driver.get("https://www.espn.com/?src=co&_adblock=true");
    }

    @Test(description = "Successful user creation - id=00001", dataProvider = "dataProvider")
    public void successfulUserCreation(String name, String lastname, String email, String password, boolean showpass,
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
        Assert.assertTrue(createAccountModal.allMandatoryFields());
    }

    @Test(description = "failed user creation with an already taken email address - id=00003", dataProvider =
            "dataProviderEmail")
    public void failedUserCreationWithAnAlreadyTakenEmailAddress(String name, String lastname, String email,
                                                                 String password, boolean showpass,
                                                                 boolean newsletter) {
        createAccountModal.openTheRegistryModal();
        createAccountModal.fillTheRegistryForm(name, lastname, email, password, showpass, newsletter);
        Assert.assertEquals(createAccountModal.usedEmail(), EMAIL_MESSAGE_INPUT);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Serenity", "Garza", "serenity.garzz17@example.com", "secretpassword12", true, true}
        };
    }

    @DataProvider
    public Object[][] dataProviderEmail() {
        return new Object[][]{
                new Object[]{"Serenity", "Garza", "serenity.garzo12@example.com", "secretpassword12", true, true}
        };
    }

    @AfterMethod
    public void tearDown() {
        createAccountModal.closeBrowser();
    }
}
