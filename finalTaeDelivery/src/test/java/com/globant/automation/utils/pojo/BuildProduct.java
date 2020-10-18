package com.globant.automation.utils.pojo;

import com.github.javafaker.Faker;
import com.globant.automation.pojo.Category;
import com.globant.automation.pojo.Image;
import com.globant.automation.pojo.Product;

import java.util.ArrayList;
import java.util.List;

public class BuildProduct {

    private static final String BASE_IMAGE_PATH = "http://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56" +
            "/2013";
    private static final String IMAGE_ONE = BASE_IMAGE_PATH + "/06/T_2_front.jpg";
    private static final String IMAGE_TWO = BASE_IMAGE_PATH + "/06/T_2_back.jpg";
    private static final String PRODUCT_TYPE = "simple";

    public static Product createProduct(String name, String price) {
        Faker faker = new Faker();
        Product product = new Product();
        List<Category> categories = new ArrayList<>();
        List<Image> images = new ArrayList<>();
        Category categoryOne = new Category();
        Category categoryTwo = new Category();
        Image imageOne = new Image();
        Image imageTwo = new Image();
        categoryOne.setId(9);
        categoryTwo.setId(14);
        categories.add(categoryOne);
        categories.add(categoryTwo);
        imageOne.setSrc(IMAGE_ONE);
        imageTwo.setSrc(IMAGE_TWO);
        images.add(imageOne);
        images.add(imageTwo);
        product.setCategories(categories);
        product.setImages(images);
        product.setName(name);
        product.setType(PRODUCT_TYPE);
        product.setRegularPrice(price);
        product.setDescription(faker.book().title());
        product.setShortDescription(faker.commerce().promotionCode());
        return product;
    }
}
