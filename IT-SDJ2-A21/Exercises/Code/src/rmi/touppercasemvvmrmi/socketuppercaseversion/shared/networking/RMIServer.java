package rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {
    String toUppercase(String text) throws RemoteException;
    List<LogEntry> getLogs() throws RemoteException;
    void registerClient(ClientCallBack client) throws RemoteException;
}
