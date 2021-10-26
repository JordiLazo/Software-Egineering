package rmi.textconverter.client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws RemoteException {

        RmiCaseClient client = new RmiCaseClient();
        Scanner inputFromUser = new Scanner(System.in);
        System.out.println("Write some text:");
        String userText = inputFromUser.nextLine();

        String convertedLine = client.convert(userText,true);
        System.out.println("Result is: " + convertedLine);

        System.out.println("Capitalise first letter:");
        userText = inputFromUser.nextLine();

        convertedLine = client.convert(userText,false);
        System.out.println("Result is: " + convertedLine);
    }
}
