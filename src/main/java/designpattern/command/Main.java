package designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface Command {
        void execute();
    }

    static class DomesticEngineer implements Command {
        public void execute() {
            System.out.println("take out the trash");
        }
    }

    static class Politician implements Command {
        public void execute() {
            System.out.println("take money from the rich, take votes from the poor");
        }
    }

    static class Programmer implements Command {
        public void execute() {
            System.out.println("sell the bugs, charge extra for the fixes");
        }
    }

    public static class CommandDemo {
        /** This can be an API service that collect various kind of object */
        public static List produceRequests() {
            List<Command> commandList = new ArrayList<>();
            commandList.add(new DomesticEngineer());
            commandList.add(new Politician());
            commandList.add(new Programmer());
            return commandList;
        }

        public static void workOffRequests(List queue) {
            for (Object command : queue) {
                ((Command) command).execute();
            }
        }

        public static void main(String[] args) {
            List queue = produceRequests();

            /** Manipulate the object retrieved in `produceRequests` */
            workOffRequests(queue);
        }
    }
}
