package rest.assured.tasks.mockapi;

import rest.assured.baseservice.BaseService;
import rest.assured.pojos.BankTransactionPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseClass to consume the http essential
 * requests.
 *
 * @author Alejandro Taborda Cadavid
 */
public class EndpointDataValidationTask extends BaseService {

    private List<BankTransactionPojo> bankTransactionPojos = new ArrayList<>();

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

    public void clearApiData(){
        jsonResponseGet("/BankTransactions");
        System.out.println(getRequestStatusCode());
        System.out.println(getPrettyJsonResponse("/BankTransactions"));
    }
}
