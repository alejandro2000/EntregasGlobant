package com.globant.automation.pages.api;

import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

import static com.globant.automation.ui.api.AddProductToCartUi.*;

public class AddProductToCart extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    public AddProductToCart(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * It opens the website to start the interactions.
     *
     * @param url Of the site to visit.
     */
    public void openTheWebsite(String url, String productName) {
        visitWebSite(String.format(url,productName));
    }

    /**
     * Add product to the shoppoing cart.
     * @param amountOfProducts
     */
    public void shopping(String amountOfProducts){
        javascriptInput(PRODUCT_AMOUNT,amountOfProducts);
        click(ADD_TO_CART_PRODUCT);
    }

    /**
     * @return The next page.
     */
    public VisitCart details(){
        click(GO_TO_CART);
        return new VisitCart(driver);
    }
}
