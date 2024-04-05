package reflection;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class CompressionAlgo {
    /*
    decompressor can be e.g. GzipCompressorInputStream.class, BZip2CompressorInputStream.class, ..
    */
    private final Class<?> compressor;

    public CompressionAlgo(Class<?> compressor) {
        this.compressor = compressor;
    }

    /**
     * call e.g. a `new
     * org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream(outputStream)` if
     * `this.compressor` is
     * `org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream.class`
     */
    public OutputStream getOutputStream(OutputStream outputStream) throws Exception {
        return (OutputStream)
                compressor.getConstructor(OutputStream.class).newInstance(outputStream);
    }

    /**
     * convert a String to a compressed byte[], e.g. using GZIP algorithm
     *
     * <p>USAGE EXAMPLE: new
     * CompressionAlgo(org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream.class)
     * .compress("StringToCompress", "UTF-8")
     */
    public byte[] compress(String string, Charset charset) throws Exception {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            try (OutputStream outputStream = getOutputStream(stream)) {
                outputStream.write(string.getBytes(charset));
            }
            return stream.toByteArray();
        }
    }
    /*

    */
}
