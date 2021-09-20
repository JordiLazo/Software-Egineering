package observer_pattern.temperature;

import javafx.application.Application;
import javafx.stage.Stage;
import observer_pattern.temperature.external.Thermomether;
import observer_pattern.temperature.mediator.TemperatureModel;
import observer_pattern.temperature.mediator.TemperatureModelManager;
import observer_pattern.temperature.view.ViewHandler;


public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);

    Thermomether t1 = new Thermomether("1", 15,1, model );
    Thermomether t2 = new Thermomether("2", 15,2, model );

    Thread c1 = new Thread(t1);
    Thread c2 = new Thread(t2);
    c1.setDaemon(true);
    c2.setDaemon(true);


    c1.start();
    c2.start();

  }
}
