package designpattern.chain;

import java.util.List;
import java.util.UUID;

/** To know what is the current executor */
public class MainBefore {
    static class Handler {
        private final String id;

        public Handler() {
            id = UUID.randomUUID().toString();
        }

        public void execute() {
            System.out.println("do something..." + id);
        }

        public String getId() {
            return id;
        }
    }

    public static class ChainDemo {
        public static void main(String[] args) {
            List<Handler> handlers =
                    List.of(
                            new Handler(),
                            new Handler(),
                            new Handler(),
                            // the last one is the true executor
                            new Handler());
            for (int i = 1; i < 6; i++) {
                System.out.println("Operation #" + i + ":");

                for (Handler handler : handlers) {
                    //
                    // to know what is the current executor
                    //
                    if (handler.equals(handlers.get(handlers.size() - 1))) {
                        handler.execute();
                    }
                }
            }
        }
    }
}
