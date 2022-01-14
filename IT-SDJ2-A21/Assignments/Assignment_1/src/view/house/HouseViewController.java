package view.house;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import core.ViewHandler;

public class HouseViewController {

    @FXML
    private TextField temperatureLevelT1;
    @FXML
    private TextField temperatureLevelT2;
    @FXML
    private Label t1HighLabel;
    @FXML
    private Label t2HighLabel;
    @FXML
    private Label t1LowLabel;
    @FXML
    private Label t2LowLabel;

    private HouseViewModel houseViewModel;
    private ViewHandler viewHandler;

    public void init(HouseViewModel houseViewModel, ViewHandler viewHandler) {
        this.houseViewModel = houseViewModel;
        this.viewHandler = viewHandler;
        temperatureLevelT1.textProperty().bind(this.houseViewModel.getTemperatureLevelT1().asString());
        temperatureLevelT2.textProperty().bind(this.houseViewModel.getTemperatureLevelT2().asString());
        t1HighLabel.textProperty().bind(this.houseViewModel.getT1HighLabel());
        t1LowLabel.textProperty().bind(this.houseViewModel.getT1LowLabel());
        t2HighLabel.textProperty().bind(this.houseViewModel.getT2HighLabel());
        t2LowLabel.textProperty().bind(this.houseViewModel.getT2LowLabel());
    }

    public void switchToRadiatorLevel(ActionEvent actionEvent){
        viewHandler.openToRadiator();
    }
}
