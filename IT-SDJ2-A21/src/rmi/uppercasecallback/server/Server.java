package rmi.uppercasecallback.server;

import rmi.uppercasecallback.shared.UpperCaseClient;
import rmi.uppercasecallback.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements UpperCaseServer {

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void toUpperCase(String str, UpperCaseClient client) throws RemoteException {
        String result = str.toUpperCase();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            client.uppercaseResult(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
