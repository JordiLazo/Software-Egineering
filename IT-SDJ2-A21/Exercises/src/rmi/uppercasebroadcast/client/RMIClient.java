package rmi.uppercasebroadcast.client;

import rmi.uppercasebroadcast.shared.UpperCaseClient;
import rmi.uppercasebroadcast.shared.UpperCaseServer;

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
        server.registerClient(this);
    }

    public String toUpperCase(String text){
        try {
            String result = server.toUpperCase(text,this);
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldnt");
        }
    }

    @Override
    public void update(String result) throws RemoteException {
        System.out.println("Result >" + result);
    }
}
