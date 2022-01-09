package rmi.upperandlower.client;

import rmi.upperandlower.shared.LowerCaseServer;
import rmi.upperandlower.shared.Server;
import rmi.upperandlower.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient {
    private Server server;
    private UpperCaseServer upperCaseServer;
    private LowerCaseServer lowerCaseServer;

    public RMIClient() throws RemoteException {
    }

    public void startClient() throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        this.server = (Server) registry.lookup("Server");
        this.upperCaseServer = server.getUpperCaseServer();
        this.lowerCaseServer = server.getLowerCaseServer();
    }

    public String toUpperCase(String text) {
        try {
            return upperCaseServer.toUpperCase(text);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt");
        }
    }

    public String toLowerCase(String text) {
        try {
            return lowerCaseServer.toLowerCase(text);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt");
        }
    }

}
