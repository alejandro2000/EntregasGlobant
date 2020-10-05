package com.globant.automation.tests;

import com.globant.automation.screens.*;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInformationSettings extends BaseMobileTest {

    /**
     * Verify something.
     *
     * @author Alejandro Taborda Cadavid
     */
    @Test
    public void dataPrivacySettings() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        NavigationItemsComponent navigationItemsComponent = privacyScreen.returnNavigationItemsComponent();
        navigationItemsComponent.clickDynamicElement("Configuración");
        SettingsScreen settingsScreen = navigationItemsComponent.settingsScreen();
        settingsScreen.goIntoPrivacySettingsSection();
        WorkingWithDataPrivacy workingWithDataPrivacy = settingsScreen.workingWithDataPrivacy();
        workingWithDataPrivacy.checkDataPrivacyElements(false,false,false);
        settingsScreen.clickSettingsSection();
        Assert.assertEquals(workingWithDataPrivacy.checkStateDataPrivacy(false, false, false),true);
    }
}
