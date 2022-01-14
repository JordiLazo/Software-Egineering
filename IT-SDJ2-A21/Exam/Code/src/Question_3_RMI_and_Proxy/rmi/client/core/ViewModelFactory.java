package Question_3_RMI_and_Proxy.rmi.client.core;

import Question_3_RMI_and_Proxy.rmi.client.views.log.LogViewModel;
import Question_3_RMI_and_Proxy.rmi.client.views.uppercase.UppercaseViewModel;

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
