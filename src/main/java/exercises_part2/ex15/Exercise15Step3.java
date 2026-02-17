package exercises_part2.ex15;
import java.util.ArrayList;
import java.util.List;

public class Exercise15Step3 {
    public interface Observer { void update(double price); }

    public static class StockMarket {
        private List<Observer> observers = new ArrayList<>();

        public void attach(Observer o) { observers.add(o); }

        public void setPrice(double price) {
            for (Observer o : observers) {
                o.update(price);
            }
        }
    }
}