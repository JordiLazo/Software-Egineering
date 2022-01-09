package observer_pattern.temperature.mediator;

import observer_pattern.temperature.model.Temperature;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
