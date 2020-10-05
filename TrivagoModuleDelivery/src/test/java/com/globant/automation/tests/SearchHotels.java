package com.globant.automation.tests;

import com.globant.automation.screens.*;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHotels extends BaseMobileTest {

    @Test
    public void searchHotelsDestination() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        LandingView landingView = privacyScreen.returnLandingView();
        ListOfTripLocations listOfTripLocations = landingView.selectTripInformation();
        TripScheduleSection tripScheduleSection = listOfTripLocations.selectDestination();
        tripScheduleSection.tripPrograming();
        Assert.assertEquals(landingView.getSelectedDate(),"1 de nov. - 5 de nov.");
    }
}
