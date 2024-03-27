package intro.coi;

public class Main {
    abstract static class Musician {
        abstract void play();
    }

    static class Singer extends Musician {
        public void play() {
            System.out.println("sing");
        }
    }

    static class Drummer extends Musician {
        public void play() {
            System.out.println("drum");
        }
    }

    /**
     * A Musician can be both a Drummer and a Singer Even if SingerDrummer IS A Singer and IS A
     * Drummer We cannot do SingerDrummer extend Singer, Drummer
     */
    static class SingerDrummer {
        Singer singer = new Singer();
        Drummer drummer = new Drummer();

        public void play() {
            singer.play();
            drummer.play();
        }
    }

    public static void main(String[] args) {
        SingerDrummer singerDrummer = new SingerDrummer();
        singerDrummer.play();
    }

    interface MyDatabase {
        void connect();
    }

    class Neo4jDatabase implements MyDatabase {

        @Override
        public void connect() {}
    }
}
