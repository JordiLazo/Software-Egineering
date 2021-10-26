package rmi.textconverter.client;

import rmi.textconverter.server.TextConverter;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiCaseClient {
    private TextConverter serverStub;

    public RmiCaseClient(){
        try{
            this.serverStub = (TextConverter) Naming.lookup("rmi://localhost:1099/Case");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String convert(String text, boolean upper) throws RemoteException {
        if(upper){
            return serverStub.toUppercase(text);
        }
        return serverStub.capitalizeFirstCharacter(text);
    }
}
