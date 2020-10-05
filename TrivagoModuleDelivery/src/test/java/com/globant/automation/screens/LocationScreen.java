package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Description:
 */
public class LocationScreen extends BaseScreen {

    private static final String COUNTRY_LANGUAGE = "activityPlatformSelectionConfirmButton";

    @AndroidFindBy(id = COUNTRY_LANGUAGE)
    private AndroidElement countryElement;

    /**
     * Constructor method.
     *
     * @param pDriver : AndroidDriver
     */
    public LocationScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    /**
     * Click on button.
     */
    public void selectCountry() {
        scrollToText("Colombia (Español)");
        clickDynamicElement("Colombia (Español)");
        countryElement.click();
    }

    /**
     * Returns a SecondScreen after to do something.
     *
     *
     * @return SecondScreen
     */
    public PrivacyScreen returnPrivacyScreen() {
        return new PrivacyScreen(driver);
    }

}