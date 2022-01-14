package view.house;

import core.ModelFactory;
import external.ThermometerT1;
import external.ThermometerT2;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.beans.PropertyChangeEvent;

public class HouseViewModel {
    private DoubleProperty temperatureLevelT1;
    private DoubleProperty temperatureLevelT2;
    private StringProperty t1HighLabel;
    private StringProperty t2HighLabel;
    private StringProperty t1LowLabel;
    private StringProperty t2LowLabel;
    private ModelFactory modelFactory;
    private static final double LOW = 21;
    private static final double HIGH = 22;

    public HouseViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        temperatureLevelT1 = new SimpleDoubleProperty();
        temperatureLevelT2 = new SimpleDoubleProperty();
        t1HighLabel = new SimpleStringProperty();
        t2HighLabel = new SimpleStringProperty();
        t1LowLabel = new SimpleStringProperty();
        t2LowLabel = new SimpleStringProperty();
        modelFactory.getTemperature().addPropertyChangeListener("Add temperature t1",this::propertyT1);
        modelFactory.getTemperature().addPropertyChangeListener("Add temperature t2",this::propertyT2);
    }

    public DoubleProperty getTemperatureLevelT1(){
        return temperatureLevelT1;
    }

    public DoubleProperty getTemperatureLevelT2(){
        return temperatureLevelT2;
    }

    public StringProperty getT1HighLabel(){
        return t1HighLabel;
    }

    public StringProperty getT2HighLabel(){
        return t2HighLabel;
    }

    public StringProperty getT1LowLabel(){
        return t1LowLabel;
    }

    public StringProperty getT2LowLabel(){
        return t2LowLabel;
    }

    public void propertyT1(PropertyChangeEvent evt) {
        ThermometerT1 t1 = new ThermometerT1(modelFactory);
        Platform.runLater(()->
        {temperatureLevelT1.set(t1.getLastTemperatureT1());
            if(t1.getLastTemperatureT1() > HIGH){
                t1HighLabel.set("T1 is too HIGH");
                t1LowLabel.set("");
            }else if(t1.getLastTemperatureT1() < LOW){
                t1LowLabel.set("T1 is too LOW");
                t1HighLabel.set("");
            }else if(t1.getLastTemperatureT1() < HIGH && t1.getLastTemperatureT1() > LOW ){
                t1HighLabel.set("");
                t1LowLabel.set("");
            }
        });
    }

    public void propertyT2(PropertyChangeEvent evt) {
        ThermometerT2 t2 = new ThermometerT2(modelFactory);
        Platform.runLater(()-> {
            temperatureLevelT2.set(t2.getLastTemperatureT2());
            if(t2.getLastTemperatureT2() > HIGH){
                t2HighLabel.set("T2 is too HIGH");
                t2LowLabel.set("");
            }else if(t2.getLastTemperatureT2() < LOW){
                t2LowLabel.set("T2 is too LOW");
                t2HighLabel.set("");
            }else if(t2.getLastTemperatureT2() < HIGH && t2.getLastTemperatureT2() > LOW ){
                t2HighLabel.set("");
                t2LowLabel.set("");
            }
        });
    }
}
