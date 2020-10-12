package rest.assured.tests.mockapi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.tasks.mockapi.EndpointDataValidationTask;

/**
 * Class to see how is the state of the information
 * on the database through the api communication
 *
 * @author Alejandro Taborda Cadavid
 */
public class EndpointDataValidationTest {

    @BeforeMethod
    public void setUp() {

    }

    @Test(description = "Verify That the endPoint is empty - id=00001")
    public void testEndpointDataValidation() {
        EndpointDataValidationTask endpointDataValidationTask = new EndpointDataValidationTask(
                "https://5f8104fe5b1f3f00161a6669.mockapi.io/api/v1/");
        endpointDataValidationTask.clearApiData();
    }

    @AfterMethod
    public void tearDown() {

    }
}
