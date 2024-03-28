package codesmell.polymorphism;


public class MainBefore {
    static class People {

        int type;
        public People(int type) {
            this.type = type;
        }

        String getSpeed() {
            switch (type) {
                case 1:
                    // This could be complex implementations
                    return "Aldo";
                case 2:
                    return "Giovanni";
                case 3:
                    return "Giacomo";
            }
            throw new RuntimeException("Should be unreachable");
        }
    }

    public void main(String[] args) {
        People object = new People(0);

        object.getSpeed();
    }

}
