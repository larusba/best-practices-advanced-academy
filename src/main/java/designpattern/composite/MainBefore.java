package designpattern.composite;

import java.util.ArrayList;

public class MainBefore {
    static class File {
        private String name;

        public File(String name) {
            this.name = name;
        }

        public void ls() {
            System.out.println(CompositeDemo.compositeBuilder + name);
        }
    }

    static class Directory {
        private String name;
        private final ArrayList includedFiles = new ArrayList();

        public Directory(String name) {
            this.name = name;
        }

        public void add(Object obj) {
            includedFiles.add(obj);
        }

        /**
         * here we have 2 possible implementations: File and Directory itself
         *
         * <p>--> Tree Structure
         *
         * <p>We could use Composite
         */
        public void ls() {
            System.out.println(CompositeDemo.compositeBuilder + name);
            CompositeDemo.compositeBuilder.append("   ");
            for (Object obj : includedFiles) {
                // Recover the type of this object
                String name = obj.getClass().getSimpleName();
                if (name.equals("Directory")) {
                    ((Directory) obj).ls();
                } else {
                    ((File) obj).ls();
                }
            }
            CompositeDemo.compositeBuilder.setLength(CompositeDemo.compositeBuilder.length() - 3);
        }
    }

    public static class CompositeDemo {
        public static StringBuilder compositeBuilder = new StringBuilder();

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
