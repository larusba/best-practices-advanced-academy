
# SmartCity Traffic System

Un sistema di gestione del traffico intelligente sviluppato seguendo **Clean Architecture** e **Design Patterns**.

## Funzionalità

1. **CRUD Sensori:** Gestione registro sensori (Camera, Inquinamento, Semafori).
2. **Analisi Segnali:** Elaborazione real-time dei dati di traffico.
3. **Gestione Emergenze:** Priorità ai mezzi di soccorso.

## Architettura

* **Controller:** Gestisce HTTP e DTO.
* **Service:** Orchestratore.
* **Repository:** Accesso ai dati (In-Memory per demo).
* **Patterns:**
* *Strategy:* Per algoritmi di analisi diversi per sensore.
* *Observer:* Per notifiche asincrone (Polizia).
* *Factory:* Per istanziare la strategia corretta.



## Esecuzione Test

Esegui `mvn test` per vedere TDD e Unit Test in azione.
