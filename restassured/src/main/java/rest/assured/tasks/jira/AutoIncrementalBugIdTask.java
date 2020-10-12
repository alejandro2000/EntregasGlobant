package rest.assured.tasks.jira;

import rest.assured.baseservice.BaseService;

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
}
