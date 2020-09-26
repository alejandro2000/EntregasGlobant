package com.automation.espn.tests;

import com.automation.espn.pages.CreateAccountModal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Cody", "Obrien", "cody.obrien72@example.com", "secretpassword12", true, true},
                new Object[]{"Bobbie", "Butler", "bobbie.butler12@example.com", "secretpassword12", true, false},
                new Object[]{"Serenity", "Garza", "serenity.garza23@example.com", "secretpassword12", false, true}
        };
    }

    @AfterTest
    public void tearDown() {
        createAccountModal.closeBrowser();
    }
}
