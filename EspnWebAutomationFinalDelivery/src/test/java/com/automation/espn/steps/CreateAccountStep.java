package com.automation.espn.steps;

import com.automation.espn.pages.UpperMenuComponentPage;
import net.thucydides.core.annotations.Step;

public class CreateAccountStep {

    UpperMenuComponentPage upperMenuComponentPage;

    @Step
    public void OpenEspnPlatform(){
        upperMenuComponentPage.open();
    }



}
