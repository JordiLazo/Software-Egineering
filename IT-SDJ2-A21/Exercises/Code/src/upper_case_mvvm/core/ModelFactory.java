package upper_case_mvvm.core;

import upper_case_mvvm.model.TextConverter;
import upper_case_mvvm.model.TextConverterModel;

public class ModelFactory {

    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if(textConverter == null){
            textConverter = new TextConverterModel();
        }
        return textConverter;
    }
}
