package upper_case_mvvm_two_views;

import javafx.stage.Stage;
import upper_case_mvvm_two_views.core.ModelFactory;
import upper_case_mvvm_two_views.core.ViewHandler;
import upper_case_mvvm_two_views.core.ViewModelFactory;

public class UppercaseApp extends javafx.application.Application{

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(vmf);
        viewHandler.start();
    }
}
