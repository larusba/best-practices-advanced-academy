package exercises_part2.ex21;

public class Exercise21Step3 {
    
    // 1. Interfaccia Visitor
    public interface Visitor {
        String visit(Paragraph p);
        String visit(Image i);
    }

    // 2. Elementi che accettano il visitor
    public interface Element {
        String accept(Visitor v);
    }

    public static class Paragraph implements Element {
        private String text;
        public Paragraph(String t) { this.text = t; }
        public String getText() { return text; }
        
        @Override
        public String accept(Visitor v) {
            return v.visit(this); // Double Dispatch
        }
    }

    public static class Image implements Element {
        private String src;
        public Image(String s) { this.src = s; }
        public String getSrc() { return src; }
        
        @Override
        public String accept(Visitor v) {
            return v.visit(this);
        }
    }

    // 3. Concrete Visitor (HTML)
    public static class HtmlExportVisitor implements Visitor {
        public String visit(Paragraph p) { return "<p>" + p.getText() + "</p>"; }
        public String visit(Image i) { return "<img src='" + i.getSrc() + "' />"; }
    }
}