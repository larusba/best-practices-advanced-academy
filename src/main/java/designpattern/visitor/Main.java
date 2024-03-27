package designpattern.visitor;

import java.util.List;

public class Main {
    interface Element {
        void accept(Visitor v);
    }

    static class FOO implements Element {
        public void accept(Visitor v) {
            v.visit(this);
        }

        public String getFOO() {
            return "FOO";
        }
    }

    static class BAR implements Element {
        public void accept(Visitor v) {
            v.visit(this);
        }

        public String getBAR() {
            return "BAR";
        }
    }

    static class BAZ implements Element {
        public void accept(Visitor v) {
            v.visit(this);
        }

        public String getBAZ() {
            return "BAZ";
        }
    }

    interface Visitor {
        void visit(FOO foo);

        void visit(BAR bar);

        void visit(BAZ baz);
    }

    /** 1st family of algos */
    static class UpVisitor implements Visitor {
        public void visit(FOO foo) {
            System.out.println("do Up on " + foo.getFOO());
        }

        public void visit(BAR bar) {
            System.out.println("do Up on " + bar.getBAR());
        }

        public void visit(BAZ baz) {
            System.out.println("do Up on " + baz.getBAZ());
        }
    }

    /** 2nd family of algos */
    static class DownVisitor implements Visitor {
        public void visit(FOO foo) {
            System.out.println("do Down on " + foo.getFOO());
        }

        public void visit(BAR bar) {
            System.out.println("do Down on " + bar.getBAR());
        }

        public void visit(BAZ baz) {
            System.out.println("do Down on " + baz.getBAZ());
        }
    }

    public static class VisitorDemo {
        public static void main(String[] args) {
            /** Create a list of algos, and make them interchangeable */
            List<Element> list = List.of(new FOO(), new BAR(), new BAZ());
            UpVisitor up = new UpVisitor();
            DownVisitor down = new DownVisitor();
            for (Element element : list) {
                element.accept(up);
            }
            for (Element element : list) {
                element.accept(down);
            }
        }
    }
}
