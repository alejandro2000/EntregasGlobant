package com.globant.automation.pages.api;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class AddProductToCart extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    protected AddProductToCart(WebDriver pDriver) {
        super(pDriver);
    }

    public void createProduct(String productName,String productPrice){

    }
}
