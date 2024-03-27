public class Main {
    public static void main(String[] args) {}

    public class CircleWithSmell {
        public static void main(String[] args) {
            double radius = 5.0;

            double area = calculateArea(radius);
            System.out.println("Area of the circle: " + area);

            double circumference = calculateCircumference(radius);
            System.out.println("Circumference of the circle: " + circumference);
        }

        public static double calculateArea(double radius) {
            return 3.14 * radius * radius; // Magic number 3.14
        }

        public static double calculateCircumference(double radius) {
            return 2 * 3.14 * radius; // Magic number 3.14
        }
    }

    /**
     * In the solved code, we introduced a constant PI and replaced the magic number 3.14 with this
     * constant in the calculateArea and calculateCircumference methods. This makes the code more
     * readable and maintainable because the purpose of the number is clear, and if the value of PI
     * needs to be changed, it only needs to be updated in one place.
     *
     * <p>This is a simple example, but in larger and more complex codebases, identifying and
     * addressing code smells like magic numbers can significantly improve code quality and
     * maintainability. Always strive to use named constants instead of magic numbers to make your
     * code more self-explanatory.
     */
    public class Circle {
        private static final double PI = 3.14;

        public static void main(String[] args) {
            double radius = 5.0;

            double area = calculateArea(radius);
            System.out.println("Area of the circle: " + area);

            double circumference = calculateCircumference(radius);
            System.out.println("Circumference of the circle: " + circumference);
        }

        public static double calculateArea(double radius) {
            return PI * radius * radius; // Use constant PI instead of magic number
        }

        public static double calculateCircumference(double radius) {
            return 2 * PI * radius; // Use constant PI instead of magic number
        }
    }
}
