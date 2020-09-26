package com.automation.espn.ui;

import org.openqa.selenium.By;

public class UserCreationForm {

    public static final By USER_NAME = By.cssSelector("input[name='firstName']");
    public static final By LAST_NAME = By.cssSelector("input[name='lastName']");
    public static final By EMAIL = By.cssSelector("input[name='email']");
    public static final By PASSWORD = By.cssSelector("input[name='newPassword']");
    public static final By SHOW_PASSWORD = By.cssSelector("div.block.show-password-action.ng-scope > label");
    public static final By NEWS_LETTER = By.cssSelector("div[ng-repeat='item in marketingItems'] span");
    public static final By SIGN_UP = By.cssSelector("section.section.section-submit > div > button");
    public static final By MODAL_FORM = By.cssSelector("#did-ui-view");
}
