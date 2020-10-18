package com.globant.automation.pages;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.ListOfHotelsUi.FIVE_STARS_HOTEL;

public class ListOfHotelsPage extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public ListOfHotelsPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Searches hotels from the result's list.
     */
    public void selectHotelFromList(){
        scrollUntilVisibilityOfElement(FIVE_STARS_HOTEL);
        click(FIVE_STARS_HOTEL);
    }
}
