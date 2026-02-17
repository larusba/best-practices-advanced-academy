package exercises_part2.ex7;

public class Exercise7Step5 {
    public static abstract class DataMiner {
        public final void mine(String path) { extractData(); }
        protected abstract void extractData();
    }

    public static class XmlMiner extends DataMiner {
        @Override
        protected void extractData() {
            System.out.println("Extracting XML...");
        }
    }
}