package model.temperature;

import model.utils.PropertyChangeSubject;

public interface TemperatureModel extends PropertyChangeSubject {
    void addTemperatureT1(double temperatureT1);
    void addTemperatureT2(double temperatureT2);

}
