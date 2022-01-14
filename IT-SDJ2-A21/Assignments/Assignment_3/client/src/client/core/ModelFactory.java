package client.core;

import client.model.ClientChat;
import client.model.ClientChatManager;
import client.model.ClientLogIn;
import client.model.ClientLogInManager;

public class ModelFactory {
    private final ClientFactory clientFactory;
    private ClientChat clientChat;
    private ClientLogIn clientLogIn;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public ClientChat getClientChat(){
        if(clientChat == null){
            clientChat = new ClientChatManager(clientFactory.getClient());
        }
        return clientChat;
    }

    public ClientLogIn getClientLogIn(){
        if(clientLogIn == null){
            clientLogIn = new ClientLogInManager(clientFactory.getClient());
        }
        return clientLogIn;
    }
}
