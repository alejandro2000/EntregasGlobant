package rest.assured.tasks.mockapi;

import org.testng.log4testng.Logger;
import rest.assured.baseservice.BaseService;
import rest.assured.pojos.BankTransactionPojo;
import rest.assured.utils.DataValidation;

import static rest.assured.utils.constants.ApiConstants.TRANSACTION_SERVICE;
import static rest.assured.utils.constants.GeneralTestConstants.EMAIL_ALREADY_TAKEN;

/**
 * Class to consult duplicate email and
 * work with that information.
 *
 * @author Alejandro Taborda Cadavid
 */
public class DuplicateEmailResponseTask extends BaseService {

    Logger logger = Logger.getLogger(CreateApiRecordsTask.class);

    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public DuplicateEmailResponseTask(String baseUrl) {
        super(baseUrl);
    }


    public void createANewRecordWithDataTaken() {
        BankTransactionPojo bankTransactionPojo = jsonResponseGetObject(TRANSACTION_SERVICE)
                .getList("", BankTransactionPojo.class).get(0);
        if (!DataValidation.isTheEmailTaken(getPrettyJsonResponse(TRANSACTION_SERVICE),
                bankTransactionPojo.getEmail())) {
            jsonResponsePost(TRANSACTION_SERVICE, bankTransactionPojo);
        } else {
            logger.error(EMAIL_ALREADY_TAKEN + bankTransactionPojo.getEmail());
        }
    }
}
