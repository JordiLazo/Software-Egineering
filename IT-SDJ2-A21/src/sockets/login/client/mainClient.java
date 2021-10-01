package sockets.login.client;

import sockets.login.client.mediator.UserClient;

import java.io.IOException;
import java.util.Scanner;

public class mainClient {
    public static void main(String[] args) throws IOException {
        UserClient c1 = new UserClient("localhost",1099);
        Scanner inputName = new Scanner(System.in);

        while (true){
            System.out.println("Introduce user: ");
            String userName = inputName.nextLine();
            System.out.println("Introduce password");
            String userPassword = inputName.nextLine();
            try{
                c1.login(userName,userPassword);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }
        }
    }
}
