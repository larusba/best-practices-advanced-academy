package exercises;

/**
 * **Pattern Template Method**
 * Lo scheletro dell'algoritmo è definito una volta sola nella classe base (metodo final),
 * mentre le sottoclassi implementano solo i passaggi specifici che variano.
 */
public class Exercise7After {

    public static abstract class ReportGenerator {
        // Questo è il "Template Method". È final per impedire che venga modificata la sequenza.
        public final void generateReport() {
            printHeader();
            printBody(); // Questo passo è delegato alle sottoclassi
            printFooter();
        }

        private void printHeader() {
            // Logica comune
            System.out.println("Header: Report Aziendale Generico");
        }

        // Metodo astratto (Hook) che deve essere implementato
        protected abstract void printBody();

        private void printFooter() {
            // Logica comune
            System.out.println("Footer: Copyright 2024\n");
        }
    }

    public static class PdfReport extends ReportGenerator {
        @Override
        protected void printBody() {
            System.out.println("Body: Contenuto formattato per PDF...");
        }
    }

    public static class HtmlReport extends ReportGenerator {
        @Override
        protected void printBody() {
            System.out.println("Body: Tag <div> con dati HTML...");
        }
    }

    public static void main(String[] args) {
        ReportGenerator pdf = new PdfReport();
        pdf.generateReport();

        ReportGenerator html = new HtmlReport();
        html.generateReport();
    }
}