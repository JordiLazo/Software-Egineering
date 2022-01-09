package rmi.addingmessages;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RmiClient {
    private RemoteMessageList serverStub;

    public RmiClient() {
        try {
            this.serverStub = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/AddMessage");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String text){
        try {
            serverStub.addMessage(text);
            System.out.println(serverStub.returnAllArrays());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    public void printList() throws RemoteException {
//        serverStub.print();
//    }


    public static void main(String[] args) throws RemoteException {
        RmiClient rmiClient = new RmiClient();
        Scanner input = new Scanner(System.in);
        System.out.println("Write a message for the list: ");
        boolean temp = true;
        while(temp) {
            String newMessage = input.nextLine();
            rmiClient.sendMessage(newMessage);
            System.out.println("Message \"" +newMessage+ "\" added to the list");
           // rmiClient.printList();
            if("end".equals(newMessage)){
                temp = false;
            }
        }
    }
}
