package rmi.addingmessages;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiServer implements RemoteMessageList{
    private ArrayList<String> listOfMessages = new ArrayList<>();

    public void start() throws MalformedURLException, RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        Naming.rebind("AddMessage",this);
        System.out.println("Server started...");
        Thread t1 = new Thread();
        t1.start();
        while(true){
            try{
                Thread.sleep(5000);
                print();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void startRegistry(){
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started correctly");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addMessage(String message) throws RemoteException {
        listOfMessages.add(message);
    }

    @Override
    public void print() {
        for(int i = 0; i <listOfMessages.size();i++){
            System.out.println(listOfMessages.get(i));
        }
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        RmiServer rmiServer = new RmiServer();
        rmiServer.startRegistry();
        rmiServer.start();
    }
}
