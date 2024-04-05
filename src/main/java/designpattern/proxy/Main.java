package designpattern.proxy;

public class Main {
    interface Image {
        public void displayImage();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }

        private void loadImageFromDisk() {
            /*
             * Potentially can be an expensive operation,
             * e.g. via a RestAPI...
             */
            System.out.println("Loading..." + filename);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void displayImage() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private final String filename;
        private RealImage image;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        /**
         * Lazy - initialization
         *
         * <p>Delegates to RealImage.loadImageFromDisk() the expensive part
         */
        public void displayImage() {
            // load only on demand
            if (image == null) {
                image = new RealImage(filename);
            }
            // in any case, display the image
            image.displayImage();
        }
    }

    static class ProxyExample {
        public static void main(String[] args) {
            Image image1 = new ProxyImage("HiRes_10MB_Photo1");
            Image image2 = new ProxyImage("HiRes_10MB_Photo2");
            Image image3 = new ProxyImage("HiRes_10MB_Photo3");

            image1.displayImage(); // loading necessary
            image2.displayImage(); // loading necessary
            image1.displayImage(); // no loading necessary; already done
            image2.displayImage(); // no loading necessary; already done
            image3.displayImage(); // loading necessary
        }
    }
}
