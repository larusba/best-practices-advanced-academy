package exercises_part2.ex5;

public class Exercise5Step4 {
    interface OrderState {
        void pay(Order ctx);
        void refund(Order ctx); // Nuovo metodo nell'interfaccia
    }
    
    // Stub dell'ordine
    public static class Order {
        private OrderState state;
        public void setState(OrderState s) { this.state = s; }
        public void refund() { 
            // TODO: Delegare
        } 
    }
    
    // Stub dello stato Paid
    static class PaidState implements OrderState {
        public void pay(Order ctx) {}
        public void refund(Order ctx) {
            // TODO: Logica transizione
        }
    }
}