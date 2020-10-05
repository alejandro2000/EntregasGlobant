package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.weaver.ast.And;

public class ListOfTripLocations extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public ListOfTripLocations(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "activitySearchDestinationSearchEditText")
    private AndroidElement searchLocationInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*searchDestinationSubtitleTextView\")" +
            ".textContains(\"Colombia\")")
    private AndroidElement inputDestination;

    public TripScheduleSection selectDestination(){
        searchLocationInput.sendKeys("Cartagena");
        inputDestination.click();
        return new TripScheduleSection(driver);
    }


}
