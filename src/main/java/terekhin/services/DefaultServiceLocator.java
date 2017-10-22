package terekhin.services;

/**
 * Created by Nick on 22.10.17.
 */
public class DefaultServiceLocator {
    private static ClientService clientService = new ClientServiceImpl();
    public ClientService createClientServiceInstance()
    {
        return clientService;
    }
}
