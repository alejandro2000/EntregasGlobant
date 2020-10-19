package com.globant.automation.tests;

import com.globant.automation.pages.api.AddProductToCart;
import com.globant.automation.pages.api.CreateShoppingProduct;
import com.globant.automation.pages.api.DeleteProduct;
import com.globant.automation.pages.api.VisitCart;
import com.globant.automation.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.globant.automation.utils.DataManupulation.getTotal;
import static com.globant.automation.utils.constants.ApiConstants.BASE_URL;
import static com.globant.automation.utils.constants.TestsConstants.WEBSITE_SHOPOPING_CART;

public class ApiShoppingTest extends BaseTest {

    /**
     * Test consist on interacting with the api of
     * a shopping store.
     * required validations are.
     * -> Total product price in cart.
     * -> Correct count.
     * -> The product is on the list.
     */
    @Test(description = "Consult api elements of a shopping store id=00003", dataProvider = "dataProvider")
    public void addingProductToCart(String productName, String productCost, String productsAmount) {
        CreateShoppingProduct createShoppingProduct = new CreateShoppingProduct(BASE_URL);
        createShoppingProduct.usingApi(productName, productCost);
        AddProductToCart addProductToCart = returnAddProductToCart();
        addProductToCart.openTheWebsite(WEBSITE_SHOPOPING_CART, productName);
        addProductToCart.shopping(productsAmount);
        VisitCart visitCart = addProductToCart.details();
        Assert.assertEquals(visitCart.getProductName(), productName);
        Assert.assertEquals(visitCart.getQuantity(), productsAmount);
        Assert.assertEquals(visitCart.getTotal(), getTotal(productCost, productsAmount));
        DeleteProduct deleteProduct = new DeleteProduct(BASE_URL);
        deleteProduct.deleteProductFromShoppingStore();
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"alejo-productOne", "200", "7"}
        };
    }
}
