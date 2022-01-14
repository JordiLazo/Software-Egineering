package Question_2_MVVM_and_Observer_Pattern.mvvm.model;

public class TextConverterModel implements TextConverter{
    @Override
    public String toUppercase(String text) {
        return text.toUpperCase();
    }
}
