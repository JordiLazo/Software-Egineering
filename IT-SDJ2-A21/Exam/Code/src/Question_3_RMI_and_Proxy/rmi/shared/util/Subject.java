package Question_3_RMI_and_Proxy.rmi.shared.util;

import java.beans.PropertyChangeListener;

public interface Subject {

    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);

}
