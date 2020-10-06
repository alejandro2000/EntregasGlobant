package com.globant.automation.tests;

import com.globant.automation.screens.LandingView;
import com.globant.automation.screens.LocationScreen;
import com.globant.automation.screens.PrivacyScreen;
import com.globant.automation.utils.constants.GeneralMessagesConstants;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataPrivacy extends BaseMobileTest {

    /**
     * Validate that the “Privacidad de datos” view is not
     * visible anymore and check that the user is being
     * redirected to the landing view.
     *
     * @author Alejandro Taborda Cadavid
     */
    @Test(description = "data privacy - id=00001")
    public void dataPrivacySelection() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        Assert.assertEquals(privacyScreen.getPrivacySectionTitle(), GeneralMessagesConstants.PRIVACY_TITLE);
        Assert.assertEquals(privacyScreen.getPrivacyFirtSection(), GeneralMessagesConstants.PRIVACY_FIRST_PARAGRAPH);
        Assert.assertEquals(privacyScreen.getPrivacySecondSection(), GeneralMessagesConstants.PRIVACY_SECOND_PARAGRAPH);
        Assert.assertEquals(privacyScreen.getPrivacyThirdSection(), GeneralMessagesConstants.PRIVACY_THIRD_PARAGRAPH);
        privacyScreen.acceptPrivacyTermsButton();
        LandingView landingView = privacyScreen.returnLandingView();
        Assert.assertEquals(landingView.landingTrivagoLogo(), true);
    }

}
