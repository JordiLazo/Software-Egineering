package sockets.ToUpperCaseMVVMSockets.localuppercaseversion.core;

import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.model.TextConverter;
import sockets.ToUpperCaseMVVMSockets.localuppercaseversion.model.TextConverterManager;

public class ModelFactory {

    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager();
        return textConverter;
    }
}


