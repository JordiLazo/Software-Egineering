package new_theme;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class TrafficLight {

    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;

    public TrafficLight() {
        currentLight = lights[count];
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            count = (++count) % 4;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);
        }

    }
}
