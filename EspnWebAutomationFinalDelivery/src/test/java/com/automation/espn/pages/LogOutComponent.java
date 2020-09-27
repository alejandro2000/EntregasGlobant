package com.automation.espn.pages;

import com.automation.espn.ui.AuthenticationComponent;
import org.openqa.selenium.WebDriver;

import static com.automation.espn.ui.AuthenticationComponent.AUTH_EMAIL;
import static com.automation.espn.ui.AuthenticationComponent.AUTH_PASSWORD;
import static com.automation.espn.ui.UserInteractionMenu.*;

public class LogOutComponent extends BasePage {
    public LogOutComponent(WebDriver driver) {
        super(driver);
    }

    public void openTheRegistryModal() {
        waitElementToBeClickable(USER_ICON);
        click(USER_ICON);
        click(LOG_IN_ITEM);
    }

    public void signInPlatform(String email, String password) {
        switchToFrame("disneyid-iframe");
        waitElementToBeClickable(AUTH_EMAIL);
        type(email, AUTH_EMAIL);
        type(password, AUTH_PASSWORD);
        click(AuthenticationComponent.AUTH_LOG_IN_BUTTON);
        switchOutOfFrame();
    }

    public String logOutOfThePlatform() throws InterruptedException {
        Thread.sleep(10000);
        click(USER_ICON);
        click(LOG_OUT_ITEM);
        Thread.sleep(10000);
        click(USER_ICON);
        return getText(USER_LOGGED_MESSAGE);
    }
}
