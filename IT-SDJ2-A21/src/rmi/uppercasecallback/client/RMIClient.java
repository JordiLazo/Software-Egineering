package rmi.uppercasecallback.client;

import rmi.uppercasecallback.shared.UpperCaseClient;
import rmi.uppercasecallback.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UpperCaseClient {
    private UpperCaseServer server;

    public RMIClient() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    public void startClient() throws NotBoundException, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (UpperCaseServer) registry.lookup("Server");
    }

    public void toUpperCase(String text) throws RemoteException {
        try {
            server.toUpperCase(text,this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uppercaseResult(String result) throws RemoteException {
        System.out.println("Result >" + result);
    }
}
