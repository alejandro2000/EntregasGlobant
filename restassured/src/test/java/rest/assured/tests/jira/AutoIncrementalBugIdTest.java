package rest.assured.tests.jira;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest.assured.utils.DataValidation;

import java.io.IOException;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class AutoIncrementalBugIdTest {

    @BeforeMethod
    public void setUp() {

    }

    @Test(description = "validate that the bug id is higher- id=00005")
    public void testAutoIncrementalBug() throws IOException {
        DataValidation.storeDataIntoPropertiesFile("1");
    }
}
