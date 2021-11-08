package rmi.touppercasemvvmrmi.socketuppercaseversion.client.core;

import rmi.touppercasemvvmrmi.socketuppercaseversion.client.network.Client;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.network.RMIClientImpl;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client == null){
            client = new RMIClientImpl();
        }
        return client;
    }
}
