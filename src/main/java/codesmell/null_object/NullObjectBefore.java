package codesmell.null_object;

public class NullObjectBefore {
    static class Company {
        private Customer customer;

        public Company(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }
    }

    static class Customer {
        // …
        public String getName() {
            return "name";
        }

        public String getPlan() {
            return "plan";
        }
        // a lot of methods...
    }

    public static void main(String[] args) {

        // Somewhere in client code
        Customer customer = new Company(null).getCustomer();

        // we could have a lot of customer == null
        String plan = customer == null ? "nullPlan" : customer.getPlan();

        String name = customer == null ? "nullName" : customer.getName();

        System.out.println("name = " + name);
        System.out.println("plan = " + plan);
    }
}
