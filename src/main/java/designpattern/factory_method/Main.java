package designpattern.factory_method;

/**
 * Esempio del concetto base dietro al Factory Method (implementato come Simple Factory logic).
 *
 * Il problema risolto qui è la creazione condizionale di oggetti.
 * A seconda dell'input (estensione del file), dobbiamo istanziare una classe diversa
 * (GifReader o JpegReader), ma vogliamo trattarle tutte allo stesso modo tramite
 * un'interfaccia comune.
 *
 * Concetti chiave:
 * - Product Interface (ImageReader): Il contratto comune.
 * - Concrete Products (GifReader, JpegReader): Le implementazioni specifiche.
 * - Decision Logic: La logica "if/else" che decide cosa creare (qui nel main, idealmente in un metodo factory).
 */
public class Main {
    /**
     * COMPONENT: Product Interface.
     * Definisce l'interfaccia comune per gli oggetti che il metodo factory creerà.
     * Il client userà solo questa interfaccia, ignorando le classi concrete.
     */
    interface ImageReader {
        DecodedImage getDecodeImage();
    }

    /**
     * Classe di supporto che rappresenta il risultato dell'operazione.
     */
    static class DecodedImage {
        private final String image;

        public DecodedImage(String image) {
            this.image = image;
        }

        @Override
        public String toString() {
            return image + ": is decoded";
        }
    }

    /**
     * COMPONENT: Concrete Product 1.
     * Implementazione specifica per file GIF.
     */
    static class GifReader implements ImageReader {
        private final DecodedImage decodedImage;

        public GifReader(String image) {
            this.decodedImage = new DecodedImage(image);
        }

        @Override
        public DecodedImage getDecodeImage() {
            return decodedImage;
        }
    }

    /**
     * COMPONENT: Concrete Product 2.
     * Implementazione specifica per file JPEG.
     */
    static class JpegReader implements ImageReader {
        private final DecodedImage decodedImage;

        public JpegReader(String image) {
            decodedImage = new DecodedImage(image);
        }

        @Override
        public DecodedImage getDecodeImage() {
            return decodedImage;
        }
    }

    /**
     * Client e Creator.
     */
    public static class FactoryMethodDemo {
        public static void main(String[] args) {
            DecodedImage decodedImage;
            ImageReader reader = null;
            
            // Simulazione input: es. "image.gif" o "photo.jpeg"
            String image = args[0];
            String format = image.substring(image.indexOf('.') + 1, (image.length()));

            // FACTORY LOGIC:
            // Questa è la parte cruciale. La decisione su quale classe istanziare
            // avviene a runtime.
            // In un refactoring successivo, questo blocco if/else verrebbe spostato
            // in un metodo statico separato (es. ImageReaderFactory.createReader(format)).
            if (format.equals("gif")) {
                reader = new GifReader(image);
            }
            if (format.equals("jpeg")) {
                reader = new JpegReader(image);
            }

            assert reader != null;
            
            // UTILIZZO POLIMORFICO:
            // Da qui in poi, non importa se è GIF o JPEG. Usiamo l'interfaccia ImageReader.
            decodedImage = reader.getDecodeImage();
            System.out.println(decodedImage);
        }
    }
}