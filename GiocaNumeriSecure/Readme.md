# GiocaNumeriSecure

Appliczione Java Multithreading sviluppata per l'esercitazione di **TPSIT** che estende il progetto `GiocaNumeri` introducendo la programazione concorrente sicura tramite (tramite classi monitor), crittografia classica (**Cifrario di Vigenère**), scrittura sul file di testo e gestione strutturata delle eccezioni controllate e non controllate

---

## Requisiti della consegna e soluzioni adattate
| Requisito | Implementazione nel progetto |
| :--- | :--- |
| **Multithreading e sincronizzazione** | Ogni giocatore è gestito da un `Thread` (`Giocatore`). L'accesso concorrente a `System.in` e alla scrittura su disco è sincronizzato tramite metodi `synchronized` nelle classi `MonitorTastiera` e `GestoreFile`|
| **Input da tastiera**| Gestito centralmente da `BufferedReader` incapsulato nella classe `MonitorTastiera` per evitare sovrapposizioni tra thread|
| **Crittografia della parola** | Implementato il **Cifrario di Vigenère** nella classe `Cifrario` con convalida tramite RexEx (Regular Expression)|
| **Salvataggio su file prima dell'output** | Nel metodo `comunica()` di `Giocatore` il salvataggio tramite `GestoreFile.salva(this)` viene eseguito prima di richiedere la keyword e stampare i risultati a video|
| **Gestione delle eccezioni** | Gestione di eccezioni **controllate** (`IOException`, `Exception` personalizzate per validazione e I/O) e **non controllate** (`NullPointerException` alla chiusura di `BufferedWriter`)|