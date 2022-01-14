package server.network;

import shared.transferobjects.Message;

import java.util.ArrayList;
import java.util.List;

public class ConectionPool {
    private List<ServerHandler> listOfConnections = new ArrayList<>();

    public void addConnection(ServerHandler serverHandler){
        listOfConnections.add(serverHandler);
    }

    public void broadcastMessage(Message message){
        for (ServerHandler connection: listOfConnections) {
            connection.sendMessageToClient(message);
        }
    }
    public void broadcastUsername(String username){
        for (ServerHandler user: listOfConnections) {
            user.sendUsersToClient(username);
        }
    }
    public void broadcastUserDisconnected(String username){
        for (ServerHandler connection: listOfConnections) {
            connection.sendRemovedUserToClient(username);
        }
    }
    public void removeUser(ServerHandler serverHandler){
        listOfConnections.remove(serverHandler);
    }
}
