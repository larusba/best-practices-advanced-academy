package exercises_part2.ex5;

/**
 * STEP 2: DESIGN DELLO STATO (RED)
 *
 * OBIETTIVO REFACTORING:
 * Incapsulare ogni stato in una propria classe.
 */
public class Exercise5Step2 {
    
    // Interfaccia dello Stato
    interface OrderState {
        void pay(Order ctx);
        void ship(Order ctx);
    }

    public static class Order {
        private OrderState state;
        
        // Stub: Non delega ancora
        public void pay() { }
        public void ship() { }
        
        public void setState(OrderState state) { this.state = state; }
        public OrderState getState() { return state; }
    }
}