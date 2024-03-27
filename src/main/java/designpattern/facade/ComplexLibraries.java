package designpattern.facade;

import java.io.File;

public class ComplexLibraries {
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

    public static class AudioMixer {
        public File fix(VideoFile result) {
            System.out.println("AudioMixer: fixing audio...");
            return new File("tmp");
        }
    }

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

    /** We could use enum Factory as well, try it */
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
