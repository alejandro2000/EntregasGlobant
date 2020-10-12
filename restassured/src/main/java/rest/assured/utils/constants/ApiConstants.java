package rest.assured.utils.constants;

/**
 * All constants needed for api setup settings.
 *
 * @author Alejandro Taborda Cadavid
 */
public class ApiConstants {

    public static final String CONTENT_TYPE = "application/json";
    public static final String MOCK_API_BASE_URL = "https://5f8104fe5b1f3f00161a6669.mockapi.io/api/v1/";
    public static final String JIRA_BASE_URL = "https://team-1602453707608.atlassian.net/rest/api/";
    public static final String TRANSACTION_SERVICE = "BankTransactions/";
    public static final String JIRA_INSERT_SERVICE = "3/issue";
    public static final String JIRA_CONSULT_SERVICE = "3/issue/TES-%s";
    public static final int STATUS_CODE = 200;
    public static final int JIRA_STATUS_CODE = 201;

    public static final String JIRA_ITEM_STRUCTURE = "{\n" +
            "    \"fields\": {\n" +
            "       \"project\":\n" +
            "       {\n" +
            "          \"key\": \"%s\"\n" +
            "       },\n" +
            "       \"summary\": \"%s\",\n" +
            "       \"description\": {\n" +
            "           \"type\":\"doc\",\n" +
            "           \"version\": 1,\n" +
            "           \"content\":[\n" +
            "               {\n" +
            "                   \"type\":\"paragraph\",\n" +
            "                   \"content\":[\n" +
            "                       {\n" +
            "                           \"type\":\"text\",\n" +
            "                           \"text\":\"%s\"\n" +
            "                       }\n" +
            "                   ]\n" +
            "               }\n" +
            "           ]\n" +
            "       },\n" +
            "       \"issuetype\": {\n" +
            "          \"name\": \"%s\"\n" +
            "       }\n" +
            "   }\n" +
            "}";

}
