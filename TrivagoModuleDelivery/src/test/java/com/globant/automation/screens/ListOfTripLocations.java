package com.globant.automation.screens;

import com.globant.automation.utils.constants.ScreensConstants;
import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListOfTripLocations extends BaseScreen {
    @AndroidFindBy(id = "activitySearchDestinationSearchEditText")
    private AndroidElement searchLocationInput;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*searchDestinationSubtitleTextView\")" +
            ".textContains(\"Colombia\")")
    private AndroidElement inputDestination;

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public ListOfTripLocations(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }


    /**
     * sendkeys to the location input
     * and click into the location.
     *
     */
    public TripScheduleSection selectDestination() {
        searchLocationInput.sendKeys(ScreensConstants.LOCATION);
        inputDestination.click();
        return new TripScheduleSection(driver);
    }


}
