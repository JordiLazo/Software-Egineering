package rmi.touppercasemvvmrmi.socketuppercaseversion.client.network;

import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking.ClientCallBack;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking.RMIServer;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClientImpl implements Client, ClientCallBack {
    private RMIServer server;
    private PropertyChangeSupport support;

    public RMIClientImpl() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public String toUppercase(String str) {
        try {
            return server.toUppercase(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt contact");
        }
    }

    @Override
    public List<LogEntry> getLog() {
        try {
            return server.getLogs();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt contact");
        }
    }

    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this,0);
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            this.server =(RMIServer) registry.lookup("UppercaseServer");
            server.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LogEntry log) throws RemoteException {
        support.firePropertyChange("NewLogEntry",null,log);
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
