package com.globant.automation.tests;

import com.globant.automation.screens.LocationScreen;
import com.globant.automation.screens.NavigationItemsComponent;
import com.globant.automation.screens.PrivacyScreen;
import com.globant.automation.utils.constants.TestsConstants;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBar extends BaseMobileTest {

    /**
     * Validate the four options are being shown inside
     * <p>
     * the navigation bar: Búsqueda, Sorprendete, Favoritos, Configuración.
     *
     * @author Alejandro Taborda Cadavid
     */
    @Test(description = "Navigation Bar - id=00003")
    public void navigationBar() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        NavigationItemsComponent navigationItemsComponent = privacyScreen.returnNavigationItemsComponent();
        Assert.assertEquals(navigationItemsComponent.navigationBar(TestsConstants.SEARCH), true);
        Assert.assertEquals(navigationItemsComponent.navigationBar(TestsConstants.SURPRISE), true);
        Assert.assertEquals(navigationItemsComponent.navigationBar(TestsConstants.FAVORITES), true);
        Assert.assertEquals(navigationItemsComponent.navigationBar(TestsConstants.CONFIGURATION), true);
    }
}
