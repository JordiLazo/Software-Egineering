package upper_case_mvvm_two_views.model;

public interface TextConverter {
    String toUppercase(String text);
    void addLog(String log);
    void getLog();
}
