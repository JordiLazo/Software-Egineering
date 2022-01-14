package client.core;

import client.network.Client;
import client.network.RMIClientManager;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client==null){
            client = new RMIClientManager();
        }
        return client;
    }
}
