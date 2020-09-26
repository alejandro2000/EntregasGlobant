package com.automation.espn.pages;

import static com.automation.espn.ui.UserInteractionMenu.*;
import static com.automation.espn.ui.UserCreationForm.*;
import org.openqa.selenium.WebDriver;

public class CreateAccountModal extends BasePage {
    public CreateAccountModal(WebDriver driver) {
        super(driver);
    }

    public void openTheRegistryModal(){
        waitElementToBeClickable(USER_ICON);
        click(USER_ICON);
        click(LOG_IN_ITEM);
    }

    public void fillTheRegistryForm(String name, String lastname, String email, String password, boolean showpass,
                                    boolean newsletter){
        switchToFrame("disneyid-iframe");
        waitElementToBeClickable(MODAL_FORM);
        click(SIGN_UP_ITEM);
        waitElementToBeClickable(USER_NAME);
        click(USER_NAME);
        type(name,USER_NAME);
        type(lastname,LAST_NAME);
        type(email,EMAIL);
        type(password,PASSWORD);
        checkItem(showpass,SHOW_PASSWORD);
        checkItem(newsletter,NEWS_LETTER);
        waitElementToBeClickable(SIGN_UP);
        click(SIGN_UP);
    }

    public String createdUserName(){
        waitElementToBeClickable(USER_ICON);
        switchOutOfFrame();
        click(USER_ICON);
        return getText(USER_CREATED_MESSAGE).replace("!","");
    }

    public void logOutOfThePlatform(){
        click(USER_ICON);
        click(LOG_OUT_ITEM);
    }
}
