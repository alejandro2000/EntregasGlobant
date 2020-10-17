package com.globant.automation.tests;

import com.globant.automation.utils.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    /**
     *  Test consist in booking in a specific location
     *  and adding all the information to do it, and the
     *  required validations are.
     *  -> Booking Hotel's title.
     *  -> Booking review score.
     *  -> Booking reservation price.
     *  -> Booker name.
     *  -> Booker email.
     *  -> Book origin location.
     */
    @Test(description = "Booking to a destination id=00001", dataProvider = "dataProvider")
    public void failedUserLogin(String location, String adults, String children, String childAge,
                                String bedrooms,String bookerName, String bookerEmail, String originalLocation) {
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Bogotá, Colombia", "3", "1", "9", "1","Alejandro","alejandro.tabordacadavid@gmail.com",
                        "Colombia"}
        };
    }

}
