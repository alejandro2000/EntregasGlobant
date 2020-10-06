package com.globant.automation.screens;

import com.globant.automation.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WorkingWithDataPrivacy extends BaseScreen {
    @AndroidFindBy(id = "activityDataManagerAppsFlyerCheckbox")
    private AndroidElement appsFlyer;
    @AndroidFindBy(id = "activityDataManagerFirebaseCheckbox")
    private AndroidElement fireBase;
    @AndroidFindBy(id = "activityDataManagerFacebookCheckbox")
    private AndroidElement facebook;
    @AndroidFindBy(id = "activityDataManagerSaveButton")
    private AndroidElement saveItems;

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : AndroidDriver
     */
    public WorkingWithDataPrivacy(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    public void checkDataPrivacyElements(boolean appsFlyerState, boolean fireBaseState
            , boolean facebookState) {
        clickOnSavingItems(appsFlyerState, appsFlyer);
        clickOnSavingItems(fireBaseState, fireBase);
        clickOnSavingItems(facebookState, facebook);
        saveItems.click();
    }

    public boolean checkStateDataPrivacy(boolean appsFlyerState, boolean fireBaseState
            , boolean facebookState) {
        if (returnCheckState(appsFlyer) == appsFlyerState &&
                returnCheckState(fireBase) == fireBaseState && returnCheckState(facebook) == facebookState) {
            return true;
        } else {
            return false;
        }
    }
}
