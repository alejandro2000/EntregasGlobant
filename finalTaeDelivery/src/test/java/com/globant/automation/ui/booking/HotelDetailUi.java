package com.globant.automation.ui.booking;

import org.openqa.selenium.By;

public class HotelDetailUi {
    public static final By HOTEL_PRICE = By.cssSelector("table.totalPrice-inner div[class='bui-price-display__value " +
            "prco-inline-block-maker-helper']");
    public static final By HOTEL_DESCRIPTION = By.cssSelector("table.totalPrice-inner " +
            "div[class='bui-price-display__label ']");
    public static final By BEDROOMS_AMOUNT = By.cssSelector("div.hprt-block select:nth-child(2)");
    public static final By RESERVE_HOTEL = By.xpath("//button[contains(text(),'Reservaré')]");
    public static final By FORM_WITH_FILTERS = By.cssSelector("form#frm");
}
