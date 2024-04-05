package designpattern.factory_method;

/**
 * Save/open/close a document in multiple format
 */
public class ExampleTwo {

    /**
     * Product interface
     */
    interface Document {
        void open();
        void save();
        void close();
    }

    /**
     * Product implementations
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
     * Factory interface
     */
    interface DocumentFactory {
        Document createDocument();
    }

    /**
     * Factory implementations
     */
    public static class TextDocumentFactory implements DocumentFactory {
        @Override
        public Document createDocument() {
            return new TextDocument();
        }
    }

    public static class PdfDocumentFactory implements DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    // Client code
    public class Main {
        public static void main(String[] args) {
            // Creating a text document
            DocumentFactory textDocumentFactory = new TextDocumentFactory();
            // -- method
            Document textDocument = textDocumentFactory.createDocument();
            textDocument.open();
            textDocument.save();
            textDocument.close();

            // Creating a PDF document
            DocumentFactory pdfDocumentFactory = new PdfDocumentFactory();
            Document pdfDocument = pdfDocumentFactory.createDocument();
            pdfDocument.open();
            pdfDocument.save();
            pdfDocument.close();
        }
    }


}
