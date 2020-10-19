package com.globant.automation.ui.booking;

import org.openqa.selenium.By;

public class BookingLandingUi {

    public static final By LOCATION = By.id("ss");
    public static final By DATES_ACCOMMODATION = By.cssSelector("div.xp__dates");
    public static final By DATE_NEXT = By.cssSelector("div[data-bui-ref='calendar-next'] svg");
    public static final By GUESTS_SECTION = By.cssSelector("div.xp__guests");
    public static final By ADULTS = By.cssSelector("button[aria-label='Aumenta el número de Adultos']");
    public static final By CHILDREN = By.cssSelector("button[aria-label='Aumenta el número de Niños']");
    public static final By BEDROOMS = By.cssSelector("button[aria-label='Aumenta el número de Habitaciones'");
    public static final By ADULT_CURRENT_AMOUNT = By.cssSelector("button[aria-label='Reduce el número de Adultos'] ~ " +
            "span[aria-hidden]");
    public static final By CHILDREN_CURRENT_AMOUNT = By.cssSelector("button[aria-label='Reduce el número de Niños'] ~" +
            " span[aria-hidden]");
    public static final By BEDROOMS_CURRENT_AMOUNT = By.cssSelector("button[aria-label='Reduce el número de " +
            "Habitaciones'] ~ span[aria-hidden]");
    public static final By CHILDREN_OPTIONS = By.cssSelector("select[name='age']");
    public static final By SEARCH_BUTTON = By.cssSelector("button[type='submit'][data-sb-id='main']");
}
