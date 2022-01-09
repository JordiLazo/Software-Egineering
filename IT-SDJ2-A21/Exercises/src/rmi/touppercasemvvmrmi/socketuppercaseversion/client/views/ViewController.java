package rmi.touppercasemvvmrmi.socketuppercaseversion.client.views;

import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewHandler;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);

}
