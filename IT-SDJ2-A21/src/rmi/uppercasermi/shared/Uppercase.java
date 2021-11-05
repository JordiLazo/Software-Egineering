package rmi.uppercasermi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Uppercase extends Remote {
    String toUpperCase(String str) throws RemoteException;
}
