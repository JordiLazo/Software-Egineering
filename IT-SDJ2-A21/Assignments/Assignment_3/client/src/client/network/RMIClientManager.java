package client.network;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIClientManager implements Client, ClientCallBack {
    private RMIServer rmiServer;
    private PropertyChangeSupport support;

    public RMIClientManager() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public List<Message> getAllMessages() {
        try {
            return rmiServer.getAllMessages();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all messages");
        }
    }

    @Override
    public List<String> getAllUsernames() {
        try {
            return rmiServer.getAllUsers();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all users");
        }
    }

    @Override
    public void sendMessageToChat(Message message) {
        try {
            rmiServer.addMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean signUpUser(User user) {
        try {
            if(rmiServer.addUser(user)){
                support.firePropertyChange("NewUser",null,user);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void startClient(User user) {
        try {
            UnicastRemoteObject.exportObject(this,0);
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            this.rmiServer =(RMIServer) registry.lookup("Server");
            rmiServer.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLogInUser(User user) {
        try {
            if (rmiServer.checkLogInUser(user)) {
                support.firePropertyChange("CheckLogIn",null,user);
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        try {
            if(rmiServer.checkUsername(username)){
                support.firePropertyChange("CheckConnectionUser",null,username);
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt connect to server");
        }
        return false;
    }

    @Override
    public void updateChat(Message message) throws RemoteException {
        support.firePropertyChange("NewMessage",null,message);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}
