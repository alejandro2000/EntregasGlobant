package com.globant.automation.pages;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.FinalStepsLastInfoUi.*;

public class FinalStepsLastInfo extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public FinalStepsLastInfo(WebDriver pDriver) {
        super(pDriver);
    }

    public void fillPersonalVulnerableInformation(String creditCard, String creditCVC, String phone) {
        type(phone, BOOKER_PHONE);
        selectFromOptionsByIndex(CREDIT_CARD_TYPE, 4);
        javascriptValueInput(CREDIT_CARD_NUMBER, creditCard);
        type(creditCVC, CREDIT_CARD_CVC);
    }

    public String getHotelPrice() {
        return driver.findElement(HOTEL_PRICE).getText();
    }

    public String getBookerName() {
        return driver.findElement(BOOKER_NAME).getText();
    }

    public String getBookerEmail() {
        return driver.findElement(BOOKER_EMAIL).getText();
    }

    public String getHotelScore() {
        return driver.findElement(HOTEL_SCORE).getText();
    }

    public String getHotelTitle() {
        return driver.findElement(HOTEL_TITLE).getText();
    }
}
