package view.radiator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import core.ViewHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class RadiatorViewController implements Initializable {
    @FXML
    private Label warningLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField radiatorLevel;

    private RadiatorViewModel radiatorViewModel;
    private ViewHandler viewHandler;

    public void init(RadiatorViewModel radiatorViewModel, ViewHandler viewHandler){
        this.radiatorViewModel = radiatorViewModel;
        this.viewHandler=viewHandler;
        radiatorLevel.textProperty().bind(radiatorViewModel.getRadiatorLevel());
        warningLabel.textProperty().bind(radiatorViewModel.getWarningLabel());
    }

    @FXML
    public void onTurnUpButton(ActionEvent actionEvent){
        radiatorViewModel.turnUpRadiator();
    }

    @FXML
    public void onTurnDownButton(ActionEvent actionEvent) {
        radiatorViewModel.turnDownRadiator();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/media/radiator.png"));
        imageView.setImage(image);
    }

   @FXML
   private void switchToHouse(ActionEvent actionEvent){
        viewHandler.openToHouse();
    }
}
