package com.automation.espn;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automation.espn.utils.constants.EnviromentConfiguration.WINDOWS_NAME;
import static com.automation.espn.utils.constants.EnviromentConfiguration.CHROMEDRIVER_PATH;
import static com.automation.espn.utils.constants.EnviromentConfiguration.MAC_NAME;
import static com.automation.espn.utils.constants.EnviromentConfiguration.NAVEGATOR_PROPERTY;

public class BaseImplementation {

    private WebDriver driver;

    public BaseImplementation(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(String platform){
        ChromeOptions options = new ChromeOptions();
        String chromeDriverPath = CHROMEDRIVER_PATH + (platform.equals("mac")?
                MAC_NAME:WINDOWS_NAME);
        System.setProperty(NAVEGATOR_PROPERTY,chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
