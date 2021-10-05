package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.core;

import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.network.Client;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.network.SocketClient;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client == null){
            client = new SocketClient();
        }
        return client;
    }
}
