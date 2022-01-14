package external;

import core.ModelFactory;

public class ThermometerT1 extends Thread {
    private ModelFactory modelFactory;
    private static double lastTemperatureT1 = 22;
    private static double lastTemperatureOutdoor = 10;
    private static int distance = 1;
    private static int secondsLastMeasurement = 6;

    public ThermometerT1(ModelFactory modelFactory){
        this.modelFactory = modelFactory;
    }

    public double temperatureT1(double lastMeasuredTemperature, int heaterPower, int distance, double outdoorTemperature, int secondsLastMeasurement) {
        double tMax = Math.min(11 * heaterPower + 10, 11 * heaterPower + 10 + outdoorTemperature);
        tMax = Math.max(Math.max(lastMeasuredTemperature, tMax), outdoorTemperature);
        double heaterTerm = 0;
        if (heaterPower > 0) {
            double den = Math.max((tMax * (20 - 5 * heaterPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * secondsLastMeasurement * Math.abs(tMax - lastMeasuredTemperature) / den;
        }
        double outdoorTerm = (lastMeasuredTemperature - outdoorTemperature) * secondsLastMeasurement / 250.0;
        lastMeasuredTemperature = Math.min(Math.max(lastMeasuredTemperature - outdoorTerm + heaterTerm, outdoorTemperature), tMax);
        return lastMeasuredTemperature;
    }

    public double getLastTemperatureT1() {
        return lastTemperatureT1;
    }

    public void run(){
        while(true){
            lastTemperatureT1 = temperatureT1(lastTemperatureT1,modelFactory.getRadiatorState().getPower(),distance,lastTemperatureOutdoor, secondsLastMeasurement);
            modelFactory.getTemperature().addTemperatureT1(lastTemperatureT1);
            System.out.println("T1: " + getLastTemperatureT1());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
