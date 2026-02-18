package exercises_part2.ex18;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Violazione Incapsulamento:** Per salvare lo stato, il client deve accedere ai campi privati o copiarli manualmente.
 * 2. **Fragilità:** Se aggiungo campi all'Editor, devo aggiornare la logica di salvataggio ovunque.
 */
public class Exercise18Step1 {
    public static class Editor {
        public String content; // Public per permettere il salvataggio esterno (male!)
    }
}