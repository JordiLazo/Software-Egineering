package model.radiator;

public class Power2State implements RadiatorState {

    private static final int POWER = 2;

    @Override
    public void turnUp(RadiatorManager radiatorManager) {
        radiatorManager.setPowerState(new Power3State(radiatorManager));
    }

    @Override
    public void turnDown(RadiatorManager radiatorManager) {
        radiatorManager.setPowerState(new Power1State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
