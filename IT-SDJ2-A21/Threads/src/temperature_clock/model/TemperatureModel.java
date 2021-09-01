package temperature_clock.model;

public interface TemperatureModel
{
  public double toCelsius(double fahrenheit);
  public double toFahrenheit(double celcius);
}
