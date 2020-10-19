package com.globant.automation.utils.api;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

public class ApiHeadersManipulation {

    /**
     * setting up all the configuration headers
     *
     * @return
     */
    public static Headers settingUpHeaders() {
        Header h1 = new Header("Content-Type", "application/json");
        Header h2 = new Header("Authorization", "Basic c2hvcG1hbmFnZXI6YXhZMiByaW1jIFN6TzkgY29iZiBBWkJ3IE5Mblg=");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(h1);
        headerList.add(h2);
        return new Headers(headerList);
    }
}
