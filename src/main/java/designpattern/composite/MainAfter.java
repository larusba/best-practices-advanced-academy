package designpattern.composite;

import java.util.ArrayList;

/**
 * Esempio di applicazione corretta del Composite Design Pattern.
 *
 * SOLUZIONE:
 * Il pattern Composite permette di comporre oggetti in strutture ad albero per rappresentare
 * gerarchie "parte-tutto". Consente ai client di trattare oggetti singoli (File)
 * e composizioni di oggetti (Directory) in modo uniforme tramite un'interfaccia comune.
 *
 * Componenti:
 * - Component: AbstractFile (Interfaccia comune).
 * - Leaf: File (Oggetto base, senza figli).
 * - Composite: Directory (Contenitore, ha figli e delega operazioni).
 */
public class MainAfter {
    /**
     * COMPONENT: Interfaccia comune ("Lowest Common Denominator").
     *
     * Definisce il contratto che sia i file singoli che le cartelle devono rispettare.
     * Grazie a questo, la Directory non deve sapere cosa contiene esattamente.
     */
    interface AbstractFile {
        void ls();
    }

    /**
     * LEAF (Foglia): Implementa l'interfaccia Component.
     * Rappresenta l'oggetto indivisibile. Esegue l'operazione effettiva.
     */
    static class File implements AbstractFile {
        private final String name;

        public File(String name) {
            this.name = name;
        }

        public void ls() {
            System.out.println(CompositeDemo.compositeBuilder + name);
        }
    }

    /**
     * COMPOSITE: Implementa l'interfaccia Component e contiene figli Component.
     * Il suo compito principale e' delegare il lavoro ai suoi sotto-elementi.
     */
    static class Directory implements AbstractFile {
        private String name;
        private ArrayList includedFiles = new ArrayList();

        public Directory(String name) {
            this.name = name;
        }

        public void add(Object obj) {
            includedFiles.add(obj);
        }

        /**
         * Implementazione ricorsiva tramite polimorfismo.
         *
         * Non c'e' piu' bisogno di controllare con instanceof o getClass().
         * Chiamiamo semplicemente obj.ls() e Java invochera' il metodo corretto
         * a seconda che l'oggetto sia un File o una Directory.
         */
        public void ls() {
            System.out.println(CompositeDemo.compositeBuilder + name);
            CompositeDemo.compositeBuilder.append("   ");
            for (Object includedFile : includedFiles) {
                // Leverage the "lowest common denominator"
                AbstractFile obj = (AbstractFile) includedFile;
                obj.ls();
            }
            CompositeDemo.compositeBuilder.setLength(CompositeDemo.compositeBuilder.length() - 3);
        }
    }

    public static class CompositeDemo {
        public static StringBuffer compositeBuilder = new StringBuffer();

        public static void main(String[] args) {
            Directory music = new Directory("MUSIC");
            Directory scorpions = new Directory("SCORPIONS");
            Directory dio = new Directory("DIO");
            File track1 = new File("Don't wary, be happy.mp3");
            File track2 = new File("track2.m3u");
            File track3 = new File("Wind of change.mp3");
            File track4 = new File("Big city night.mp3");
            File track5 = new File("Rainbow in the dark.mp3");
            music.add(track1);
            music.add(scorpions);
            music.add(track2);
            scorpions.add(track3);
            scorpions.add(track4);
            scorpions.add(dio);
            dio.add(track5);
            music.ls();
        }
    }
}