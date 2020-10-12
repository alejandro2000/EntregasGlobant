package rest.assured.tests.jira;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.tasks.jira.AutoIncrementalBugIdTask;
import rest.assured.utils.DataValidation;

import java.io.IOException;

import static rest.assured.utils.constants.ApiConstants.JIRA_BASE_URL;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class AutoIncrementalBugIdTest {

    private AutoIncrementalBugIdTask autoIncrementalBugIdTask;

    @BeforeMethod
    public void setUp() {
        autoIncrementalBugIdTask = new AutoIncrementalBugIdTask(JIRA_BASE_URL);
    }

    @Test(description = "validate that the bug id is higher- id=00005")
    public void testAutoIncrementalBug() throws IOException {
        Assert.assertEquals(autoIncrementalBugIdTask.consultLastItemId(DataValidation.readDataFromProperties("lastId")),
                DataValidation.readDataFromProperties("lastId"));
    }
}
