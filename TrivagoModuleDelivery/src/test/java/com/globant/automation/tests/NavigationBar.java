package com.globant.automation.tests;

import com.globant.automation.screens.*;
import com.globant.automation.utils.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBar extends BaseMobileTest {
    @Test
    public void navigationBar() {
        LocationScreen locationScreen = returnLocationScreen();
        locationScreen.selectCountry();
        PrivacyScreen privacyScreen = locationScreen.returnPrivacyScreen();
        privacyScreen.acceptPrivacyTermsButton();
        NavigationItemsComponent navigationItemsComponent = privacyScreen.returnNavigationItemsComponent();
        Assert.assertEquals(navigationItemsComponent.navigationBar("Búsqueda"),true);
        Assert.assertEquals(navigationItemsComponent.navigationBar("Sorpréndete"),true);
        Assert.assertEquals(navigationItemsComponent.navigationBar("Favoritos"),true);
        Assert.assertEquals(navigationItemsComponent.navigationBar("Configuración"),true);
    }
}
