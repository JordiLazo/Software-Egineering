package rmi.addingmessages;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteMessageList extends Remote {
    void addMessage (String message) throws RemoteException, InterruptedException;
    void print() throws RemoteException;
    ArrayList<String> returnAllArrays() throws RemoteException;

}
