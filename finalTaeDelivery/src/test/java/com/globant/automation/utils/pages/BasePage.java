package com.globant.automation.utils.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;


/**
 * Base class for all Screen Objects.
 */
public abstract class BasePage {

    protected WebDriver driver;

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    protected BasePage(WebDriver pDriver) {
        this.driver = pDriver;
        initElements();
    }

    /**
     * Page factory to handle driver instance.
     */
    private void initElements() {
        PageFactory.initElements(driver, this);
    }

    /**
     * locates an element in the HTML Doom.
     *
     * @param locator location with an specific strategy.
     * @return the element, ready to interact or ask.
     */
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * look for a list of elements with
     * the same locator in the Doom.
     *
     * @param locator location with an specific strategy.
     * @return a list of elements.
     */
    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * extracts the text of a element.
     *
     * @param element html object.
     * @return the text of the element.
     */
    protected String getText(WebElement element) {
        return element.getText();
    }

    /**
     * @param locator location with an specific strategy.
     * @return the text of the element to get.
     */
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * @param text    To enter in the field.
     * @param locator Location with an specific strategy.
     */
    protected void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * @param action  whether click a check or not.
     * @param locator location with an specific strategy.
     */
    protected void checkItem(boolean action, By locator) {
        if (action) {
            driver.findElement(locator).click();
        }
    }

    /**
     * Perform a click in the page.
     *
     * @param locator location with an specific strategy.
     */
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * @param locator Location with an specific strategy.
     * @return The state of the element.
     */
    protected Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * It wait until the given frame be available and switch to it.
     *
     * @param frame To work with.
     */
    protected void switchToFrame(String frame) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frame)));
    }

    /**
     * Switch to the main content in order to
     * keep interacting with the elements.
     */
    protected void switchOutOfFrame() {
        driver.switchTo().defaultContent();
    }

    /**
     * It scrolls the page until and element be present
     * in the current user visibility.
     *
     * @param locator Location with an specific strategy.
     */
    protected void scrollUntilVisibilityOfElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs a click using javaScript.
     *
     * @param locator Location with an specific strategy.
     */
    protected void javascriptClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Modifies the value of an input using javaScript.
     *
     * @param locator Element to be modified.
     * @param text    To be added.
     */
    protected void javascriptValueInput(By locator, String text) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + text + "';", element);
    }

    /**
     * It scrolls the website to the bottom of the page.
     */
    protected void scrollUntilBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    /**
     * It opens a new chromeDriver session in
     * an specific website.
     *
     * @param url The website url to be opened,
     */
    protected void visitWebSite(String url) {
        driver.get(url);
    }

    /**
     * It closes the chromeDriver session.
     */
    protected void closeBrowser() {
        driver.quit();
    }

    /**
     * Using fluent waits to ask for an element with
     * a polling time.
     *
     * @param locator Location with an specific strategy.
     */
    protected void waitElementToBeClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    /**
     * Wait for an element to be visible with an
     * specific expected condition.
     *
     * @param locator Location with an specific strategy.
     * @param seconds To wait.
     */
    protected void waitElementToBeVisible(By locator, int seconds) {
        try {
            WebElement element = driver.findElement(locator);
            WebElement elementWaiting = new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {

        }
    }

    /**
     * Wait for the page to
     * completly charge.
     */
    protected void waitForPageToReload() {
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(
                        "complete"));
    }

    /**
     * Wait for an element to be clickable with an specific
     * expected condition.
     *
     * @param locator Location with an specific strategy.
     * @param seconds The amount of seconds you want to wait for the element.
     */
    protected void waitElementToBeClickableItem(By locator, int seconds) {
        WebElement element = driver.findElement(locator);
        WebElement elementWaiting = new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * @return The url text where the page is currently
     * active.
     */
    protected String getPageSource() {
        return driver.getPageSource();
    }

    /**
     * Wait for a frame no to be visible, in order to
     * interact with the next elements.
     *
     * @param cssSelector Specific location type.
     */
    protected void waitNoVisibleIframe(String cssSelector) throws Exception {
        Boolean elementWaiting = new WebDriverWait(driver, 8)
                .until(ExpectedConditions.not(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector))));
    }

    /**
     * Wait for a frame to be visible, in order to
     * interact with the elements within it.
     *
     * @param cssSelector Specific location type.
     */
    protected void waitVisibleIframe(String cssSelector) throws Exception {
        WebElement elementWaiting = new WebDriverWait(driver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    /**
     * Wait for a frame no to be visible, in order to
     * interact with the next elements.
     *
     * @param selector Specific location type.
     */
    protected void waitNoVisibleElement(By selector) {
        try {
            Boolean elementWaiting = new WebDriverWait(driver, 8)
                    .until(ExpectedConditions.not(
                            ExpectedConditions.presenceOfElementLocated(selector)));
        } catch (Exception e) {

        }
    }

    /**
     * Ask for the state of an element with text parameter.
     *
     * @param text To be searched.
     * @return the state of the element.
     */
    protected boolean visibilityOfAnElementByText(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Navigate through the date picker grid.
     *
     * @param date Date to be clicked.
     */
    protected void clickOnDate(String date) {
        WebElement element = driver.findElement(By.cssSelector("td[data-date='" + date + "']"));
        element.click();
    }

    /**
     * Select an item from a list of options by Text.
     *
     * @param locator    The html select element.
     * @param textOption Text that the select could contain.
     */
    protected void selectFromOptionsByText(By locator, String textOption) {
        WebElement testDropDown = driver.findElement(locator);
        Select dropdown = new Select(testDropDown);
        dropdown.selectByVisibleText(textOption);
    }

    /**
     * Select an item from a list of options by its index.
     *
     * @param locator The html select element.
     * @param index   Number of the option to select.
     */
    protected void selectFromOptionsByIndex(By locator, int index) {
        WebElement testDropDown = driver.findElement(locator);
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(index);
    }

    /**
     * Switch to a new windows, using windows handles.
     */
    protected void switchToANextWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
}
