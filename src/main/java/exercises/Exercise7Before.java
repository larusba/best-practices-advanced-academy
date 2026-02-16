package exercises;

/**
 * ESERCIZIO: Rimuovi la duplicazione del codice.
 * La struttura dell'algoritmo (header -> body -> footer) è identica in entrambe le classi.
 */
public class Exercise7Before {

    public static class PdfReport {
        public void generateReport() {
            System.out.println("Header: Report Aziendale (PDF)");
            System.out.println("Body: Contenuto formattato per PDF..."); // Logica specifica
            System.out.println("Footer: Copyright 2024\n");
        }
    }

    public static class HtmlReport {
        public void generateReport() {
            System.out.println("Header: Report Aziendale (HTML)");
            System.out.println("Body: Tag <div> con dati HTML..."); // Logica specifica
            System.out.println("Footer: Copyright 2024\n");
        }
    }

    public static void main(String[] args) {
        new PdfReport().generateReport();
        new HtmlReport().generateReport();
    }
}