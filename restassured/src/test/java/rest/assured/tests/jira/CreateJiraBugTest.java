package rest.assured.tests.jira;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest.assured.tasks.jira.CreateJiraBugTask;

import java.io.IOException;

import static rest.assured.utils.constants.ApiConstants.JIRA_BASE_URL;
import static rest.assured.utils.constants.ApiConstants.JIRA_STATUS_CODE;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class CreateJiraBugTest {

    private CreateJiraBugTask createJiraBugTask;

    @BeforeMethod
    public void setUp() {
        createJiraBugTask = new CreateJiraBugTask(JIRA_BASE_URL);
    }

    @Test(description = "Create a Jira bug - id=00004", dataProvider = "dataProvider")
    public void testCreateJiraBug(String projectKey, String title,
                                  String description, String itemType) throws IOException {
        createJiraBugTask.createAJiraBug(projectKey, title, description, itemType);
        Assert.assertEquals(createJiraBugTask.getRequestStatusCode(), JIRA_STATUS_CODE);
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                new Object[]{"TES", "MainTitle", "a description about and issue presented", "Bug"}
        };
    }


}
