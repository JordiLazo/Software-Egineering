package rmi.uppercasermi.server;

import rmi.uppercasermi.shared.Uppercase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Uppercase {

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public String toUpperCase(String str) throws RemoteException {
        return str.toUpperCase();
    }
}
