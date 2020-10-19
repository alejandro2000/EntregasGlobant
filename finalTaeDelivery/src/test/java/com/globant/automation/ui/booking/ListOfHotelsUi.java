package com.globant.automation.ui.booking;

import org.openqa.selenium.By;

public class ListOfHotelsUi {

    public static final By HOTEL_CARD = By.cssSelector("div#hotellist_inner div.sr_card_no_hover:nth-child(3)");
    public static final By FIVE_STARS_HOTEL = By.cssSelector("a[data-id='class-5']");
    public static final By LOADING_HOTELS_WITH_FILTERS = By.cssSelector("div[class='sr-usp-overlay__container " +
            "is_stuck']");
    private static final String SECOND_HOTEL_FINAL = "div#hotellist_inner div.sr_card_no_hover:nth-child(3) ";
    public static final By HOTEL_TITLE = By.cssSelector(SECOND_HOTEL_FINAL + "span.sr-hotel__name");
    public static final By HOTEL_PRICE = By.cssSelector(SECOND_HOTEL_FINAL + "div.bui-price-display__value");
    public static final By HOTEL_DESCRIPTION = By.cssSelector(SECOND_HOTEL_FINAL + "div.bui-price-display__label");
    public static final By CHOOSE_HOTEL_CARD = By.cssSelector(SECOND_HOTEL_FINAL + " div.sr-cta-button-row");
}
