package sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.core;

import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.views.log.LogViewModel;
import sockets.ToUpperCaseMVVMSockets.socketuppercaseversion.client.views.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private UppercaseViewModel uppercaseViewModel;
    private LogViewModel logViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UppercaseViewModel getUppercaseViewModel() {
        if (uppercaseViewModel == null)
            uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
        return uppercaseViewModel;
    }

    public LogViewModel getLogViewModel() {
        return (logViewModel = logViewModel == null ?
                new LogViewModel(mf.getTextConverter()) :
                logViewModel);
    }
}
