package temperature_clock;

import javafx.application.Application;
import javafx.stage.Stage;
import temperature_clock.model.TemperatureModel;
import temperature_clock.model.TemperatureModelManager;
import temperature_clock.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);

  }
}
