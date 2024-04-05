package designpattern.builder;

public class Main {

    /**
     * COMPONENT: Director
     */
    public static class Computer {
        /**
         * Instead of a constructor with potentially 10/20 parameters eg: Computer(String hdd,
         * String ram, boolean isGraphicsCardEnabled, etc....);
         */

        // required parameters
        private final String hdd;

        private final String ram;

        // optional parameters
        private final boolean isGraphicsCardEnabled;
        private final boolean isBluetoothEnabled;

        public String getHdd() {
            return hdd;
        }

        public String getRam() {
            return ram;
        }

        public boolean isGraphicsCardEnabled() {
            return isGraphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        /**
         * Inject the Builder 
         * Product class
         */
        private Computer(Builder builder) {
            this.hdd = builder.hdd;
            this.ram = builder.ram;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        /**
         * COMPONENT: Builder
         */
        public static class Builder {

            // required parameters
            private final String hdd;
            private final String ram;

            // optional parameters
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            public Builder(String hdd, String ram) {
                this.hdd = hdd;
                this.ram = ram;
            }

            public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            /** We create our builder */
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        // Using builder to get the object in a single line of code and
        // without any inconsistent state or arguments management issues
        Computer comp =
                new Computer.Builder("500 GB", "2 GB")
                        .setBluetoothEnabled(true)
                        .setGraphicsCardEnabled(true)
                        .build();
    }
}
