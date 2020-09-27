package com.automation.espn.tests;

import com.automation.espn.pages.LogInComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogIn {
    private LogInComponent logInComponent;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        logInComponent = new LogInComponent(driver);
        driver = logInComponent.chromeDriverConnection();
        driver.get("https://www.espn.com/?src=co&_adblock=true");
    }

    @Test(description = "successful user login id=00006", dataProvider = "dataProvider")
    public void successfulUserLogin(String name, String email, String password) throws InterruptedException {
        logInComponent.openTheRegistryModal();
        logInComponent.signInPlatform(email, password);
        Assert.assertEquals(logInComponent.userLogged(), name);
    }

    @Test(description = "failed user login id=00007", dataProvider = "dataProvider")
    public void failedUserLogin(String email, String password) throws InterruptedException {
        logInComponent.openTheRegistryModal();
        logInComponent.notSignInPlatform(email, password);
        Assert.assertEquals(logInComponent.userLogOutMessage(), "Welcome!");
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"serenity.garze16@example.com", "secretpassword12"}
        };
    }

    @AfterTest
    public void tearDown() {
        logInComponent.closeBrowser();
    }
}
