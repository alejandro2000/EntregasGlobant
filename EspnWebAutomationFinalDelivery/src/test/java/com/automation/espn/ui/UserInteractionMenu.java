package com.automation.espn.ui;

import org.openqa.selenium.By;

public class UserInteractionMenu {

    public static final By USER_ICON = By.cssSelector("a#global-user-trigger");
    public static final By LOG_IN_ITEM = By.cssSelector("li.user a[tref*=login]");
    public static final By SIGN_UP_ITEM = By.cssSelector("a[did-translate='login.label.CREATE_ACCOUNT']");

    public static final By USER_CREATED_MESSAGE = By.cssSelector("li.user li.display-user span");
    public static final By USER_LOGGED_MESSAGE = By.cssSelector("li.user li.display-user");
    public static final By LOG_OUT_ITEM = By.cssSelector("li.user a[onclick*=logout]");


    public static final By ESPN_PROFILE = By.cssSelector("li.user a[tref*='modifyAccount']");
    public static final By CANCEL_ACCOUNT = By.cssSelector("#cancel-account");

    public static final By CONFIRM_ELIMINATION_BUTTON = By.cssSelector("button[did-translate='deactivate.confirmation" +
            ".buttons.confirm']");
}
