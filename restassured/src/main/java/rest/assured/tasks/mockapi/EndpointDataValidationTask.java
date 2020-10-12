package rest.assured.tasks.mockapi;

import rest.assured.baseservice.BaseService;
import rest.assured.pojos.BankTransactionPojo;

import static io.restassured.RestAssured.given;
import static rest.assured.utils.constants.ApiConstants.MOCK_API_BASE_URL;
import static rest.assured.utils.constants.ApiConstants.TRANSACTION_SERVICE;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class EndpointDataValidationTask extends BaseService {

    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public EndpointDataValidationTask(String baseUrl) {
        super(baseUrl);
    }

    public void clearApiData() {
        jsonResponseGetObject(TRANSACTION_SERVICE).getList("", BankTransactionPojo.class)
                .forEach(obj -> eraseApiData(TRANSACTION_SERVICE, obj.getId()));
    }

    public int numberOfApiData() {
        return jsonResponseGetObject(TRANSACTION_SERVICE).getList("", BankTransactionPojo.class).size();
    }

    private void eraseApiData(String resource, String id) {
        given().delete(MOCK_API_BASE_URL + resource + id);
    }
}
