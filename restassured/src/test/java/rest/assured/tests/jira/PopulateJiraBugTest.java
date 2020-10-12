package rest.assured.tests.jira;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest.assured.pojos.BankTransactionPojo;
import rest.assured.tasks.jira.CreateJiraBugTask;
import rest.assured.utils.DataValidation;

import java.io.IOException;

import static rest.assured.utils.constants.ApiConstants.JIRA_BASE_URL;
import static rest.assured.utils.constants.ApiConstants.JIRA_STATUS_CODE;

/**
 * Class to populate a Jira bug with the
 * minimum payload.
 *
 * @author Alejandro Taborda Cadavid
 */
public class PopulateJiraBugTest {

    private CreateJiraBugTask createJiraBugTask;

    @BeforeMethod
    public void setUp() {
        createJiraBugTask = new CreateJiraBugTask(JIRA_BASE_URL);
    }

    @Test(description = "Populate a Jira bug with the minimum payload - id=00006", dataProvider = "dataProvider")
    public void testPopulateJiraBug(String projectKey, String title,
                                    String description, String itemType) throws IOException {
        createJiraBugTask.createAJiraBug(projectKey, title, description, itemType);
        Assert.assertEquals(createJiraBugTask.getRequestStatusCode(), JIRA_STATUS_CODE);
    }

    @DataProvider
    public Object[][] dataProvider() {
        BankTransactionPojo bankTransactionPojo = DataValidation.createBankObject();
        return new Object[][]{
                new Object[]{
                        "TES",
                        "MainTitle",
                        "Bug created with the following bank transaction data " + bankTransactionPojo.getEmail()
                                + " " + bankTransactionPojo.getName(),
                        "Bug"
                }
        };
    }
}
