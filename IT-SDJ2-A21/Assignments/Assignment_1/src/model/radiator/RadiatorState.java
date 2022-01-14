package model.radiator;

public interface RadiatorState {
    void turnUp (RadiatorManager radiatorManager);
    void turnDown (RadiatorManager radiatorManager);
    int getPower();
}
