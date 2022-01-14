package view.radiator;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RadiatorViewModel implements PropertyChangeListener {
    private StringProperty radiatorLevel;
    private StringProperty warningLabel;
    private ModelFactory modelFactory;

    public RadiatorViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        radiatorLevel = new SimpleStringProperty();
        warningLabel = new SimpleStringProperty();
        modelFactory.getRadiatorState().addPropertyChangeListener("Turn up pressed", this);
        modelFactory.getRadiatorState().addPropertyChangeListener("Turn down pressed", this);
        modelFactory.getRadiatorState().addPropertyChangeListener("Set power",this);
    }

    public StringProperty getRadiatorLevel(){
        return radiatorLevel;
    }

    public StringProperty getWarningLabel(){
        return warningLabel;
    }

    public void turnUpRadiator(){
        modelFactory.getRadiatorState().turnUp();
    }

    public void turnDownRadiator(){
        modelFactory.getRadiatorState().turnDown();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String power = String.valueOf( evt.getNewValue());
        Platform.runLater(()-> {radiatorLevel.set(power);
            if(radiatorLevel.get().equals("3")) {
                warningLabel.set("WARNING!!! Decreasing the radiator level...");
            }
            else {
                warningLabel.set("");
            }
        });
    }


}
