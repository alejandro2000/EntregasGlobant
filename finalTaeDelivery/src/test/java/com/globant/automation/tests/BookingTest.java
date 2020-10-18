package com.globant.automation.tests;

import com.globant.automation.pages.BookingTopMenuPage;
import com.globant.automation.pages.ListOfHotelsPage;
import com.globant.automation.utils.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    /**
     * Test consist in booking in a specific location
     * and adding all the information to do it, and the
     * required validations are.
     * -> Booking Hotel's title.
     * -> Booking review score.
     * -> Booking reservation price.
     * -> Booker name.
     * -> Booker email.
     * -> Book origin location.
     */
    @Test(description = "Booking to a destination id=00001", dataProvider = "dataProvider")
    public void failedUserLogin(String location, int adults, int children, int bedrooms, String childAge
            , String bookerName, String bookerEmail, String originalLocation) {
        BookingTopMenuPage bookingTopMenuPage = returnBookingTopMenuPage();
        bookingTopMenuPage.openTheWebsite("https://www.booking.com/index.es.html");
        bookingTopMenuPage.addDestination(location);
        bookingTopMenuPage.addCheckInCheckOutDates();
        bookingTopMenuPage.addGuestsInformation(adults, children, bedrooms, childAge);
        ListOfHotelsPage listOfHotelsPage = bookingTopMenuPage.searchWithFilters();
        listOfHotelsPage.selectHotelFromList();


        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Bogotá, Colombia", 3, 1, 1, "9 años", "Alejandro", "alejandro.tabordacadavid@gmail" +
                        ".com",
                        "Colombia"}
        };
    }

}
