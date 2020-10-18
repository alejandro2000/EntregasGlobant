package com.globant.automation.pages.booking;

import com.globant.automation.utils.constants.InfoValidationData;
import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import static com.globant.automation.ui.ListOfHotelsUi.*;

public class ListOfHotelsPage extends BasePage {

    Logger log = Logger.getLogger(String.class);

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
    public void selectHotelFromList() {
        scrollUntilVisibilityOfElement(FIVE_STARS_HOTEL);
        click(FIVE_STARS_HOTEL);
    }

    public void saveDateToValidate() {
        InfoValidationData.HOTEL_TITLE = getText(HOTEL_TITLE);
        InfoValidationData.HOTEL_SCORE = getScoreFromHotelCard();
        InfoValidationData.HOTEL_PRICE = getText(HOTEL_PRICE);
        InfoValidationData.AMOUNT_AND_NIGHT_DESCRIPTION = getText(HOTEL_DESCRIPTION);
    }

    public HotelDetailPage selectHotelCard() {
        waitElementToBeVisible(LOADING_HOTELS_WITH_FILTERS, 10);
        waitNoVisibleElement(LOADING_HOTELS_WITH_FILTERS);
        clickHotelCard(CHOOSE_HOTEL_CARD);
        switchToANextWindow();
        return new HotelDetailPage(driver);
    }

    private void clickHotelCard(By chooseHotelCard) {
        try {
            driver.findElement(chooseHotelCard).click();
        } catch (Exception e) {
            log.info("Couldn't properly interact with the click");
        }
    }

    public String getScoreFromHotelCard() {
        return driver.findElement(HOTEL_CARD).getAttribute("data-score");
    }
}
