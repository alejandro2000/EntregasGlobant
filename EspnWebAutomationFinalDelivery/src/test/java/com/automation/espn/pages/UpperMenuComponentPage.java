package com.automation.espn.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.espn.com/?src=com&_adblock=true")
public class UpperMenuComponentPage extends PageObject {

    @FindBy(css = "a#global-user-trigger")
    private WebElement userIcon;


    public void userGoToRegisterModal() {
        clickOn(userIcon);
    }
}
