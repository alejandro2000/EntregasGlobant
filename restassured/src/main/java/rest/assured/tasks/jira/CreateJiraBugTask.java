package rest.assured.tasks.jira;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import rest.assured.baseservice.BaseService;
import rest.assured.utils.DataValidation;
import rest.assured.utils.JiraDataManipulation;
import rest.assured.utils.constants.ApiConstants;

import java.io.IOException;

import static rest.assured.utils.constants.ApiConstants.JIRA_INSERT_SERVICE;

/**
 * Class to create a new Jira bug using
 * http request.
 *
 * @author Alejandro Taborda Cadavid
 */
public class CreateJiraBugTask extends BaseService {
    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public CreateJiraBugTask(String baseUrl) {
        super(baseUrl);
    }

    public Response jsonResponsePost(String resource, Object pojo, Headers headers) throws IOException {
        response = RestAssured.given().contentType(ApiConstants.CONTENT_TYPE).headers(headers)
                .body(pojo).when().post(baseUrl + resource);
        String itemId = response.jsonPath().get("key")
                .toString().replaceAll("\\D+", "");
        DataValidation.storeDataIntoPropertiesFile(itemId);
        return response;
    }

    public void createAJiraBug(String projectKey, String title,
                               String description, String itemType) throws IOException {
        jsonResponsePost(JIRA_INSERT_SERVICE,
                JiraDataManipulation.objectCreation(projectKey, title, description, itemType)
                , JiraDataManipulation.settingUpJiraHeaders());
    }
}
