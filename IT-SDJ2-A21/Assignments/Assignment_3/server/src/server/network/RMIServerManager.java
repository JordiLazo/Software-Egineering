package server.network;

import server.model.ServerChat;
import server.model.ServerLogIn;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerManager implements RMIServer {
    private ServerChat serverChat;
    private ServerLogIn serverLogIn;
    private ArrayList<ClientCallBack> clientCallBack;

    public RMIServerManager(ServerChat serverChat, ServerLogIn serverLogIn) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverChat = serverChat;
        this.serverLogIn = serverLogIn;
        clientCallBack = new ArrayList<>();
    }

    public void startServer() throws AlreadyBoundException, RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server",this);
    }

    public void broadcastMessage(Message message) throws RemoteException {
        for(ClientCallBack messages: clientCallBack){
            messages.updateChat(message);
        }
    }

    @Override
    public boolean addUser(User user) throws RemoteException {
        return serverLogIn.addUser(user);
    }

    @Override
    public boolean checkUsername(String username) throws RemoteException {
        return serverLogIn.checkUsername(username);
    }

    @Override
    public boolean checkLogInUser(User user) throws RemoteException {
        return serverLogIn.checkLogInUser(user);
    }

    @Override
    public void removeUser(User user) throws RemoteException {
        serverLogIn.removeUser(user);
    }

    @Override
    public List<String> getAllUsers() throws RemoteException {
        return serverLogIn.getAllUsers();
    }

    @Override
    public List<Message> getAllMessages() throws RemoteException {
        return serverChat.getAllMessages();
    }

    @Override
    public void addMessage(Message message) throws RemoteException {
        serverChat.addMessage(message);
        broadcastMessage(message);
    }

    @Override
    public void registerClient(ClientCallBack client) throws RemoteException {
        clientCallBack.add(client);
    }
}
