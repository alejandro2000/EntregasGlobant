package com.globant.automation.tests;

import com.globant.automation.screens.*;
import com.globant.automation.utils.constants.TestsConstants;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHotels extends BaseMobileTest {

    /**
     * Search view should appear with the previous selection.
     * Validate that the text on the input text field should
     * contain the word “Cartagena” and date range contains
     * the text “1 de nov. - 5 de nov.”.
     *
     * @author Alejandro Taborda Cadavid
     */
    @Test(description = "search hotels - id=00002")
    public void searchHotelsDestination() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        LandingView landingView = privacyScreen.returnLandingView();
        ListOfTripLocations listOfTripLocations = landingView.selectTripInformation();
        TripScheduleSection tripScheduleSection = listOfTripLocations.selectDestination();
        tripScheduleSection.tripPrograming();
        Assert.assertEquals(landingView.getSelectedDate(), TestsConstants.DATES);
    }
}
