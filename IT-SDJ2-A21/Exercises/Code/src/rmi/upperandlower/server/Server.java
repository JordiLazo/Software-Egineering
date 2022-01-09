package rmi.upperandlower.server;

import rmi.upperandlower.server.lowercase.LowerCaseServerImpl;
import rmi.upperandlower.server.uppercase.UpperCaseServerImpl;
import rmi.upperandlower.shared.LowerCaseServer;
import rmi.upperandlower.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements rmi.upperandlower.shared.Server {

    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public UpperCaseServer getUpperCaseServer() throws RemoteException {
        return new UpperCaseServerImpl();
    }

    @Override
    public LowerCaseServer getLowerCaseServer() throws RemoteException {
        return new LowerCaseServerImpl();
    }
}
