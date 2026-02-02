package designpattern.factory_method;

/**
 * Esempio formale del Design Pattern Factory Method.
 *
 * A differenza della "Simple Factory" (che usa uno switch case), qui definiamo
 * una gerarchia di Factory parallela alla gerarchia dei Prodotti.
 *
 * VANTAGGI DIDATTICI:
 * - Open/Closed Principle: Per aggiungere un nuovo formato (es. HTML),
 * non devi modificare codice esistente (niente 'if' da aggiornare),
 * ma solo creare una nuova classe HtmlDocument e una HtmlDocumentFactory.
 * - Single Responsibility: Ogni Factory sa creare un solo tipo di prodotto.
 */
public class ExampleTwo {

    /**
     * COMPONENT: Product Interface.
     * Definisce le operazioni comuni che tutti i documenti devono supportare.
     * Il client interagisce solo con questa interfaccia.
     */
    interface Document {
        void open();
        void save();
        void close();
    }

    /**
     * COMPONENT: Concrete Product A.
     * Implementazione specifica del documento di testo.
     */
    public static class TextDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Text Document");
        }

        @Override
        public void save() {
            System.out.println("Saving Text Document");
        }

        @Override
        public void close() {
            System.out.println("Closing Text Document");
        }
    }

    /**
     * COMPONENT: Concrete Product B.
     * Implementazione specifica del documento PDF.
     */
    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF Document");
        }

        @Override
        public void save() {
            System.out.println("Saving PDF Document");
        }

        @Override
        public void close() {
            System.out.println("Closing PDF Document");
        }
    }

    /**
     * COMPONENT: Creator / Factory Interface.
     * Dichiara il "Factory Method" (createDocument) che le sottoclassi dovranno implementare.
     */
    interface DocumentFactory {
        Document createDocument();
    }

    /**
     * COMPONENT: Concrete Creator A.
     * Questa classe sa specificamente come istanziare un TextDocument.
     */
    public static class TextDocumentFactory implements DocumentFactory {
        @Override
        public Document createDocument() {
            return new TextDocument();
        }
    }

    /**
     * COMPONENT: Concrete Creator B.
     * Questa classe sa specificamente come istanziare un PdfDocument.
     */
    public static class PdfDocumentFactory implements DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    // Client code
    public class Main {
        public static void main(String[] args) {
            // Caso 1: Vogliamo lavorare con documenti di testo.
            // Istanziamo la factory specifica (in scenari reali, questa scelta
            // potrebbe venire da una configurazione o dependency injection).
            DocumentFactory textDocumentFactory = new TextDocumentFactory();
            
            // Il metodo factory crea l'oggetto. Il client non usa 'new TextDocument()'.
            Document textDocument = textDocumentFactory.createDocument();
            textDocument.open();
            textDocument.save();
            textDocument.close();

            // Caso 2: Vogliamo lavorare con PDF.
            // Notare come il codice che usa il documento (open/save/close) rimanga identico.
            DocumentFactory pdfDocumentFactory = new PdfDocumentFactory();
            Document pdfDocument = pdfDocumentFactory.createDocument();
            pdfDocument.open();
            pdfDocument.save();
            pdfDocument.close();
        }
    }
}