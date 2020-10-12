package rest.assured.tests.mockapi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.tasks.mockapi.CreateApiRecordsTask;

import static rest.assured.utils.constants.ApiConstants.*;
import static rest.assured.utils.constants.GeneralTestConstants.RECORDS_TO_CREATE;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class CreateApiRecordsTests {

    private CreateApiRecordsTask createApiRecordsTask;

    @BeforeMethod
    public void setUp() {
        createApiRecordsTask = new CreateApiRecordsTask(MOCK_API_BASE_URL);
    }

    @Test(description = "Initialize the pojo with 20 random data avoiding deplicated emails- id=00002")
    public void testCreateApiRecords() {
        Assert.assertEquals(createApiRecordsTask.consultApiAvailability(TRANSACTION_SERVICE), STATUS_CODE);
        createApiRecordsTask.createRecordsInformation(RECORDS_TO_CREATE);
    }
}
