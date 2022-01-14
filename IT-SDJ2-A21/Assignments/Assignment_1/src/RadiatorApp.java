import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import external.ThermometerT1;
import external.ThermometerT2;
import javafx.stage.Stage;

public class RadiatorApp extends javafx.application.Application{
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, vmf);
        ThermometerT1 t1 = new ThermometerT1(mf);
        ThermometerT2 t2 = new ThermometerT2(mf);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();


        viewHandler.start();
    }
}
