package Question_3_RMI_and_Proxy.rmi.client.core;

import Question_3_RMI_and_Proxy.rmi.client.network.Client;
import Question_3_RMI_and_Proxy.rmi.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
