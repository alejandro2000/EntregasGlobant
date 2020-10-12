package rest.assured.tasks.jira;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import rest.assured.baseservice.BaseService;
import rest.assured.utils.JiraDataManipulation;

import java.util.ArrayList;
import java.util.List;

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

    public void createAJiraBug(String projectKey,String title,
                               String description,String itemType) {
        jsonResponsePost(JIRA_INSERT_SERVICE,
                JiraDataManipulation.objectCreation(projectKey,title,description,itemType)
                ,JiraDataManipulation.settingUpJiraHeaders());
    }
}
