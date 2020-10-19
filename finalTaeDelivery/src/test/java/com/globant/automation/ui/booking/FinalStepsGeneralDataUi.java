package com.globant.automation.ui.booking;

import org.openqa.selenium.By;

public class FinalStepsGeneralDataUi {
    public static final By TRAVEL_FOR_WORK = By.cssSelector("#bp_travel_purpose_leasure");
    public static final By NAME = By.cssSelector("#firstname");
    public static final By LASTNAME = By.cssSelector("#lastname");
    public static final By EMAIL = By.cssSelector("#email");
    public static final By EMAIL_CONFIRMATION = By.cssSelector("#email_confirm");
    public static final By WHOM_RESERVE = By.cssSelector("#notstayer_false");
    public static final By LAST_INFORMATION_SUBMIT = By.cssSelector("button[data-popover-content-id='bp-submit" +
            "-popover']");
}
