package designpattern.facade;

import java.io.File;

/**
 * Simula una libreria complessa di terze parti (o un sottosistema legacy) per l'elaborazione video.
 *
 * RUOLO: Sottosistema Complesso (Complex Subsystem).
 *
 * PROBLEMA:
 * - Le classi qui definite (VideoFile, Codec, AudioMixer, BitrateReader) sono molte e granulari.
 * - Per convertire un video, il Client è costretto a conoscere l'ordine esatto delle chiamate.
 * - Questo crea un forte accoppiamento: se la libreria cambia, il codice del Client si rompe.
 *
 * SOLUZIONE (tramite Facade):
 * - Non usare queste classi direttamente nel codice principale.
 * - Creare una classe "Wrapper" (Facade) che incapsuli la sequenza corretta di operazioni.
 */
public class ComplexLibraries {

    /**
     * Componente di basso livello del sottosistema.
     */
    public interface Codec {
        String getType();
    }

    public static class MPEG4CompressionCodec implements Codec {
        @Override
        public String getType() {
            return "mp4";
        }
    }

    public static class OggCompressionCodec implements Codec {
        @Override
        public String getType() {
            return "ogg";
        }
    }

    /**
     * Oggetto di dominio del sottosistema.
     */
    public static class VideoFile {
        private final String name;
        private final String codecType;

        public VideoFile(String name) {
            this.name = name;
            this.codecType = name.substring(name.indexOf(".") + 1);
        }

        public String getCodecType() {
            return codecType;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Servizio 1: Gestione Audio.
     * Richiede un'istanza di VideoFile già processata per funzionare.
     */
    public static class AudioMixer {
        public File fix(VideoFile result) {
            System.out.println("AudioMixer: fixing audio...");
            return new File("tmp");
        }
    }

    /**
     * Servizio 2: Lettura e Conversione Bitrate.
     *
     * PROBLEMA:
     * Il client deve ricordarsi di chiamare prima 'read' e poi 'convert',
     * passando i parametri corretti (buffer e codec) ogni volta.
     */
    public static class BitrateReader {
        public static VideoFile read(VideoFile file, Codec codec) {
            System.out.println("BitrateReader: reading file...");
            return file;
        }

        public static VideoFile convert(VideoFile buffer, Codec codec) {
            System.out.println("BitrateReader: writing file...");
            return buffer;
        }
    }

    /**
     * Servizio 3: Factory dei Codec.
     * Il client deve sapere quale codec istanziare in base alla stringa del file.
     */
    public static class CodecFactory {
        public static Codec extract(VideoFile file) {
            String type = file.getCodecType();
            if (type.equals("mp4")) {
                System.out.println("CodecFactory: extracting mpeg audio...");
                return new MPEG4CompressionCodec();
            } else {
                System.out.println("CodecFactory: extracting ogg audio...");
                return new OggCompressionCodec();
            }
        }
    }
}