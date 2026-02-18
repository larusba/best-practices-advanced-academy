package exercises_part2.ex21;

public class Exercise21Step5 {
    // Implementazione Reale
    public static class XmlExportVisitor implements Exercise21Step3.Visitor {
        @Override
        public String visit(Exercise21Step3.Paragraph p) {
            return "<text>" + p.getText() + "</text>";
        }

        @Override
        public String visit(Exercise21Step3.Image i) {
            return "<media>" + i.getSrc() + "</media>";
        }
    }
}