package com.automation.espn.tests;

import com.automation.espn.steps.CreateAccountStep;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CreateAccount {
    @Steps
    CreateAccountStep createAccountStep;

    @Before
    public void setUp(){
        createAccountStep.OpenEspnPlatform();
    }

    @Test
    public void sucessfulUserCreation() {
        //upperMenuComponentPage.userGoToRegisterModal();
    }

    @After
    public void tearDown(){

    }

}
