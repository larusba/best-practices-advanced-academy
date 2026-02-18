package exercises_part2.ex13;

public class Exercise13Step5 {
    public interface Logger {
        void log(String msg);
    }

    public static class FileLogger implements Logger {
        public void log(String msg) {
            System.out.println("Writing to file: " + msg);
        }
    }
}