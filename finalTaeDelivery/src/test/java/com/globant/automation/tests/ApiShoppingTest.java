package com.globant.automation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiShoppingTest {

    /**
     * Test consist on interacting with the api of
     * a shopping store.
     * required validations are.
     * -> Amount of people Description.
     * -> Hotel price.
     * -> CheckIn and CheckOut visible.
     */
    @Test(description = "Consult api elements of a shopping store id=00003", dataProvider = "dataProvider")
    public void bookingToLocation() {
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"data"}
        };
    }
}
