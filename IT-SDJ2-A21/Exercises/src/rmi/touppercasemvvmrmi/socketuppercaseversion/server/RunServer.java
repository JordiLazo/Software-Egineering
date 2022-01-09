package rmi.touppercasemvvmrmi.socketuppercaseversion.server;

import rmi.touppercasemvvmrmi.socketuppercaseversion.server.model.TextManagerImpl;
import rmi.touppercasemvvmrmi.socketuppercaseversion.server.network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMIServerImpl ss = new RMIServerImpl(new TextManagerImpl());
        ss.startServer();
    }
}
