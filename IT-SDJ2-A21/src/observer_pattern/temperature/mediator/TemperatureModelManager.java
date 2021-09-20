package observer_pattern.temperature.mediator;

import observer_pattern.temperature.mediator.Listener;
import observer_pattern.temperature.mediator.TemperatureModel;
import observer_pattern.temperature.model.Temperature;
import observer_pattern.temperature.model.TemperatureList;

import java.util.ArrayList;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private ArrayList<Listener> listeners = new ArrayList<>();

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  // and maybe other methods...
}
