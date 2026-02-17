package exercises_part2.ex5;

public class Exercise5Step5 {
    interface OrderState {
        void refund(Order ctx);
    }

    public static class Order {
        private OrderState state;
        public void setState(OrderState s) { this.state = s; }
        public OrderState getState() { return state; }
        
        public void refund() { state.refund(this); }
    }

    static class PaidState implements OrderState {
        public void refund(Order ctx) {
            System.out.println("Rimborsato.");
            ctx.setState(new RefundedState());
        }
    }

    static class RefundedState implements OrderState {
        public void refund(Order ctx) { System.out.println("Già rimborsato."); }
    }
}