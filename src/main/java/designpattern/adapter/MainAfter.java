package designpattern.adapter;

/**
 * SOLUZIONE: Design Pattern Adapter.
 *
 * Il pattern permette a oggetti con interfacce incompatibili di collaborare.
 * Viene introdotta un'interfaccia comune (Target) e delle classi wrapper (Adapter)
 * che traducono le chiamate dal formato del Target a quello dell'Adaptee.
 */
public class MainAfter {
    /**
     * COMPONENT: Target Interface.
     * Definisce il contratto standard che il Client si aspetta di usare.
     * In questo caso, il client vuole disegnare usando sempre 4 coordinate (2 punti).
     */
    interface Shape {
        void draw(int x, int y, int z, int j);
    }

    /**
     * COMPONENT: Adaptee (Adattato).
     * La classe esistente che ha un'interfaccia diversa da quella richiesta.
     */
    static class Line {
        public void draw(int x1, int y1, int x2, int y2) {
            System.out.println(
                    "Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")");
        }
    }

    static class Rectangle {
        public void draw(int x, int y, int width, int height) {
            System.out.println(
                    "Rectangle with coordinate left-down point ("
                            + x
                            + ";"
                            + y
                            + "), width: "
                            + width
                            + ", height: "
                            + height);
        }
    }

    /**
     * COMPONENT: Adapter Concreto (per Line).
     * Implementa l'interfaccia Target (Shape) e wrappa l'Adaptee (Line).
     * In questo caso l'adattamento è semplice delegazione diretta.
     */
    static class LineAdapter implements Shape {
        private Line adaptee;

        public LineAdapter(Line line) {
            this.adaptee = line;
        }

        @Override
        public void draw(int x1, int y1, int x2, int y2) {
            adaptee.draw(x1, y1, x2, y2);
        }
    }

    /**
     * COMPONENT: Adapter Concreto (per Rectangle).
     *
     * Qui avviene la vera magia dell'Adapter:
     * Il client passa 2 punti (x1, y1, x2, y2), ma il rettangolo vuole (x, y, w, h).
     * L'Adapter esegue la logica di conversione matematica per colmare il divario.
     */
    static class RectangleAdapter implements Shape {
        private Rectangle adaptee;

        public RectangleAdapter(Rectangle rectangle) {
            this.adaptee = rectangle;
        }

        @Override
        public void draw(int x1, int y1, int x2, int y2) {
            // Logica di adattamento dei dati
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int width = Math.abs(x2 - x1);
            int height = Math.abs(y2 - y1);
            
            // Delega all'oggetto originale con i parametri convertiti
            adaptee.draw(x, y, width, height);
        }
    }

    public static class AdapterDemo {
        public static void main(String[] args) {
            // Il client lavora solo con l'interfaccia Shape (Polimorfismo).
            // Non sa se sotto c'è una Linea o un Rettangolo adattato.
            Shape[] shapes = {new RectangleAdapter(new Rectangle()), new LineAdapter(new Line())};
            
            int x1 = 10, y1 = 20;
            int x2 = 30, y2 = 60;
            
            for (Shape shape : shapes) {
                // Chiamata uniforme
                shape.draw(x1, y1, x2, y2);
            }
        }
    }
}