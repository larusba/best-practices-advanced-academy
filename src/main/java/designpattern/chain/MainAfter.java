package designpattern.chain;

import java.util.UUID;

public class MainAfter {
    static class Handler {
        private Handler nextInChain;

        private final String id;

        public Handler() {
            id = UUID.randomUUID().toString();
        }

        public void add(Handler next) {
            if (nextInChain == null) {
                nextInChain = next;
            } else {
                nextInChain.add(next);
            }
        }

        public void execute() {
            System.out.println("do something..." + id);
        }
    }

    public static class ChainDemo {
        public static void main(String[] args) {
            Handler rootChain = new Handler();
            rootChain.add(new Handler());
            rootChain.add(new Handler());
            rootChain.add(new Handler());

            for (int i = 1; i < 6; i++) {
                System.out.println("Operation #" + i + ":");
                rootChain.execute();
            }
        }
    }
}
