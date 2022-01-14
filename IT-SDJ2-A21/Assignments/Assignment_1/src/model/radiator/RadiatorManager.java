package model.radiator;


import model.utils.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorManager implements PropertyChangeSubject {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private RadiatorState currentState = new OffState();

    public void setPowerState(RadiatorState currentstate) {
        this.currentState = currentstate;
        support.firePropertyChange("Set power", null,getPower());
    }

    public void turnUp() {
        currentState.turnUp(this);
        support.firePropertyChange("Turn up pressed",null,getPower());
    }

    public void turnDown() {
        currentState.turnDown(this);
        support.firePropertyChange("Turn down pressed", null, getPower());
    }

    public int getPower() {
        return currentState.getPower();
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}