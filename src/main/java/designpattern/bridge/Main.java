package designpattern.bridge;

public class Main {
    /** "Implementor" */
    interface ColorAPI {
        void color();

        // we put resizeByPercentage(..) in "Abstraction" instead of here,
        // to simplify it
    }

    static class ColorAPI1 implements ColorAPI {
        public void color() {
            System.out.println("Red");
        }
    }

    static class ColorAPI2 implements ColorAPI {
        public void color() {
            System.out.println("Blue");
        }
    }

    /** "Abstraction" */
    abstract static class Shape {

        /** Conceptually correct Shape HAS A Color, so it's right not to inherit it */
        protected ColorAPI colorAPI;

        protected Shape(ColorAPI colorAPI) {
            this.colorAPI = colorAPI;
        }

        public abstract void draw();

        public abstract void resizeByPercentage(double pct);

        public abstract double getRadius();
    }

    static class CircleShape extends Shape {
        private double radius;

        public CircleShape(double radius, ColorAPI colorAPI) {
            super(colorAPI);
            this.radius = radius;
        }

        // low-level i.e. Implementation specific
        public void draw() {
            colorAPI.color();
        }

        // high-level i.e. Abstraction specific
        public void resizeByPercentage(double pct) {
            radius *= pct;
        }

        public double getRadius() {
            return radius;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes =
                new Shape[] {
                    // we inject `ColorAPI1` and `ColorAPI2` instead of extend them
                    new CircleShape(3, new ColorAPI1()), new CircleShape(11, new ColorAPI2()),
                };

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
            System.out.println("shape.getRadius() = " + shape.getRadius());
        }
    }
}
