package rest.assured.tasks.jira;

import rest.assured.baseservice.BaseService;
import rest.assured.utils.JiraDataManipulation;

import static rest.assured.utils.constants.ApiConstants.JIRA_CONSULT_SERVICE;

/**
 * Class to validate the incremental bug id.
 *
 * @author Alejandro Taborda Cadavid
 */
public class AutoIncrementalBugIdTask extends BaseService {
    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public AutoIncrementalBugIdTask(String baseUrl) {
        super(baseUrl);
    }

    public String consultLastItemId(String itemKey) {
        return jsonResponseGet(String.format(JIRA_CONSULT_SERVICE, itemKey),
                JiraDataManipulation.settingUpJiraHeaders()).jsonPath().get("key")
                .toString().replaceAll("\\D+", "");
    }
}
