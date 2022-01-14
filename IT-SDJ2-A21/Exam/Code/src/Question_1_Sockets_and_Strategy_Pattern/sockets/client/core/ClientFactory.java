package Question_1_Sockets_and_Strategy_Pattern.sockets.client.core;

import Question_1_Sockets_and_Strategy_Pattern.sockets.client.network.Client;
import Question_1_Sockets_and_Strategy_Pattern.sockets.client.network.SocketClient;

public class ClientFactory {
    private Client client;

    public Client getClient(){
        if(client == null){
            client = new SocketClient();
        }
        return client;
    }
}
