package model.utils;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
}
