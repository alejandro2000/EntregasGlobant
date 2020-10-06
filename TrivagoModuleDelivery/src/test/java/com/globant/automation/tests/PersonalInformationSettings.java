package com.globant.automation.tests;

import com.globant.automation.screens.*;
import com.globant.automation.utils.constants.TestsConstants;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonalInformationSettings extends BaseMobileTest {

    /**
     * Design a single test case to test the correct behaviour of
     * all these elements, you can use or implement the
     * methods / actions you consider necessary to develop
     * this test, remember that the more you cover all
     * scenarios and elements the better.
     *
     * @author Alejandro Taborda Cadavid
     */
    @Test(description = "updating data privacy - id=00004", dataProvider = "dataProvider")
    public void dataPrivacySettings(boolean appsFlyerState, boolean fireBaseState
            , boolean facebookState) {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        NavigationItemsComponent navigationItemsComponent = privacyScreen.returnNavigationItemsComponent();
        navigationItemsComponent.clickDynamicElement(TestsConstants.CONFIGURATION);
        SettingsScreen settingsScreen = navigationItemsComponent.settingsScreen();
        settingsScreen.goIntoPrivacySettingsSection();
        WorkingWithDataPrivacy workingWithDataPrivacy = settingsScreen.workingWithDataPrivacy();
        workingWithDataPrivacy.checkDataPrivacyElements(appsFlyerState, appsFlyerState, appsFlyerState);
        settingsScreen.clickSettingsSection();
        Assert.assertEquals(workingWithDataPrivacy.checkStateDataPrivacy(appsFlyerState, appsFlyerState,
                appsFlyerState), true);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{true, true, true},
                new Object[]{false, false, false},
                new Object[]{true, false, false},
                new Object[]{false, true, false},
                new Object[]{false, false, true},
        };
    }
}
