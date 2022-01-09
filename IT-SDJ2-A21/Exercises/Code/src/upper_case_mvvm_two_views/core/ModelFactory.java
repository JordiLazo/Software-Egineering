package upper_case_mvvm_two_views.core;

import upper_case_mvvm_two_views.model.TextConverter;
import upper_case_mvvm_two_views.model.TextConverterModel;

public class ModelFactory {

    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if(textConverter == null){
            textConverter = new TextConverterModel();
        }
        return textConverter;
    }
}
