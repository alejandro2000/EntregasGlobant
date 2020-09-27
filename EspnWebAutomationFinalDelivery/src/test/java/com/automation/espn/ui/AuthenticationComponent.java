package com.automation.espn.ui;

import org.openqa.selenium.By;

public class AuthenticationComponent {
    public static final By AUTH_EMAIL = By.cssSelector("input[type='email']");
    public static final By AUTH_PASSWORD = By.cssSelector("input[type='password']");
    public static final By TEL = By.cssSelector("input[type='tel']");
    public static final By AUTH_LOG_IN_BUTTON = By.cssSelector("button[aria-label='Log In']");
    public static final By CLOSE_MODAL = By.cssSelector("button[aria-label='Close account dialog']");
}
