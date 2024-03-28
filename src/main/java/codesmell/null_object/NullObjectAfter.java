package codesmell.null_object;

public class NullObjectAfter {
    static class Company {
        private Customer customer;

        public Company(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return (customer == null) 
                    ? new NullCustomer() 
                    : customer;
        }
    }

    static class Customer {
        //…
        public String getName() {
            return "name";
        }
        public String getPlan() {
            return "plan";
        }
        // a lot of methods...
    }

    /**
     * Null Object
     */
    static class NullCustomer extends Customer {
        @Override public String getName() {
            return "nullName";
        }
        @Override public String getPlan() {
            return "nullPlan";
        }
    }


    public static void main(String[] args) {
        Customer customer = new Company(null).getCustomer();

        String plan = customer.getPlan();
        String name = customer.getName();

        System.out.println("name = " + name);
        System.out.println("plan = " + plan);
    }
}
