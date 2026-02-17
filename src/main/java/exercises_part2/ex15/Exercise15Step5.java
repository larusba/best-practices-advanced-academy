package exercises_part2.ex15;
import java.util.ArrayList;
import java.util.List;

public class Exercise15Step5 {
    public interface Observer { void update(double price); }

    public static class StockMarket {
        private List<Observer> observers = new ArrayList<>();
        private double oldPrice = 0.0;

        public void attach(Observer o) { observers.add(o); }

        public void setPrice(double price) {
            double change = Math.abs(price - oldPrice);
            double percentage = (oldPrice == 0) ? 100 : (change / oldPrice) * 100;

            if (percentage >= 5.0) {
                for (Observer o : observers) o.update(price);
            }
            oldPrice = price;
        }
    }
}