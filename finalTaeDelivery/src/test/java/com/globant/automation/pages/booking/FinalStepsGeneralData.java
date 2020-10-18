package com.globant.automation.pages.booking;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.FinalStepsGeneralDataUi.*;

public class FinalStepsGeneralData extends BasePage {

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public FinalStepsGeneralData(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Fill personal information.
     *
     * @param name
     * @param lastName
     * @param email
     */
    public void fillPersonalData(String name, String lastName, String email) {
        click(TRAVEL_FOR_WORK);
        type(name, NAME);
        type(lastName, LASTNAME);
        type(email, EMAIL);
        type(email, EMAIL_CONFIRMATION);
        click(WHOM_RESERVE);
        scrollUntilBottom();
    }

    /**
     * @return Next Page.
     */
    public FinalStepsLastInfo openFinalForm() {
        click(LAST_INFORMATION_SUBMIT);
        return new FinalStepsLastInfo(driver);
    }
}
