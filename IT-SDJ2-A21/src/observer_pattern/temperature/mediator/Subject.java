package observer_pattern.temperature.mediator;

public interface Subject extends Listener
{
  void addListener(Listener lstnr);
  void removeListener(Listener lstnr);

}
