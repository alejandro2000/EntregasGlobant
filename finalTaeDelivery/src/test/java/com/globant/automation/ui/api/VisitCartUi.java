package com.globant.automation.ui.api;

import org.openqa.selenium.By;

public class VisitCartUi {
    public static final By TOTAL_PRICE = By.cssSelector("td[class='product-subtotal'] span.amount");
    public static final By PRODUCT_NAME = By.cssSelector("td[class='product-name'] a");
    public static final By PRODUCT_AMOUNT = By.cssSelector("input[inputmode='numeric']");

}
