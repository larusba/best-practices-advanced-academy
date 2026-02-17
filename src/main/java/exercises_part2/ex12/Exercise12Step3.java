package exercises_part2.ex12;

public class Exercise12Step3 {
    public interface Image { void display(); }

    public static class RealImage implements Image {
        public RealImage() { System.out.println("Loading from disk..."); }
        public void display() { System.out.println("Showing image"); }
    }

    public static class ImageProxy implements Image {
        private RealImage realImage;

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(); // Lazy Loading
            }
            realImage.display();
        }
    }
}