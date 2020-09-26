package com.automation.espn.tests;

import com.automation.espn.pages.UpperMenuComponentPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccount {

    private WebDriver driver;
    UpperMenuComponentPage upperMenuComponentPage;

    @BeforeClass
    public void setUp(){
        upperMenuComponentPage = new UpperMenuComponentPage(driver);
        driver = upperMenuComponentPage.chromeDriverConnection("mac");
        driver.get("https://www.espn.com/?src=com&_adblock=true");
    }

    @Test(description = "Sucesful user creation - id=00001")
    public void sucessfulUserCreation(){

        System.out.println("hello world");
    }

    @AfterClass
    public void tearDown(){

    }

}
