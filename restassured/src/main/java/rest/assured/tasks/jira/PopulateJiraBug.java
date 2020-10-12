package rest.assured.tasks.jira;

import rest.assured.baseservice.BaseService;
/**
 * Class to populate jira bug payload.
 * @author Alejandro Taborda Cadavid
 */
public class PopulateJiraBug extends BaseService {
    /**
     * This is the constructor of the class
     * and it needs the base url depending on
     * which task is using the BaseService.
     *
     * @param baseUrl
     */
    public PopulateJiraBug(String baseUrl) {
        super(baseUrl);
    }
}
