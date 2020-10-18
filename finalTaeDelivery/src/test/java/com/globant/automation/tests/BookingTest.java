package com.globant.automation.tests;

import com.globant.automation.pages.*;
import com.globant.automation.utils.constants.InfoValidationData;
import com.globant.automation.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.globant.automation.utils.DataManupulation.concatenateNameAndLastName;
import static com.globant.automation.utils.DataManupulation.addFinalZeros;
import static com.globant.automation.utils.constants.TestsConstants.WEBSITE;

public class BookingTest extends BaseTest {

    /**
     * Test consist in booking in a specific location
     * and adding all the information to do it, and the
     * required validations are.
     * -> Amount of people Description.
     * -> Hotel price.
     * -> CheckIn and CheckOut visible.
     */
    @Test(description = "Booking to validate data integrity id=00001", dataProvider = "dataProvider")
    public void bookingToLocation(String location, int adults, int children, int bedrooms, String childAge
            , String bookerName,String bookerLastName, String bookerEmail, String originalLocation, String cc,
                                String cvc,String phone) {
        BookingTopMenuPage bookingTopMenuPage = returnBookingTopMenuPage();
        bookingTopMenuPage.openTheWebsite(WEBSITE);
        bookingTopMenuPage.addDestination(location);
        bookingTopMenuPage.addCheckInCheckOutDates();
        bookingTopMenuPage.addGuestsInformation(adults, children, bedrooms, childAge);
        ListOfHotelsPage listOfHotelsPage = bookingTopMenuPage.searchWithFilters();
        listOfHotelsPage.selectHotelFromList();
        listOfHotelsPage.saveDateToValidate();
        listOfHotelsPage.selectHotelCard();
        HotelDetailPage hotelDetailPage = listOfHotelsPage.selectHotelCard();
        Assert.assertEquals(hotelDetailPage.getHotelDescription(), InfoValidationData.AMOUNT_AND_NIGHT_DESCRIPTION);
        Assert.assertEquals(hotelDetailPage.getHotelPrice(), InfoValidationData.HOTEL_PRICE);
        Assert.assertTrue(hotelDetailPage.isCheckInAndCheckOutVisible());
    }

    /**
     * Test consist in booking in a specific location
     * and adding all the information to do it, and the
     * required validations are.
     * -> Booking Hotel's title.
     * -> Booking review score.
     * -> Booking reservation price.
     * -> Booker name.
     * -> Booker email.
     */
    @Test(description = "Booking to a destination filling until the last form id=00002", dataProvider = "dataProvider")
    public void completeBooking(String location, int adults, int children, int bedrooms, String childAge
            , String bookerName,String bookerLastName, String bookerEmail, String originalLocation, String cc,
                                String cvc,String phone) {
        BookingTopMenuPage bookingTopMenuPage = returnBookingTopMenuPage();
        bookingTopMenuPage.openTheWebsite(WEBSITE);
        bookingTopMenuPage.addDestination(location);
        bookingTopMenuPage.addCheckInCheckOutDates();
        bookingTopMenuPage.addGuestsInformation(adults, children, bedrooms, childAge);
        ListOfHotelsPage listOfHotelsPage = bookingTopMenuPage.searchWithFilters();
        listOfHotelsPage.selectHotelFromList();
        listOfHotelsPage.saveDateToValidate();
        listOfHotelsPage.selectHotelCard();
        HotelDetailPage hotelDetailPage = listOfHotelsPage.selectHotelCard();
        FinalStepsGeneralData finalStepsGeneralData = hotelDetailPage.selectBedRoomsAmount(bedrooms);
        finalStepsGeneralData.fillPersonalData(bookerName,bookerLastName,bookerEmail);
        FinalStepsLastInfo finalStepsLastInfo = finalStepsGeneralData.openFinalForm();
        finalStepsLastInfo.fillPersonalVulnerableInformation(cc,cvc,phone);
        Assert.assertEquals(finalStepsLastInfo.getHotelTitle(),InfoValidationData.HOTEL_TITLE);
        Assert.assertEquals(finalStepsLastInfo.getHotelPrice(),InfoValidationData.HOTEL_PRICE);
        Assert.assertEquals(finalStepsLastInfo.getHotelScore(), addFinalZeros(InfoValidationData.HOTEL_SCORE));
        Assert.assertEquals(finalStepsLastInfo.getBookerName(),
                concatenateNameAndLastName(bookerName,bookerLastName));
        Assert.assertEquals(finalStepsLastInfo.getBookerEmail(),bookerEmail);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"Bogotá, Colombia", 3, 1, 1, "9 años", "Alejandro", "Taborda", "Alejandro" +
                        ".tabordacadavid@gmail.com", "Colombia", "3431 321850 02752", "1234","3006591342"}
        };
    }

}
