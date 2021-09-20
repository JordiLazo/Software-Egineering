package upper_case_mvvm_two_views.core;

import upper_case_mvvm_two_views.log.LogViewModel;
import upper_case_mvvm_two_views.model.TextConverterModel;
import upper_case_mvvm_two_views.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private UppercaseViewModel uppercaseVM;
    private final ModelFactory mf;
    private LogViewModel logVm;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;

    }

    public UppercaseViewModel getUppercaseVM(){
        if(uppercaseVM == null){
            uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
        }
        return uppercaseVM;
    }

    public LogViewModel getLogViewModel(){
        return logVm;
    }
}
