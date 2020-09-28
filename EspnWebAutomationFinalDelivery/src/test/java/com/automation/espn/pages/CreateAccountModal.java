package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;

import static com.automation.espn.ui.UserCreationForm.*;
import static com.automation.espn.ui.UserInteractionMenu.*;

public class CreateAccountModal extends BasePage {
    public CreateAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openTheRegistryModal() {
        waitNoVisibleIframe();
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
        waitElementToBeVisible(SIGN_UP,10);
        click(SIGN_UP);
    }
    public void fillTheRegistryFormEmail(String name, String lastname, String email, String password, boolean showpass,
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
    }

    public void noTofillTheRegistryForm() {
        switchToFrame("disneyid-iframe");
        waitElementToBeVisible(MODAL_FORM,10);
        click(SIGN_UP_ITEM);
        waitElementToBeVisible(USER_NAME,10);
        click(USER_NAME);
        waitElementToBeVisible(LAST_NAME,10);
        click(LAST_NAME);
        waitElementToBeVisible(EMAIL,10);
        click(EMAIL);
        waitElementToBeVisible(PASSWORD,10);
        click(PASSWORD);
        waitElementToBeVisible(SIGN_UP,10);
        click(SIGN_UP);
        waitElementToBeVisible(LAST_MANDATORY_FIELD, 10);
    }

    public String createdUserName() {
        waitVisibleIframe();
        waitNoVisibleIframe();
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!", "");
    }

    public boolean allMandatoryFields() {
        return findElements(MANDATORY_FIELDS).stream().allMatch(element -> element.getText().contains("Please enter"));
    }

    public String usedEmail() {
        try {
            waitElementToBeVisible(USED_EMAIL_ADRESS,10);
            return findElement(USED_EMAIL_ADRESS).getText().substring(0, 46);
        }catch (Exception e){
            return "Text not found";
        }
    }

    public void logOutOfThePlatform() {
        waitVisibleIframe();
        waitNoVisibleIframe();
        click(USER_ICON);
        click(LOG_OUT_ITEM);
    }
}
