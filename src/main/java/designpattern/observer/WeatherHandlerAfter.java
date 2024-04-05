package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherHandlerAfter {

    public static class WeatherStation extends Observable {
        private float temperature;

        public void setTemperature(float temperature) {
            this.temperature = temperature;
            setChanged();
            notifyObservers(temperature);
        }
    }

    public static class CurrentConditionsDisplay implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof WeatherStation) {
                float temperature = (float) arg;
                System.out.println("Current conditions: " + temperature + " F");
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            WeatherStation weatherStation = new WeatherStation();
            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

            // Add observer to the weather station
            weatherStation.addObserver(currentDisplay);

            // Simulate temperature change
            weatherStation.setTemperature(72.5f);
        }
    }


}
