package exercises;

/**
 * Sono state introdotte delle costanti per eliminare i "Magic Numbers" e dare un nome ai valori.
 * La logica condizionale complessa è stata estratta in un metodo di supporto (**Extract Method**) per chiarire l'intento di business.
 */
public class Exercise9After {

    private static final int TYPE_STANDARD = 1;
    private static final int TYPE_SILVER = 2;
    private static final int TYPE_GOLD = 3;

    private static final double DISCOUNT_STANDARD = 0.90;
    private static final double DISCOUNT_SILVER = 0.85;
    private static final double DISCOUNT_GOLD = 0.70;

    private static final double LOYALTY_BONUS = 5.0;

    public double calculatePrice(double amount, int type, int years) {
        double discountedAmount = applyTypeDiscount(amount, type);

        if (isEligibleForLoyaltyBonus(type, years)) {
            discountedAmount -= LOYALTY_BONUS;
        }

        return discountedAmount;
    }

    private double applyTypeDiscount(double amount, int type) {
        return switch (type) {
            case TYPE_STANDARD -> amount * DISCOUNT_STANDARD;
            case TYPE_SILVER -> amount * DISCOUNT_SILVER;
            case TYPE_GOLD -> amount * DISCOUNT_GOLD;
            default -> amount;
        };
    }

    private boolean isEligibleForLoyaltyBonus(int type, int years) {
        return years > 5 && (type == TYPE_SILVER || type == TYPE_GOLD);
    }
}