package rmi.uppercasebroadcast.server;

import rmi.uppercasebroadcast.shared.UpperCaseClient;
import rmi.uppercasebroadcast.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server implements UpperCaseServer {
    private List<UpperCaseClient> clientsForBroadcast;
    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.clientsForBroadcast = new ArrayList<>();
    }

    @Override
    public String toUpperCase(String str, UpperCaseClient client) throws RemoteException {
        String result = str.toUpperCase();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateClients(result,client);
        return result;
    }

    private void updateClients(String result, UpperCaseClient dontBroadCastToMe) {
        for(UpperCaseClient client: clientsForBroadcast){
            if(client.equals(dontBroadCastToMe)){
                continue;
            }
            try {
                client.update(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerClient(UpperCaseClient clientToRegister) {
        clientsForBroadcast.add(clientToRegister);
    }
}
