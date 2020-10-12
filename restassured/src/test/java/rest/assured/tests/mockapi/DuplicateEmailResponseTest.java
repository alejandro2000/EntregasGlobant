package rest.assured.tests.mockapi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.tasks.mockapi.DuplicateEmailResponseTask;

import static rest.assured.utils.constants.ApiConstants.MOCK_API_BASE_URL;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class DuplicateEmailResponseTest {

    private DuplicateEmailResponseTask duplicateEmailResponseTask;

    @BeforeMethod
    public void setUp() {
        duplicateEmailResponseTask = new DuplicateEmailResponseTask(MOCK_API_BASE_URL);
    }

    @Test(description = "create a record with a taken email - id=00003")
    public void testDuplicateEmailResponse() {
        duplicateEmailResponseTask.createANewRecordWithDataTaken();
    }

}