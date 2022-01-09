package model_view_view_model;

import javafx.application.Application;
import javafx.stage.Stage;
import model_view_view_model.model.ModelFactory;

public class PieChartApp extends Application {

    public static void main(String[] args) {
        Application.launch(PieChartApp.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
    }
}
