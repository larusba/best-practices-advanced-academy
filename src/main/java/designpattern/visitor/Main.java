package designpattern.visitor;

import java.util.List;

/**
 * Esempio del Design Pattern Visitor.
 *
 * SCOPO:
 * Separare l'algoritmo (Visitor) dalla struttura dei dati (Element).
 * Permette di definire nuove operazioni su una gerarchia di classi senza modificare le classi stesse.
 *
 * MECCANICA (Double Dispatch):
 * 1. Il Client chiama `element.accept(visitor)`.
 * 2. L'Elemento chiama `visitor.visit(this)`.
 *
 * Grazie a questo "palleggio", il Visitor riceve il riferimento all'oggetto con il suo
 * TIPO REALE (es. FOO), non come interfaccia generica (Element).
 */
public class Main {
    
    /**
     * COMPONENT: Element Interface (Visitable).
     * Definisce il metodo che accetta il visitatore.
     */
    interface Element {
        void accept(Visitor v);
    }

    /** Concrete Element A */
    static class FOO implements Element {
        public void accept(Visitor v) {
            // DOUBLE DISPATCH - Passo 2:
            // Qui 'this' è di tipo FOO. Quindi viene chiamato visitor.visit(FOO).
            // Abbiamo recuperato il tipo specifico!
            v.visit(this);
        }

        public String getFOO() {
            return "FOO";
        }
    }

    /** Concrete Element B */
    static class BAR implements Element {
        public void accept(Visitor v) {
            // Qui 'this' è BAR -> chiama visitor.visit(BAR)
            v.visit(this);
        }

        public String getBAR() {
            return "BAR";
        }
    }

    /** Concrete Element C */
    static class BAZ implements Element {
        public void accept(Visitor v) {
            // Qui 'this' è BAZ -> chiama visitor.visit(BAZ)
            v.visit(this);
        }

        public String getBAZ() {
            return "BAZ";
        }
    }

    /**
     * COMPONENT: Visitor Interface.
     * Dichiara un metodo di visita per OGNI classe concreta della gerarchia Element.
     *
     * NOTA: Questo pattern viola l'Open/Closed Principle rispetto alla gerarchia degli elementi.
     * Se aggiungi una classe "QUX", devi modificare l'interfaccia Visitor e TUTTI i visitor concreti.
     */
    interface Visitor {
        // Overloading dei metodi visit
        void visit(FOO foo);

        void visit(BAR bar);

        void visit(BAZ baz);
    }

    /**
     * COMPONENT: Concrete Visitor 1.
     * Incapsula una famiglia di algoritmi (es. "Operazione Up").
     * Contiene la logica specifica per trattare ogni tipo di elemento.
     */
    static class UpVisitor implements Visitor {
        public void visit(FOO foo) {
            System.out.println("do Up on " + foo.getFOO());
        }

        public void visit(BAR bar) {
            System.out.println("do Up on " + bar.getBAR());
        }

        public void visit(BAZ baz) {
            System.out.println("do Up on " + baz.getBAZ());
        }
    }

    /**
     * COMPONENT: Concrete Visitor 2.
     * Incapsula un'altra operazione completamente diversa (es. "Operazione Down").
     * Abbiamo aggiunto una nuova funzionalità al sistema senza toccare le classi FOO, BAR, BAZ!
     */
    static class DownVisitor implements Visitor {
        public void visit(FOO foo) {
            System.out.println("do Down on " + foo.getFOO());
        }

        public void visit(BAR bar) {
            System.out.println("do Down on " + bar.getBAR());
        }

        public void visit(BAZ baz) {
            System.out.println("do Down on " + baz.getBAZ());
        }
    }

    public static class VisitorDemo {
        public static void main(String[] args) {
            // Lista polimorfica: Qui i tipi sono visti solo come 'Element'.
            List<Element> list = List.of(new FOO(), new BAR(), new BAZ());
            
            // Creiamo i "comportamenti"
            UpVisitor up = new UpVisitor();
            DownVisitor down = new DownVisitor();

            System.out.println("--- Processing with UpVisitor ---");
            for (Element element : list) {
                // DOUBLE DISPATCH - Passo 1:
                // Non sappiamo se element è FOO o BAR, ma chiamiamo accept.
                // Sarà l'oggetto stesso a richiamare il metodo visit corretto sul visitor.
                element.accept(up);
            }

            System.out.println("\n--- Processing with DownVisitor ---");
            for (Element element : list) {
                element.accept(down);
            }
        }
    }
}