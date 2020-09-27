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

    public void goToUserAdministrationCenter() {
        click(USER_ICON);
        click(ESPN_PROFILE);
        switchToFrame("disneyid-iframe");
        waitVisibleIframe();
        scrollUntilVisibilityOfElement(CANCEL_ACCOUNT);
        click(CANCEL_ACCOUNT);
        click(CONFIRM_ELIMINATION_BUTTON);
    }

    public void goToUserAdministationCenterClosed() throws InterruptedException {
        Thread.sleep(2000);
        click(USER_ICON);
        click(ESPN_PROFILE);
        switchToFrame("disneyid-iframe");
        Thread.sleep(2000);
        click(CANCEL_ACCOUNT);
        click(CLOSE_MODAL);
    }

    public String userDeleted() {
        click(USER_ICON);
        return getText(USER_LOGGED_MESSAGE);

    }

    public String noDeletedUser() throws InterruptedException {
        Thread.sleep(10000);
        switchOutOfFrame();
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!", "");
    }


}
