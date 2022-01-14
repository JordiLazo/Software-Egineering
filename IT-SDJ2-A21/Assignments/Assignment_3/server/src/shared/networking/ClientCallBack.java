package shared.networking;

import shared.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    void updateChat(Message message) throws RemoteException;
}
