package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Esempio del Design Pattern Prototype.
 *
 * Questo pattern è utilizzato quando la creazione di una nuova istanza di un oggetto
 * è un'operazione costosa (in termini di tempo o risorse), ad esempio se richiede
 * query al database, chiamate API o parsing di file complessi.
 *
 * Invece di creare l'oggetto da zero (new) e ricaricare i dati, il pattern suggerisce
 * di copiare (clonare) un oggetto esistente già inizializzato.
 */
public class Main {

    /**
     * Classe "Prototype" Concreta.
     * Implementa l'interfaccia Cloneable di Java per segnalare che supporta la copia.
     */
    public static class Employees implements Cloneable {

        private final List<String> empList;

        public Employees() {
            empList = new ArrayList<>();
        }

        public Employees(List<String> list) {
            this.empList = list;
        }

        /**
         * Simula un'operazione costosa (es. Fetch da DB o REST API).
         * Nel pattern Prototype, l'obiettivo è eseguire questo metodo
         * una volta sola per l'oggetto originale e mai per i cloni.
         */
        public void loadData() {
            empList.add("Pankaj");
            empList.add("Raj");
            empList.add("David");
            empList.add("Lisa");
        }

        /**
         * Ritorna la lista dei dipendenti.
         */
        public List<String> getEmpList() {
            return empList;
        }

        /**
         * Metodo core del pattern: Logica di Clonazione.
         *
         * Qui viene effettuata una DEEP COPY (copia profonda) della lista.
         *
         * Dettaglio didattico importante:
         * - Se facessimo 'return this', restituiremmo lo stesso riferimento (nessuna copia).
         * - Se facessimo 'new Employees(this.empList)', i due oggetti condividerebbero
         * la stessa lista in memoria. Modificare il clone modificherebbe l'originale.
         * - Facendo 'new ArrayList<>(this.getEmpList())', creiamo una nuova lista indipendente
         * con gli stessi dati. Questo permette ai cloni di evolvere separatamente.
         *
         * @return Una nuova istanza di Employees con i dati copiati ma indipendenti.
         */
        @Override
        public Object clone() {
            List<String> temp = new ArrayList<>(this.getEmpList());
            return new Employees(temp);
        }
    }

    public static void main(String[] args) {
        // 1. Creazione dell'oggetto originale e caricamento costoso dei dati (DB)
        Employees emps = new Employees();
        emps.loadData();

        // 2. Creazione dei cloni.
        // Nota: Qui NON stiamo chiamando 'new' né 'loadData()'.
        // Stiamo ottenendo copie istantanee dello stato attuale di 'emps'.
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        
        // 3. Modifica dei cloni.
        // Dimostrazione che la modifica su un clone non intacca gli altri o l'originale.
        List<String> list = empsNew.getEmpList();
        list.add("John"); // Aggiunto solo al primo clone
        
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj"); // Rimosso solo dal secondo clone

        // Verifica dell'indipendenza delle istanze
        System.out.println("emps List (Originale): " + emps.getEmpList());
        System.out.println("empsNew List (Clone 1 + John): " + list);
        System.out.println("empsNew1 List (Clone 2 - Pankaj): " + list1);
    }
}