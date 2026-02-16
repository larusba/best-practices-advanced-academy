package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static exercises.PasswordValidator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 🛠️ Esercizio 2: Password Validator
 *
 * Obiettivo: Creare un validatore di password sicuro.
 *
 * REQUISITI (Da implementare uno alla volta):
 *
 * 1. Lunghezza minima: almeno 8 caratteri.
 * 2. Deve contenere almeno un numero.
 * 3. Deve contenere almeno una lettera maiuscola.
 * 4. Deve contenere almeno un carattere speciale (es. @, #, !).
 *
 * EDGE CASES:
 * A. Input null ==> Ritorna lista con "empty password" (o gestisce l'errore).
 * B. Input con spazi vuoti ==> Ritorna lista con "empty password".
 * 
 * CAMBIAMENTO IPOTETICO DEI REQUISITI RICHIESTO IN SEGUITO:
 * C. Cambiare la firma del metodo per ritornare un boolean invece di una List<String> di errori.
 */
public class PasswordValidatorTest {
    PasswordValidator validator;
    
    @BeforeEach
    void beforeEach() {
        validator = new PasswordValidator();
    }
    
    @Test
    void testPasswordAtLeast8Charachters() {
        boolean validate = validator.validate("A12313!");
        assertEquals(false, validate);
//        assertEquals(List.of(PASSWORD_TOO_SHORT), validate);
    }

    @Test
    void testPasswordAtLeastOneNumber() {
        boolean validate = validator.validate("Aasdasdasd!");
        assertEquals(false, validate);
//        assertEquals(List.of(AT_LEAST_ONE_NUMBER), validate);
    }

    @Test
    void testPasswordAtLeastOneUppercaseLetter() {
        boolean validate = validator.validate("sdasdasd1!");
        assertEquals(false, validate);
//        assertEquals(List.of(AT_LEAST_ONE_UPPERCASE), validate);
    }

    @Test
    void testPasswordAtLeastOneSpecialChar() {
        boolean validate = validator.validate("Asdasdasd1");
        assertEquals(false, validate);
//        assertEquals(List.of(AT_LEAST_ONE_SPECIAL_CHAR), validate);
    }
    
    @Test
    void testPasswordWithNull() {
        boolean validate = validator.validate(null);
        assertEquals(false, validate);
//        assertEquals(List.of(EMPTY_PASSWORD), validate);
    }
    
    @Test
    void testPasswordWithEmptyString() {
        boolean validate = validator.validate("");
        assertEquals(false, validate);
//        assertEquals(List.of(EMPTY_PASSWORD), validate);
    }

    @Test
    void testValidPassword() {
        boolean validate = validator.validate("Asdasdasd1!");
        assertEquals(true, validate);
//        assertEquals(List.of(), validate);
    }
}
