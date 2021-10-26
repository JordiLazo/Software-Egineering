package rmi.textconverter.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp {
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        startRegistry();
        RmiCaseServer server = new RmiCaseServer();
        server.start();
        System.out.println("Server started...");
    }

    public static void startRegistry(){
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started...");
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Registry is already started" + e.getMessage());
        }
    }
}
