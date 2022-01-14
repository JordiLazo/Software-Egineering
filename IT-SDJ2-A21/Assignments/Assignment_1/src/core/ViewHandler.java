package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.house.HouseViewController;
import view.radiator.RadiatorViewController;

import java.io.IOException;

public class ViewHandler {
    private Scene radiatorScene;
    private Stage stage;
    private Scene houseScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start(){
        stage = new Stage();
        openToRadiator();
    }

    public void openToRadiator(){
        if(radiatorScene == null){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/radiator/RadiatorView.fxml"));
                Parent root = loader.load();
                RadiatorViewController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getRadiatorViewModel(),this);
                stage.setTitle("Radiator level");
                radiatorScene = new Scene(root);

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        stage.setScene(radiatorScene);
        stage.show();
    }

    public void openToHouse(){
        if(houseScene == null){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/house/HouseView.fxml"));
                Parent root = loader.load();
                HouseViewController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getHouseViewModel(),this);
                stage.setTitle("House Level");
                houseScene = new Scene(root);

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        stage.setScene(houseScene);
        stage.show();
    }
}
