package rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    void update(LogEntry log) throws RemoteException;
}
