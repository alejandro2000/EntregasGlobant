package com.globant.automation.ui.booking;

import org.openqa.selenium.By;

public class FinalStepsLastInfoUi {

    public static final By HOTEL_TITLE = By.cssSelector("h1[class='bui-f-font-display_two bui-spacer--small']");
    public static final By HOTEL_SCORE = By.cssSelector("div.bui-review-score__badge");
    public static final By HOTEL_PRICE = By.cssSelector("span[data-animate-price-group-name='bp_user_total_price']");
    public static final By BOOKER_NAME = By.cssSelector("div.field_name_full_name div.book-form-field-value");
    public static final By BOOKER_EMAIL = By.cssSelector("div.field_name_email_reassurance div.book-form-field-value");
    public static final By BOOKER_PHONE = By.cssSelector("#phone");
    public static final By CREDIT_CARD_TYPE = By.cssSelector("#cc_type");
    public static final By CREDIT_CARD_NUMBER = By.cssSelector("#cc_number");
    public static final By CREDIT_CARD_CVC = By.cssSelector("#cc_cvc");


}
