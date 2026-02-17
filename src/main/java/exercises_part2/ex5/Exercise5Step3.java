package exercises_part2.ex5;

/**
 * STEP 3: REFACTORING COMPLETATO (GREEN)
 * L'ordine delega il comportamento allo stato corrente.
 */
public class Exercise5Step3 {
    interface OrderState {
        void pay(Order ctx);
        void ship(Order ctx);
    }

    public static class Order {
        private OrderState state;
        
        public Order() { this.state = new NewState(); } // Stato iniziale

        public void pay() { state.pay(this); }
        public void ship() { state.ship(this); }
        
        public void setState(OrderState s) { this.state = s; }
    }

    // Stati Concreti (Implementazione base)
    static class NewState implements OrderState {
        public void pay(Order ctx) { ctx.setState(new PaidState()); }
        public void ship(Order ctx) { System.out.println("Prima paga!"); }
    }
    static class PaidState implements OrderState {
        public void pay(Order ctx) { System.out.println("Già pagato."); }
        public void ship(Order ctx) { ctx.setState(new ShippedState()); }
    }
    static class ShippedState implements OrderState {
        public void pay(Order ctx) { }
        public void ship(Order ctx) { }
    }
}