package com.globant.automation.pages.api;

import com.globant.automation.utils.api.ApiHeadersManipulation;
import com.globant.automation.utils.tests.BaseServices;

import static com.globant.automation.utils.constants.InfoValidationData.API_PRODUCT_ID;

public class DeleteProduct extends BaseServices {

    private static final String DELETE_PRODUCT_SOURCE = "/wp-json/wc/v3/products/" + API_PRODUCT_ID;


    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public DeleteProduct(String baseUrl) {
        super(baseUrl);
    }

    /**
     * Delete a product using the api.
     */
    public void deleteProductFromShoppingStore() {
        jsonResponseDelete(DELETE_PRODUCT_SOURCE, ApiHeadersManipulation.settingUpHeaders());
    }
}
