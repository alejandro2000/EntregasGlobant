package com.globant.automation.ui.api;

import org.openqa.selenium.By;

public class AddProductToCartUi {
    public static final By PRODUCT_AMOUNT = By.cssSelector("input[name='quantity']");
    public static final By ADD_TO_CART_PRODUCT = By.cssSelector("button[name='add-to-cart']");
    public static final By GO_TO_CART = By.cssSelector("div.woocommerce-message a[class='button wc-forward']");
}
