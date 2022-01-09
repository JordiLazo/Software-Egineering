package upper_case_mvvm_two_views.model;

import java.util.ArrayList;

public class TextConverterModel implements TextConverter {

    private ArrayList<String> list;

    @Override
    public String toUppercase(String text) {
        addList(text);
        return text.toUpperCase();
    }

    @Override
    public void addLog(String log) {

    }

    @Override
    public void getLog() {

    }

    public void addList(String lists){
        list.add(lists);
    }

}
