package com.globant.automation.pages.api;

import com.globant.automation.utils.api.ApiHeadersManipulation;
import com.globant.automation.utils.pojo.BuildProduct;
import com.globant.automation.utils.tests.BaseServices;
import io.restassured.path.json.JsonPath;

import static com.globant.automation.utils.constants.InfoValidationData.API_PRODUCT_ID;

public class CreateShoppingProduct extends BaseServices {

    private static final String RESOURCE = "/wp-json/wc/v3/products";

    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public CreateShoppingProduct(String baseUrl) {
        super(baseUrl);
    }

    /**
     * Creates a new product.
     *
     * @param name
     * @param price
     */
    public void usingApi(String name, String price) {
        JsonPath jsonPath = jsonResponsePost(RESOURCE, BuildProduct.createProduct(name, price),
                ApiHeadersManipulation.settingUpHeaders());
        API_PRODUCT_ID = jsonPath.get("id").toString();
    }
}
