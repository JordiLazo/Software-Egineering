package Question_1_Sockets_and_Strategy_Pattern.sockets.shared.util;

import java.beans.PropertyChangeListener;

public interface Subject {

    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);

}
