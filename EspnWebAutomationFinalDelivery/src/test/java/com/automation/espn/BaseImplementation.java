package com.automation.espn;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
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
        return driver;
    }


    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String text,By locator){
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void visitWebSite(String url){
        driver.get(url);
    }
}
