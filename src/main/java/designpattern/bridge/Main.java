package designpattern.bridge;

/**
 * Esempio del Design Pattern Bridge.
 *
 * Scopo: Separare l'astrazione (la Forma) dalla sua implementazione (il Colore/Rendering)
 * in modo che le due possano variare indipendentemente.
 *
 * PROBLEMA (Senza Bridge):
 * - Se usassimo l'ereditarietà classica, per aggiungere una nuova forma o un nuovo colore,
 * dovremmo creare una combinazione moltiplicativa di classi (es. RedCircle, BlueCircle, RedSquare...).
 *
 * SOLUZIONE:
 * - Creiamo due gerarchie separate: una per Shape (Astrazione) e una per ColorAPI (Implementazione).
 * - Le colleghiamo tramite composizione (il "Ponte"): Shape possiede un riferimento a ColorAPI.
 */
public class Main {
    /**
     * COMPONENT: Implementor.
     * Definisce l'interfaccia per le classi di implementazione (il "come" viene fatto qualcosa).
     * Non deve corrispondere esattamente all'interfaccia dell'Astrazione.
     */
    interface ColorAPI {
        void color();

        // we put resizeByPercentage(..) in "Abstraction" instead of here,
        // to simplify it
    }

    /** Concrete Implementor A */
    static class ColorAPI1 implements ColorAPI {
        public void color() {
            System.out.println("Red");
        }
    }

    /** Concrete Implementor B */
    static class ColorAPI2 implements ColorAPI {
        public void color() {
            System.out.println("Blue");
        }
    }

    /**
     * COMPONENT: Abstraction.
     * Definisce l'interfaccia di alto livello (la Forma).
     * Mantiene un riferimento a un oggetto di tipo Implementor (il ponte).
     */
    abstract static class Shape {

        /**
         * IL BRIDGE (Ponte).
         * Usiamo la Composizione ("Has-A") invece dell'ereditarietà.
         * La forma delega al ColorAPI le operazioni specifiche di rendering del colore.
         */
        protected ColorAPI colorAPI;

        protected Shape(ColorAPI colorAPI) {
            this.colorAPI = colorAPI;
        }

        public abstract void draw();

        public abstract void resizeByPercentage(double pct);

        public abstract double getRadius();
    }

    /**
     * COMPONENT: Refined Abstraction.
     * Estende l'interfaccia definita dall'Astrazione.
     */
    static class CircleShape extends Shape {
        private double radius;

        public CircleShape(double radius, ColorAPI colorAPI) {
            super(colorAPI);
            this.radius = radius;
        }

        // Metodo di basso livello: Delega all'Implementor
        public void draw() {
            colorAPI.color();
        }

        // Metodo di alto livello: Gestito interamente dall'Astrazione
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
                    // INIEZIONE DELLE DIPENDENZE:
                    // Possiamo combinare qualsiasi Forma con qualsiasi Colore a runtime.
                    // Non serve una classe "RedCircle", basta passare ColorAPI1 a CircleShape.
                    new CircleShape(3, new ColorAPI1()),
                    new CircleShape(11, new ColorAPI2()),
                };

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
            System.out.println("shape.getRadius() = " + shape.getRadius());
        }
    }
}