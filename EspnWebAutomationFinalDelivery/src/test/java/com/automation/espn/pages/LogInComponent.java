package com.automation.espn.pages;

import com.automation.espn.ui.AuthenticationComponent;
import org.openqa.selenium.WebDriver;

import static com.automation.espn.ui.AuthenticationComponent.AUTH_EMAIL;
import static com.automation.espn.ui.AuthenticationComponent.AUTH_PASSWORD;
import static com.automation.espn.ui.UserInteractionMenu.*;

public class LogInComponent extends BasePage {
    public LogInComponent(WebDriver driver) {
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
    }

    public void notSignInPlatform(String email, String password) {
        switchToFrame("disneyid-iframe");
        waitElementToBeClickable(AUTH_EMAIL);
        type(email, AUTH_EMAIL);
        type(password, AUTH_PASSWORD);
        click(AuthenticationComponent.CLOSE_MODAL);
        switchOutOfFrame();
    }

    public String userLogged(){
        waitElementToBeClickableItem(USER_ICON,10);
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!", "");
    }

    public String userLogOutMessage() {
        waitElementToBeClickableItem(USER_ICON,10);
        click(USER_ICON);
        return getText(USER_LOGGED_MESSAGE);

    }
}
