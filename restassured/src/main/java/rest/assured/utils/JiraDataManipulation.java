package rest.assured.utils;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import rest.assured.pojos.jira.ItemTemplate;

import java.util.ArrayList;
import java.util.List;

import static rest.assured.utils.constants.ApiConstants.JIRA_ITEM_STRUCTURE;

public class JiraDataManipulation {

    /**
     * creates a pojo using a json response
     *
     * @param projectKey
     * @param title
     * @param description
     * @param itemType
     * @return
     */
    public static ItemTemplate objectCreation(String projectKey, String title,
                                              String description, String itemType) {
        Gson gson = new Gson();
        ItemTemplate itemTemplate = gson.fromJson(
                String.format(JIRA_ITEM_STRUCTURE, projectKey, title, description, itemType), ItemTemplate.class);
        return itemTemplate;
    }

    /**
     * setting up all the configuration headers
     *
     * @return
     */
    public static Headers settingUpJiraHeaders() {
        Header h1 = new Header("Accept", "application/json");
        Header h2 = new Header("Content-Type", "application/json");
        Header h3 = new Header("Authorization", "Basic " +
                "Z2xvYmFscHJvZ3JhbWVyQGdtYWlsLmNvbTpiWjNlMzVyT2RhRFdraE0zNjhyaUIyMUU=");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(h1);
        headerList.add(h2);
        headerList.add(h3);
        return new Headers(headerList);
    }
}
