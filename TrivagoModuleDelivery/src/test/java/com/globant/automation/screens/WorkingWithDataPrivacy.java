package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WorkingWithDataPrivacy extends BaseScreen {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public WorkingWithDataPrivacy(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "activityDataManagerAppsFlyerCheckbox")
    private AndroidElement appsFlyer;

    @AndroidFindBy(id = "activityDataManagerFirebaseCheckbox")
    private AndroidElement fireBase;

    @AndroidFindBy(id = "activityDataManagerFacebookCheckbox")
    private AndroidElement facebook;

    @AndroidFindBy(id = "activityDataManagerSaveButton")
    private AndroidElement saveItems;

    private void clickOnSavingItems(){

    }
}
