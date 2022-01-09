package upper_case_mvvm.core;

import upper_case_mvvm.view.uppercase.UppercaseViewModel;

public class ViewModelFactory {
    private UppercaseViewModel uppercaseVM;
    private final ModelFactory mf;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UppercaseViewModel getUppercaseVM(){
        if(uppercaseVM == null){
            uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
        }
        return uppercaseVM;
    }
}
