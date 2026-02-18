package exercises_part2.ex8;

import java.util.List;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Type Checking:** Uso massiccio di `instanceof` per distinguere prodotti singoli da menu.
 * 2. **Rigidità:** Se aggiungo un nuovo tipo di raggruppamento, devo modificare la logica di calcolo del prezzo.
 * 
 * FEATURE FUTURA:
 * - Aggiungere un Menu speciale che applica uno sconto automatico ai suoi elementi.
 */
public class Exercise8Step1 {
    public static class Calculator {
        public double calculatePrice(Object item) {
            if (item instanceof Product) {
                return ((Product) item).price;
            } else if (item instanceof Menu) {
                double sum = 0;
                for (Object child : ((Menu) item).items) {
                    sum += calculatePrice(child); // Ricorsione manuale sporca
                }
                return sum;
            }
            return 0;
        }
    }

    static class Product {
        double price;
    }

    static class Menu {
        List<Object> items;
    }
}