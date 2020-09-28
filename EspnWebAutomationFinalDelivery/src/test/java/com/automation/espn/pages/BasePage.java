package com.automation.espn.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.webdriver", "src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void checkItem(boolean action, By locator) {
        if (action == true) {
            driver.findElement(locator).click();
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void switchToFrame(String frame) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frame)));
    }


    public void switchOutOfFrame() {
        driver.switchTo().defaultContent();
    }


    public void scrollUntilVisibilityOfElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollUntilBotton() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public void visitWebSite(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void waitElementToBeClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public void waitElementToBeVisible(By locator, int seconds) {
        WebElement element = driver.findElement(locator);
        WebElement elementWaiting = new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageToReload() {
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitElementToBeClickableItem(By locator, int seconds) {
        try {
            WebElement element = driver.findElement(locator);
            WebElement elementWaiting = new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {

        }
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void waitNoVisibleIframe() {
        try {
            Boolean elementWaiting = new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.not(
                            ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe#disneyid-iframe"))));
        } catch (Exception e) {

        }
    }

    public void waitVisibleIframe() {
        try {
            WebElement elementWaiting = new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div iframe#disneyid-iframe")));
        } catch (Exception e) {
        }
    }


}
