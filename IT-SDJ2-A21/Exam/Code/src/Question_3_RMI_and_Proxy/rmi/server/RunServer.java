package Question_3_RMI_and_Proxy.rmi.server;

import Question_3_RMI_and_Proxy.rmi.server.model.TextManagerImpl;
import Question_3_RMI_and_Proxy.rmi.server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMIServerImpl ss = new RMIServerImpl(new TextManagerImpl());
        ss.startServer();
    }
}
