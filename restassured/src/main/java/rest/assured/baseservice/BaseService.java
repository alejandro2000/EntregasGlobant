package rest.assured.baseservice;


import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.assured.utils.constants.ApiConstants;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class BaseService {

    private String baseUrl;
    public Response response;

    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public BaseService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * This method returns the response of any
     * get http request
     *
     * @param resource the resource i want to get from the api.
     * @return response
     */
    public Response jsonResponseGet(String resource) {
        response = given().get(baseUrl + resource);
        return response;
    }

    /**
     * This method returns the JsonPath of any
     * get http request
     *
     * @param resource the resource i want to get from the api.
     * @return JsonPath
     */
    public JsonPath jsonResponseGetObject(String resource) {
        return given().get(baseUrl + resource).jsonPath();
    }

    /**
     * Method that help us know
     * the status of an api call
     *
     * @return the status code
     */
    public int getRequestStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Method to help us know the json response of a get
     * request.
     *
     * @param resource
     * @return
     */
    public String getPrettyJsonResponse(String resource) {
        return given().get(baseUrl + resource).jsonPath().prettify();
    }

    /**
     * This method returns the response of any
     * post http request
     *
     * @param resource what is the resource of the api we want to interact
     * @param pojo     object we want to send
     * @return the response
     */
    public Response jsonResponsePost(String resource, Object pojo) {
        response = RestAssured.given().contentType(ApiConstants.CONTENT_TYPE)
                .body(pojo).when().post(baseUrl + resource);
        return response;
    }

    public Response jsonResponsePost(String resource, Object pojo,Headers headers) {
        response = RestAssured.given().contentType(ApiConstants.CONTENT_TYPE).headers(headers)
                .body(pojo).when().post(baseUrl + resource);
        return response;
    }

    public int consultApiAvailability(String resource){
        jsonResponseGet(resource);
        return getRequestStatusCode();
    }


}
