package rmi.uppercasereturn.server;

import rmi.uppercasereturn.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements UpperCaseServer {

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public String toUpperCase(String str) throws RemoteException {
        return str.toUpperCase();
    }
}
