package Question_2_MVVM_and_Observer_Pattern.mvvm.core;

import Question_2_MVVM_and_Observer_Pattern.mvvm.model.TextConverter;
import Question_2_MVVM_and_Observer_Pattern.mvvm.model.TextConverterModel;

public class ModelFactory {

    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if(textConverter == null){
            textConverter = new TextConverterModel();
        }
        return textConverter;
    }
}
