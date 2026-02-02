package designpattern.proxy;

/**
 * Esempio del Design Pattern Proxy (Variante: Virtual Proxy).
 *
 * SCOPO:
 * Fornire un sostituto o un segnaposto per un altro oggetto per controllarne l'accesso.
 *
 * PROBLEMA RISOLTO:
 * - Costo di creazione: Creare un oggetto RealImage è costoso (richiede caricamento da disco/rete).
 * - Spreco di risorse: Se l'applicazione crea 100 immagini ma l'utente ne guarda solo 1,
 * caricare le altre 99 è uno spreco di memoria e tempo (avvio lento).
 *
 * SOLUZIONE:
 * - Il Client interagisce con il Proxy.
 * - Il Proxy crea l'oggetto "Reale" solo quando viene chiamato il metodo displayImage().
 */
public class Main {
    /**
     * COMPONENT: Subject Interface.
     * Definisce l'interfaccia comune per RealImage e ProxyImage.
     * Il client lavora con questa interfaccia, rendendo il proxy trasparente.
     */
    interface Image {
        public void displayImage();
    }

    /**
     * COMPONENT: Real Subject.
     * L'oggetto "vero" che fa il lavoro pesante.
     */
    static class RealImage implements Image {
        private String filename;

        /**
         * NOTA: Il costruttore esegue un'operazione pesante.
         * Ogni volta che facciamo 'new RealImage', l'applicazione si blocca per 5 secondi.
         */
        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }

        private void loadImageFromDisk() {
            /*
             * Potentially can be an expensive operation,
             * e.g. via a RestAPI...
             */
            System.out.println("Loading..." + filename);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void displayImage() {
            System.out.println("Displaying " + filename);
        }
    }

    /**
     * COMPONENT: Proxy.
     * Mantiene un riferimento al RealSubject, ma lo crea solo se necessario.
     */
    static class ProxyImage implements Image {
        private final String filename;
        // Riferimento all'oggetto pesante (inizialmente null)
        private RealImage image;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        /**
         * Lazy - initialization (Inizializzazione Pigra).
         *
         * <p>Delegates to RealImage.loadImageFromDisk() the expensive part
         * only when the method is actually called.
         */
        public void displayImage() {
            // 1. Controllo: L'oggetto pesante esiste già?
            // Se no, lo creo ora (pagando il costo di caricamento in questo momento).
            if (image == null) {
                image = new RealImage(filename);
            }
            // 2. Delega: Passo la chiamata all'oggetto reale.
            image.displayImage();
        }
    }

    static class ProxyExample {
        public static void main(String[] args) {
            // 1. Istanziazione veloce.
            // Creiamo i Proxy. Il costruttore di ProxyImage è leggerissimo.
            // Nessun caricamento da disco avviene qui. L'app si avvia istantaneamente.
            Image image1 = new ProxyImage("HiRes_10MB_Photo1");
            Image image2 = new ProxyImage("HiRes_10MB_Photo2");
            Image image3 = new ProxyImage("HiRes_10MB_Photo3");

            // 2. Primo accesso (Slow).
            // Il proxy vede che l'immagine è null, la carica (5 sec), poi la mostra.
            System.out.println("--- First call image1 ---");
            image1.displayImage(); // loading necessary

            System.out.println("--- First call image2 ---");
            image2.displayImage(); // loading necessary

            // 3. Accesso successivo (Fast).
            // Il proxy ha già l'oggetto RealImage in memoria (Cached).
            // Non ricarica da disco, delega direttamente la stampa.
            System.out.println("--- Second call image1 ---");
            image1.displayImage(); // no loading necessary; already done
            
            System.out.println("--- Second call image2 ---");
            image2.displayImage(); // no loading necessary; already done

            // NOTA: image3 non è mai stata chiamata, quindi non è mai stata caricata in memoria.
            // Risparmio di risorse!
            // image3.displayImage(); 
        }
    }
}