package rmi.touppercasemvvmrmi.socketuppercaseversion.client.core;

import rmi.touppercasemvvmrmi.socketuppercaseversion.client.model.TextConverter;
import rmi.touppercasemvvmrmi.socketuppercaseversion.client.model.TextConverterManager;

public class ModelFactory {

    private TextConverter textConverter;
    private final ClientFactory cf;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(cf.getClient());
        return textConverter;
    }
}


