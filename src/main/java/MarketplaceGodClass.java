import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketplaceGodClass {

    // Database in memoria (non thread-safe)
    public static Map<String, Double> productPrices = new HashMap<>();
    public static Map<String, Integer> productStock = new HashMap<>();
    public static List<String> orders = new ArrayList<>();

    static {
        productPrices.put("IPHONE_15", 1200.00);
        productStock.put("IPHONE_15", 10);
        productPrices.put("COVER", 20.00);
        productStock.put("COVER", 50);
    }

    /**
     * Metodo di 200 righe che gestisce l'intero checkout.
     * Parametri confusi, tipi primitivi, nessuna gestione errori strutturata.
     */
    public String checkout(String userId, String itemsStr, String paymentType, String voucher, boolean isPrime) {
        System.out.println("Processing checkout for user: " + userId);

        double total = 0;
        String[] items = itemsStr.split(","); // Parsing manuale fragile

        // 1. Calcolo Prezzi e check stock (Logic coupling)
        for (String item : items) {
            if (!productStock.containsKey(item) || productStock.get(item) <= 0) {
                return "ERROR: Out of stock " + item;
            }
            total += productPrices.get(item);
        }

        // 2. Logica Sconti (Hardcoded - Violazione OCP)
        if (isPrime) {
            total = total * 0.90; // Sconto Prime
        }
        if (voucher != null && voucher.equals("SUMMER2024")) {
            total -= 10.0;
        } else if (voucher != null && voucher.equals("WELCOME")) {
            total -= 5.0;
        }

        // 3. Logica Pagamenti (Switch Hell)
        if (paymentType.equals("PAYPAL")) {
            // Simulazione chiamata API esterna brutale
            System.out.println("Connecting to PayPal API...");
            // if (apiCallFails) return "Payment Error";
        } else if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Connecting to Visa API...");
        } else {
            return "ERROR: Payment not supported";
        }

        // 4. Aggiornamento Stock (Non transazionale)
        for (String item : items) {
            int current = productStock.get(item);
            productStock.put(item, current - 1);
        }

        // 5. Notifiche (Tight Coupling)
        System.out.println("Sending EMAIL to " + userId);
        if (paymentType.equals("PAYPAL")) {
            System.out.println("Sending SMS to " + userId);
        }

        String orderId = "ORD-" + System.currentTimeMillis();
        orders.add(orderId + "|" + total);

        return "SUCCESS:" + orderId + ":" + total;
    }
}
