package Question_2_MVVM_and_Observer_Pattern.mvvm;

import Question_2_MVVM_and_Observer_Pattern.mvvm.core.ModelFactory;
import Question_2_MVVM_and_Observer_Pattern.mvvm.core.ViewHandler;
import Question_2_MVVM_and_Observer_Pattern.mvvm.core.ViewModelFactory;
import javafx.stage.Stage;

public class UppercaseApp extends javafx.application.Application{

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(vmf);
        viewHandler.start();
    }
}
