package core;

import view.house.HouseViewModel;
import view.radiator.RadiatorViewModel;

public class ViewModelFactory {
    private RadiatorViewModel rvm;
    private HouseViewModel hvm;
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory) {
      this.modelFactory=modelFactory;
    }

    public RadiatorViewModel getRadiatorViewModel(){
        if (rvm == null) {
            rvm = new RadiatorViewModel(modelFactory);
        }
        return rvm;
    }

    public HouseViewModel getHouseViewModel(){
        if (hvm == null) {
            hvm = new HouseViewModel(modelFactory);
        }
        return hvm;
    }
}
