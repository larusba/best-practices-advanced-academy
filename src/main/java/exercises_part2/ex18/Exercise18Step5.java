package exercises_part2.ex18;
import java.util.Stack;

public class Exercise18Step5 {
    public static class History {
        private Stack<Exercise18Step3.Memento> history = new Stack<>();
        
        public void push(Exercise18Step3.Memento m) { history.push(m); }
        
        public Exercise18Step3.Memento pop() { 
            if(!history.isEmpty()) return history.pop();
            return null;
        }
    }
}