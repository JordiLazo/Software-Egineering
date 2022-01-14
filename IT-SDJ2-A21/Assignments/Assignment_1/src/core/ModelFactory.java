package core;

import model.radiator.RadiatorManager;
import model.temperature.TemperatureManager;
import model.temperature.TemperatureModel;

public class ModelFactory {

    private RadiatorManager radiatorModel;
    private TemperatureModel temperatureModel;

    public RadiatorManager getRadiatorState() {
        if(radiatorModel == null){
            radiatorModel = new RadiatorManager();
        }
        return radiatorModel;
    }

    public TemperatureModel getTemperature(){
        if(temperatureModel == null){
            temperatureModel = new TemperatureManager();
        }
        return temperatureModel;
    }
}
