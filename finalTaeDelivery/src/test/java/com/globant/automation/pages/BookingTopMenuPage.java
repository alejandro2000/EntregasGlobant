package com.globant.automation.pages;

import com.globant.automation.utils.DataManupulation;
import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.BookingLandingPage.*;
import static com.globant.automation.utils.constants.TestsConstants.CHECK_IN;
import static com.globant.automation.utils.constants.TestsConstants.CHECK_OUT;

public class BookingTopMenuPage extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public BookingTopMenuPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * It opens the website to start the interactions.
     *
     * @param url Of the site to visit.
     */
    public void openTheWebsite(String url) {
        visitWebSite(url);
    }

    /**
     * Type the location of search.
     *
     * @param location place.
     */
    public void addDestination(String location) {
        type(location, LOCATION);
    }

    /**
     * Click on the dates of check in and checkout
     */
    public void addCheckInCheckOutDates() {
        click(DATES_ACCOMMODATION);
        searchMonth(CHECK_IN);
        clickOnDate(DataManupulation.getDatePlusDays(CHECK_IN));
        searchMonth(CHECK_OUT);
        clickOnDate(DataManupulation.getDatePlusDays(CHECK_OUT));
    }

    /**
     * It complete the amount section of the searches form.
     *
     * @param adult           Amount.
     * @param children        Amount.
     * @param bedrooms        Amount.
     * @param yearsOfTheChild years of the child from the select options.
     */
    public void addGuestsInformation(int adult, int children, int bedrooms, String yearsOfTheChild) {
        click(GUESTS_SECTION);
        modifyGuestsAmount(ADULT_CURRENT_AMOUNT, ADULTS, adult);
        modifyGuestsAmount(CHILDREN_CURRENT_AMOUNT, CHILDREN, children);
        modifyGuestsAmount(BEDROOMS_CURRENT_AMOUNT, BEDROOMS, bedrooms);
        selectFromOptions(CHILDREN_OPTIONS, yearsOfTheChild);
    }

    /**
     * It submits the searches form in order to launch the next page.
     *
     * @return The next page.
     */
    public ListOfHotelsPage searchWithFilters() {
        click(SEARCH_BUTTON);
        return new ListOfHotelsPage(driver);
    }

    /**
     * It search the given month through the datePicker
     *
     * @param plusDays days to be added to the current date
     */
    public void searchMonth(long plusDays) {
        String monthOfTheDate =
                DataManupulation.getMonthInSpanishFromADate(DataManupulation.getDatePlusDays(plusDays));
        while (!visibilityOfAnElementByText(monthOfTheDate)) {
            click(DATE_NEXT);
        }
    }

    /**
     * An interaction to add more children, adults or beds,
     * taking care of the actual amount given by the website.
     *
     * @param currentAmount
     * @param locator
     * @param amount
     */
    public void modifyGuestsAmount(By currentAmount, By locator, int amount) {
        int actualAmount = Integer.valueOf(driver.findElement(currentAmount).getText());
        for (int i = actualAmount; i < amount; i++) {
            driver.findElement(locator).click();
        }
    }
}
