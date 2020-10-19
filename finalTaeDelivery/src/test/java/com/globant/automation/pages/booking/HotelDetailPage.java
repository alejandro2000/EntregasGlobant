package com.globant.automation.pages.booking;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.booking.HotelDetailUi.*;

public class HotelDetailPage extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public HotelDetailPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * @return Hotel description.
     */
    public String getHotelDescription() {
        return driver.findElement(HOTEL_DESCRIPTION).getText();
    }

    /**
     * @return Hotel price.
     */
    public String getHotelPrice() {
        return driver.findElement(HOTEL_PRICE).getText();
    }

    /**
     * @return Whether the CheckIn and CheckOut form is visible.
     */
    public boolean isCheckInAndCheckOutVisible() {
        try {
            return driver.findElement(FORM_WITH_FILTERS).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Selects the amount of bedrooms.
     *
     * @param bedrooms Amount.
     * @return Next page.
     */
    public FinalStepsGeneralData selectBedRoomsAmount(int bedrooms) {
        scrollUntilVisibilityOfElement(BEDROOMS_AMOUNT);
        selectFromOptionsByIndex(BEDROOMS_AMOUNT, bedrooms);
        waitElementToBeVisible(RESERVE_HOTEL, 10);
        javascriptClick(RESERVE_HOTEL);
        return new FinalStepsGeneralData(driver);
    }
}
