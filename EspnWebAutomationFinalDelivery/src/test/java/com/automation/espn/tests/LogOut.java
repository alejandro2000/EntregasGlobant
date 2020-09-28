package com.automation.espn.tests;

import com.automation.espn.pages.LogOutComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogOut {

    private LogOutComponent logOutComponent;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        logOutComponent = new LogOutComponent(driver);
        driver = logOutComponent.chromeDriverConnection();
        driver.get("https://www.espn.com/?src=co&_adblock=true");
    }

    @Test(description = "succesful user logout id=00008", dataProvider = "dataProvider")
    public void succesfulUserLogout(String email,String password){
        logOutComponent.openTheRegistryModal();
        logOutComponent.signInPlatform(email,password);
        Assert.assertEquals(logOutComponent.logOutOfThePlatform(),"Welcome!");
    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                new Object[]{"serenity.garzx0@example.com", "secretpassword12"}
        };
    }

    @AfterTest
    public void tearDown() {
        logOutComponent.closeBrowser();
    }
}
