package com.globant.automation.pages;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.HotelDetailUi.*;

public class HotelDetailPage extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public HotelDetailPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getHotelDescription(){
        return driver.findElement(HOTEL_DESCRIPTION).getText();
    }

    public String getHotelPrice(){
        return driver.findElement(HOTEL_PRICE).getText();
    }

    public boolean isCheckInAndCheckOutVisible(){
        try {
            return driver.findElement(FORM_WITH_FILTERS).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void selectBedRoomsAmount(int bedrooms){
        scrollUntilVisibilityOfElement(BEDROOMS_AMOUNT);
        selectFromOptionsByIndex(BEDROOMS_AMOUNT,bedrooms);
        waitElementToBeVisible(RESERVE_HOTEL,10);
        javascriptClick(RESERVE_HOTEL);
    }
}
