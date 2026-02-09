package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 🛠️ Esercizio 1: String Calculator
 *
 * Obiettivo: Implementare una calcolatrice che accetta una stringa e restituisce la somma dei numeri.
 *
 * REQUISITI (Da implementare uno alla volta con TDD):
 *
 * 1. Il metodo accetta una stringa "numbers" e ritorna un int.
 * 2. Input "" (stringa vuota) ==> Ritorna 0.
 * 3. Input "1" (singolo numero) ==> Ritorna 1.
 * 4. Input "1,2" (due numeri) ==> Ritorna 3.
 * 5. Input "1,2,3,4" (n numeri) ==> Ritorna somma (10).
 * 6. Input "1\n2,3" (accetta \n come separatore) ==> Ritorna 6.
 *
 * REQUISITI IPOTETICI RICHIESTI IN SEGUITO:
 * A. Input "1,-2" (negativi) ==> Lancia IllegalArgumentException("Negativi non ammessi: -2").
 * B. Input "2,1001" (numeri > 1000) ==> Ignora i numeri > 1000 (Ritorna 2).
 */
public class StringCalculatorTest {
}
