package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;

import static com.automation.espn.ui.UserCreationForm.*;
import static com.automation.espn.ui.UserInteractionMenu.*;

public class CreateAccountModal extends BasePage {
    public CreateAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openTheRegistryModal() {
        waitElementToBeClickable(USER_ICON);
        click(USER_ICON);
        click(LOG_IN_ITEM);
    }

    public void fillTheRegistryForm(String name, String lastname, String email, String password, boolean showpass,
                                    boolean newsletter) {
        switchToFrame("disneyid-iframe");
        waitElementToBeClickable(MODAL_FORM);
        click(SIGN_UP_ITEM);
        waitElementToBeClickable(USER_NAME);
        click(USER_NAME);
        type(name, USER_NAME);
        type(lastname, LAST_NAME);
        type(email, EMAIL);
        type(password, PASSWORD);
        waitElementToBeVisible(SHOW_PASSWORD, 10);
        waitElementToBeClickable(SHOW_PASSWORD);
        checkItem(showpass, SHOW_PASSWORD);
        checkItem(newsletter, NEWS_LETTER);
        waitElementToBeClickable(SIGN_UP);
        click(SIGN_UP);
    }

    public void noTofillTheRegistryForm() {
        switchToFrame("disneyid-iframe");
        waitElementToBeClickable(MODAL_FORM);
        click(SIGN_UP_ITEM);
        waitElementToBeClickable(USER_NAME);
        click(USER_NAME);
        waitElementToBeClickable(LAST_NAME);
        click(LAST_NAME);
        waitElementToBeClickable(EMAIL);
        click(EMAIL);
        waitElementToBeClickable(PASSWORD);
        click(PASSWORD);
        waitElementToBeClickable(SIGN_UP);
        click(SIGN_UP);
        waitElementToBeVisible(LAST_MANDATORY_FIELD, 10);
    }

    public String createdUserName() {
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!", "");
    }

    public boolean allMandatoryFields() {
        return findElements(MANDATORY_FIELDS).stream().allMatch(element -> element.getText().contains("Please enter"));
    }

    public String usedEmail() {
        waitElementToBeVisible(USED_EMAIL_ADRESS, 10);
        return findElement(USED_EMAIL_ADRESS).getText().substring(0, 46);
    }

    public void logOutOfThePlatform() {
        click(USER_ICON);
        click(LOG_OUT_ITEM);
    }
}
