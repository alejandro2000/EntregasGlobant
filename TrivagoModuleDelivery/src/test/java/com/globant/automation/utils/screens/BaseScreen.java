package com.globant.automation.utils.screens;

import com.globant.automation.utils.CustomWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.pmw.tinylog.Logger;

import static java.lang.String.format;

/**
 * Base class for all Screen Objects.
 */
public abstract class BaseScreen {
    private static final int PERCENT = 100;
    /**
     * The driver.
     */
    protected AndroidDriver<AndroidElement> driver;
    protected CustomWait customWait = new CustomWait();

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public BaseScreen(AndroidDriver<AndroidElement> pDriver) {
        this.driver = pDriver;
        initElements();
    }


    /**
     * Page factory.
     */
    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Tab on back button.
     */
    public void tapBack() {
        driver.navigate().back();
    }

    /**
     * Tab on refresh button.
     */
    public void tapRefresh() {
        driver.navigate().refresh();
    }

    public void waitForAnElement(AndroidDriver<AndroidElement> driver, AndroidElement mobileElement,
                                 long waitTime) {
        customWait.waitAndroidElementToBeClickable(driver, mobileElement, waitTime);
    }

    /**
     * Scroll to the text attribute received by parameter.
     *
     * @param text : text do you want to scroll to
     *
     */
    public void scrollToText(String text) {
        String automator = "new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView(new UiSelector().textContains(\"%s\"))";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        Logger.info(textOnElement.getText());
    }

    /**
     * Scroll to the text attribute received by parameter in a date picker.
     *
     * @param text : text do you want to click
     */
    public void clickDynamicElement(String text) {
        String automator = "new UiSelector().text(\"%s\")";
        AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
        textOnElement.click();
        Logger.info(textOnElement.getText());
    }

    /**
     * let you know if some element is visible.
     *
     * @param text : text of the alament do you want to ask for
     */
    public boolean visibilityOfElement(String text) {
        String automatorString = "new UiSelector().text(\"%s\")";
        AndroidElement element = driver.findElementByAndroidUIAutomator(format(automatorString, text));
        return element.isDisplayed();
    }

    /**
     * let you check a checkbox.
     *
     * @param check          : true for checked state and false for nochecked.
     * @param checkState : element to be checked.
     */
    public void clickOnSavingItems(boolean checkState, AndroidElement check) {
        if (!check.getAttribute("checked").equals("true") && checkState) {
            check.click();
        } else if (check.getAttribute("checked").equals("true") && !checkState) {
            check.click();
        }
    }

    /**
     * let you check the state of a checkbox.
     *
     * @param check : true for checked state and false for nochecked.
     */
    public boolean returnCheckState(AndroidElement check) {
        return Boolean.parseBoolean(check.getAttribute("checked"));
    }

}
