package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingView extends BaseScreen {
    @AndroidFindBy(id = "fragmentHomeLogoImageView")
    private AndroidElement mainTrivagoLogo;
    @AndroidFindBy(id = "fragmentHomeExpandedDealformDestinationTextView")
    private AndroidElement locationTextViewInput;
    @AndroidFindBy(id = "fragmentHomeExpandedDealformSearchTextView")
    private AndroidElement loadedMainSearchHotelsButton;
    @AndroidFindBy(id = "fragmentHotelSearchResultsExpandedDealformCalendarTextView")
    private AndroidElement rangeDate;

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public LandingView(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public boolean landingTrivagoLogo() {
        return mainTrivagoLogo.isDisplayed();
    }

    /**
     * wait for the element to be clickable
     * and click it
     *
     */
    public ListOfTripLocations selectTripInformation() {
        waitForAnElement(driver, loadedMainSearchHotelsButton, 30);
        locationTextViewInput.click();
        return new ListOfTripLocations(driver);
    }

    public String getSelectedDate() {
        return rangeDate.getText();
    }

}
