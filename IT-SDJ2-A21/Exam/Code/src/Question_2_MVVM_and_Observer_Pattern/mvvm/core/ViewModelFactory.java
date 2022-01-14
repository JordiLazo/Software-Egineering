package Question_2_MVVM_and_Observer_Pattern.mvvm.core;

import Question_2_MVVM_and_Observer_Pattern.mvvm.view.uppercase.UppercaseViewModel;

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
