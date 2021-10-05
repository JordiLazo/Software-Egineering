package sockets.ToUpperCaseMVVMSockets.localuppercaseversion;

import javafx.application.Application;
import javafx.stage.Stage;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core.ModelFactory;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core.ViewHandler;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
