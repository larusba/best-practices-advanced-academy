package designpattern.template;

/**
 * ESEMPIO TEORICO: Gerarchia e Flessibilità.
 *
 * Mostra come il Template Method possa coordinare una gerarchia di classi.
 * - Generalization: Definisce l'algoritmo principale.
 * - Specialization: Implementa parzialmente l'algoritmo (scomponendo un passo).
 * - Realization: Fornisce i dettagli finali.
 */
public class Main {
    
    public static class TemplateMethodDemo {
        public static void main(String[] args) {
            Generalization algorithm = new Realization();
            // Il client chiama solo il metodo pubblico "Template".
            // Non sa quali passi specifici verranno eseguiti dietro le quinte.
            algorithm.findSolution();
        }
    }
    
    abstract static class Generalization {
        /**
         * COMPONENT: Template Method.
         * Definisce la sequenza (lo scheletro) dell'algoritmo.
         * Solitamente dichiarato 'final' per impedire alle sottoclassi di cambiare l'ordine.
         */
        void findSolution() {
            stepOne(); // Parte Invariante (Private)
            stepTwo(); // Parte Variabile (Abstract)
            stepThr(); // Parte Variabile (Abstract)
            stepFor(); // Hook (Concrete, opzionale)
        }
        
        // 2. COMMON implementations: Parte fissa, uguale per tutti.
        private void stepOne() {
            System.out.println("Generalization.stepOne");
        }

        /** Parte che DEVE essere implementata dalle sottoclassi. */
        abstract void stepTwo();

        abstract void stepThr();

        /** * HOOK (Gancio).
         * Un metodo concreto con un'implementazione di default (spesso vuota).
         * Le sottoclassi possono scegliere se farne l'override o tenersi il default.
         */
        void stepFor() {
            System.out.println("Generalization.stepFor");
        }
    }

    /**
     * Intermediario.
     * Implementa un passo astratto (stepThr) ma ne lascia altri aperti.
     */
    abstract static class Specialization extends Generalization {
        
        // Qui 'Specialization' decide che 'stepThr' è troppo complesso,
        // quindi lo trasforma in un mini-template a sé stante.
        protected void stepThr() {
            step3_1();
            step3_2();
            step3_3();
        }

        private void step3_1() {
            System.out.println("Specialization.step3_1");
        }
        
        // Questo pezzetto è ancora lasciato alla classe concreta finale.
        protected abstract void step3_2();

        private void step3_3() {
            System.out.println("Specialization.step3_3");
        }
    }

    static class Realization extends Specialization {
        // Implementazione finale del passo obbligatorio definito in Generalization
        protected void stepTwo() {
            System.out.println("Realization.stepTwo");
        }

        // Implementazione finale del sotto-passo definito in Specialization
        protected void step3_2() {
            System.out.println("Realization.step3_2");
        }

        /**
         * Override dell'HOOK.
         * Qui decidiamo di estendere il comportamento base invece di sostituirlo completamente,
         * usando super.stepFor().
         */
        protected void stepFor() {
            System.out.println("Realization.stepFor");
            super.stepFor();
        }
    }
}