package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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
     * scroll into location and get into
     * landing page
     */
    public void selectCountry() {
        scrollToText("Colombia (Español)");
        clickDynamicElement("Colombia (Español)");
        countryElement.click();
    }

    /**
     * Returns a PrivacyScreen after to do something.
     *
     * @return PrivacyScreen
     */
    public PrivacyScreen returnPrivacyScreen() {
        return new PrivacyScreen(driver);
    }

}