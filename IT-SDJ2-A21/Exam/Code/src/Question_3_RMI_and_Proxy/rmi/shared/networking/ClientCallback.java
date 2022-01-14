package Question_3_RMI_and_Proxy.rmi.shared.networking;


import Question_3_RMI_and_Proxy.rmi.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote {
    void update(LogEntry log) throws RemoteException;
}
