package shared.networking;

import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {
    boolean addUser(User user) throws RemoteException;
    boolean checkUsername(String username) throws RemoteException;
    boolean checkLogInUser(User user) throws RemoteException;
    void removeUser(User user) throws RemoteException;
    List<String> getAllUsers() throws RemoteException;
    List<Message> getAllMessages() throws RemoteException;
    void addMessage(Message message) throws RemoteException;
    void registerClient(ClientCallBack client) throws RemoteException;
}
