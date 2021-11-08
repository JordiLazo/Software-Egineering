package rmi.uppercasereturn.client;

import rmi.uppercasereturn.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    private UpperCaseServer server;
    public RMIClient() {
    }

    public void startClient() throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (UpperCaseServer) registry.lookup("Server");
    }

    public String toUpperCase(String text) throws RemoteException {
        String result = null;
        try {
            result = server.toUpperCase(text);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }
}
