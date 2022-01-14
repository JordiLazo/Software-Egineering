package external;

import core.ModelFactory;

public class ThermometerT2 extends Thread{
    private ModelFactory modelFactory;
    private static double lastTemperatureT2 = 22;
    private static double lowerLimit = 10;
    private static double upperLimit = 30;

    public ThermometerT2(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public double temperatureT2(double lastTemperatureOutdoor, double lowerLimit, double upperLimit) {
        double left = lastTemperatureOutdoor - lowerLimit;
        double right = upperLimit - lastTemperatureOutdoor;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        lastTemperatureOutdoor += sign * Math.random();
        return lastTemperatureOutdoor;
    }

    public double getLastTemperatureT2() {
        return lastTemperatureT2;
    }

    public void run(){
        while(true){
            lastTemperatureT2 = temperatureT2(lastTemperatureT2,lowerLimit,upperLimit);
            modelFactory.getTemperature().addTemperatureT2(lastTemperatureT2);
            System.out.println("T2: " + getLastTemperatureT2());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
