package rmi.touppercasemvvmrmi.socketuppercaseversion.server.network;

import rmi.touppercasemvvmrmi.socketuppercaseversion.server.model.TextManager;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking.ClientCallBack;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.networking.RMIServer;
import rmi.touppercasemvvmrmi.socketuppercaseversion.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer {
    private TextManager textManager;

    public RMIServerImpl(TextManager textManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.textManager = textManager;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("UppercaseServer",this);
    }

    @Override
    public String toUppercase(String text) throws RemoteException {
        return textManager.toUppercase(text);
    }

    @Override
    public List<LogEntry> getLogs() {
        return textManager.getlog();
    }

    @Override
    public void registerClient(ClientCallBack client) {
        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener = listener;
        listener = evt -> {
            try {
                client.update((LogEntry)evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        };
        textManager.addListener("NewLogEntry", listener);
    }
}
