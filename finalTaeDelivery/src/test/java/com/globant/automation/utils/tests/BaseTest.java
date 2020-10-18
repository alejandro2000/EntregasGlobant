package com.globant.automation.utils.tests;

import com.globant.automation.pages.booking.BookingTopMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.webdriver", "src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Close the application after completing the test.
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * returns first page
     *
     * @return an initiated page
     */
    protected BookingTopMenuPage returnBookingTopMenuPage() {
        return new BookingTopMenuPage(driver);
    }
}
