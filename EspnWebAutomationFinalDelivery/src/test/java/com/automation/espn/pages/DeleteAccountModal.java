package com.automation.espn.pages;

import com.automation.espn.ui.AuthenticationComponent;
import org.openqa.selenium.WebDriver;

import static com.automation.espn.ui.AuthenticationComponent.*;
import static com.automation.espn.ui.UserInteractionMenu.*;

public class DeleteAccountModal extends BasePage {
    public DeleteAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openTheRegistryModal() {
        waitElementToBeClickableItem(USER_ICON,10);
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

    public void goToUserAdministrationCenter() {
        waitNoVisibleIframe();
        waitElementToBeClickable(USER_ICON);
        click(USER_ICON);
        click(ESPN_PROFILE);
        switchToFrame("disneyid-iframe");
        waitVisibleIframe();
        scrollUntilVisibilityOfElement(CANCEL_ACCOUNT);
        click(CANCEL_ACCOUNT);
        click(CONFIRM_ELIMINATION_BUTTON);
        click(CLOSE_MODAL);
        waitVisibleIframe();
        waitNoVisibleIframe();
        click(USER_ICON);
        click(LOG_IN_ITEM);
    }

    public void goToUserAdministrationCenterClosed() {
        waitNoVisibleIframe();
        waitElementToBeClickable(USER_ICON);
        click(USER_ICON);
        click(ESPN_PROFILE);
        switchToFrame("disneyid-iframe");
        waitVisibleIframe();
        click(CANCEL_ACCOUNT);
        click(KEEP_ACCOUNT);
        click(CLOSE_MODAL);
        waitVisibleIframe();
        switchOutOfFrame();
        waitNoVisibleIframe();
    }

    public String userDeleted() {
        return getText(USER_LOGGED_MESSAGE);
    }

    public String noDeletedUser() {
        waitVisibleIframe();
        waitNoVisibleIframe();
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!", "");
    }


}
