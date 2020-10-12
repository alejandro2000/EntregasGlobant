package rest.assured.tests.mockapi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.tasks.mockapi.EndpointDataValidationTask;

import static rest.assured.utils.constants.ApiConstants.*;
import static rest.assured.utils.constants.GeneralTestConstants.RECORDS_AMOUNT;

/**
 * Class to see how is the state of the information
 * on the database through the api communication
 *
 * @author Alejandro Taborda Cadavid
 */
public class EndpointDataValidationTest {

    private EndpointDataValidationTask endpointDataValidationTask;

    @BeforeMethod
    public void setUp() {
        endpointDataValidationTask = new EndpointDataValidationTask(
                MOCK_API_BASE_URL);
    }

    @Test(description = "Verify That the endPoint is empty - id=00001")
    public void testEndpointDataValidation() {
        Assert.assertEquals(endpointDataValidationTask.consultApiAvailability(TRANSACTION_SERVICE), STATUS_CODE);
        endpointDataValidationTask.clearApiData();
        Assert.assertEquals(endpointDataValidationTask.numberOfApiData(), RECORDS_AMOUNT);
    }
}
