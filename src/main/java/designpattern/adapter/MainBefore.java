package designpattern.adapter;

/**
 * PROBLEMA: Interfacce Incompatibili.
 *
 * Abbiamo due classi (Line, Rectangle) che concettualmente fanno la stessa azione ("disegnare"),
 * ma non condividono una gerarchia comune e hanno firme dei metodi diverse.
 *
 * CRITICITÀ:
 * - Violazione del Polimorfismo: Il client deve trattare gli oggetti come generici 'Object'.
 * - Logica Condizionale Fragile: L'uso di 'if (getClass()...)' è un chiaro Code Smell.
 * - Difficile da Estendere: Per aggiungere un 'Circle', dovremmo modificare il ciclo nel main.
 */
public class MainBefore {
    /**
     * Classe Legacy o di Libreria 1.
     * Richiede coordinate di inizio e fine.
     */
    static class Line {
        public void draw(int x1, int y1, int x2, int y2) {
            System.out.println(
                    "Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")");
        }
    }

    /**
     * Classe Legacy o di Libreria 2.
     * Richiede punto di origine, larghezza e altezza.
     * È incompatibile con la firma del metodo di Line.
     */
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

    public static class AdapterDemo {
        public static void main(String[] args) {
            // CODE SMELL: L'array di Object è sintomo di mancanza di astrazione.
            Object[] shapes = {new Line(), new Rectangle()};
            int x1 = 10, y1 = 20;
            int x2 = 30, y2 = 60;
            int width = 40, height = 40;

            // CODE SMELL: Il client deve conoscere i dettagli interni di ogni classe
            // ed effettuare casting espliciti.
            for (Object shape : shapes) {
                if (shape.getClass().getSimpleName().equals("Line")) {
                    ((Line) shape).draw(x1, y1, x2, y2);
                } else if (shape.getClass().getSimpleName().equals("Rectangle")) {
                    ((Rectangle) shape).draw(x2, y2, width, height);
                }
            }
        }
    }
}