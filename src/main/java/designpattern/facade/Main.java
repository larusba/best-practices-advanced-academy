package designpattern.facade;

import static designpattern.facade.ComplexLibraries.AudioMixer;
import static designpattern.facade.ComplexLibraries.BitrateReader;
import static designpattern.facade.ComplexLibraries.Codec;
import static designpattern.facade.ComplexLibraries.CodecFactory;
import static designpattern.facade.ComplexLibraries.MPEG4CompressionCodec;
import static designpattern.facade.ComplexLibraries.OggCompressionCodec;
import static designpattern.facade.ComplexLibraries.VideoFile;

import java.io.File;

public class Main {

    /** Here we implement the Facade Pattern We just use convertVideo() */
    public static class VideoConversionFacade {
        public File convertVideo(String fileName, String format) {
            System.out.println("VideoConversionFacade: conversion started.");
            VideoFile file = new VideoFile(fileName);
            Codec sourceCodec = CodecFactory.extract(file);

            /*
             * We could use enum Factory as well,
             * try it
             */
            Codec destinationCodec;
            if (format.equals("mp4")) {
                destinationCodec = new MPEG4CompressionCodec();
            } else {
                destinationCodec = new OggCompressionCodec();
            }
            VideoFile buffer = BitrateReader.read(file, sourceCodec);
            VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
            File result = (new AudioMixer()).fix(intermediateResult);
            System.out.println("VideoConversionFacade: conversion completed.");
            return result;
        }
    }

    /** We call the Facade, which provide a simple method convertVideo */
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.mp4", "mp4");

        System.out.println("mp4Video = " + mp4Video);
    }
}
