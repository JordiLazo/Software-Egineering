package rmi.touppercasemvvmrmi.socketuppercaseversion.client;

import javafx.application.Application;
import javafx.stage.Stage;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ClientFactory;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ModelFactory;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewHandler;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewModelFactory;

public class UppercaseApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
