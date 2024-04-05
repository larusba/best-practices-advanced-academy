package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherHandler {

    public static class WeatherStation {
        private List<WeatherDisplay> displays = new ArrayList<>();
        private float temperature;

        public void addDisplay(WeatherDisplay display) {
            displays.add(display);
        }

        public void removeDisplay(WeatherDisplay display) {
            displays.remove(display);
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
            notifyDisplays();
        }

        private void notifyDisplays() {
            for (WeatherDisplay display : displays) {
                display.update(temperature);
            }
        }
    }

    public interface WeatherDisplay {
        void update(float temperature);
    }

    public static class CurrentConditionsDisplay implements WeatherDisplay {
        @Override
        public void update(float temperature) {
            System.out.println("Current conditions: " + temperature + " F");
        }
    }

    public class Main {
        public static void main(String[] args) {
            WeatherStation weatherStation = new WeatherStation();
            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

            // Add display to the weather station
            weatherStation.addDisplay(currentDisplay);

            // Simulate temperature change
            weatherStation.setTemperature(72.5f);
        }
    }


}
