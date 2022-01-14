package model.temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureManager implements TemperatureModel {
    private PropertyChangeSupport support;
    public TemperatureManager() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void addTemperatureT1(double temperatureT1) {
        support.firePropertyChange("Add temperature t1", null, temperatureT1);
    }

    @Override
    public void addTemperatureT2(double temperatureT2) {
        support.firePropertyChange("Add temperature t2",null, temperatureT2);
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}
