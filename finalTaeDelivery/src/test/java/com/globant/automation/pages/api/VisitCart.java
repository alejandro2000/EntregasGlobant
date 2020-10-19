package com.globant.automation.pages.api;

import com.globant.automation.ui.api.VisitCartUi;
import com.globant.automation.utils.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class VisitCart extends BasePage {
    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver : WebDriverDriver.
     */
    protected VisitCart(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * @return product name
     */
    public String getProductName() {
        return driver.findElement(VisitCartUi.PRODUCT_NAME).getText();
    }

    /**
     * @return product quantity.
     */
    public String getQuantity() {
        return driver.findElement(VisitCartUi.PRODUCT_AMOUNT).getAttribute("value");
    }

    /**
     * @return product total detail.
     */
    public String getTotal() {
        String finalTotal = driver.findElement(VisitCartUi.TOTAL_PRICE).getText();
        return finalTotal.replace(".00", "").replace(",", "").replace("$", "");
    }
}
