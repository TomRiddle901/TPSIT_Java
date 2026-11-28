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

---

## Architetturadel progetto

Il codice sorgente è organizzato nel package `tpsit.giocanumeri.secure` ed è accompagnato dal diagramma delle classi UML [GiocaNumeriSecure](GiocaNumeriSecure.ncp).

* **[`GiocaNumeri.java`](src/main/java/tpsit/giocanumeri/secure/GiocaNumeri.java)**: Classe principale (`main`). Istanzia gli oggetti condivisi (`Cifrario`, `MonitorTastiera`, `GestoreFile`), acquisisce i dati per creare $N$ giocatori, convalida i parametri inseriti e avvia i rispettivi thread misurando il tempo complessivo di esecuione
* **[`Giocatore.java`](src/main/java/tpsit/giocanumeri/secure/Giocatore.java)**: Estende `Thread`. Alla creazione cifra la parola segreta tramite `Cifrario`; durante l'esecuzione (`run()`), stampa i dettagli del thread, esegue il contaggio (`gioca()`), assegna il punteggio, salva i dati su file e consente al'utente di decifrare la `keyword` corretta (`comunica()`)
* **[`Cifrario.java`](src/main/java/tpsit/giocanumeri/secure/Cifrario.java)**: Implmenta gli algoritmi `cifra()` e `decifra()` basati sul cifrario di Vigenère e il metodo `convalidaParametri()` per verificare che la parola e chiave contengano solo caratteri alfabetici
* **[`MonitorTastiera.java`](src/main/java/tpsit/giocanumeri/secure/MonitorTastiera.java)**: Classe *Monitor* che espone il metodo `synchronized inputTastiera(String messaggio)` per garantire la mutua esclusione durante la lettura da standard input (`System.in`) da parte di più thread concorrenti
* **[`GestoreFile.java`](src/main/java/tpsit/giocanumeri/secure/GetoreFile.java)**: Gestisce la persistenza dei dati del singolo giocatore tramite metodo `synchronized salva(Giocatore)`, generando un file nominato `<idGiocatore> - gioco del <data gg M yyyy>.txt` all'interno della directory `GiocaNumeriSecure/`

---

## Struttura del file di output

Al termine della fase di gioco di ciascun thread, viene creato un file di testo contenente:

```text
Numero: 20
Punteggio: 100
Parola Cifrata: <TESTO_CIFRATO>
```

---

## Gestione delle eccezioni

* **Eccezioni controllate**:
  * `IOException`: catturata in `MonitorTastiera.inputTastiera()` durante la lettura da `BufferedReader` e in `GetoreFile.salva()` durante apertura, scrittura e chiusura del `BufferedWriter`
  * `Exception`: sollevata da `Cifrario.convalidaParametri()` (con messaggi concatenati se sia la parola che la keyword non sono valide) e da `GiocaNumeri.lanciaGioco()` in caso di errore in fase di acquisizione input
* **Eccezioni non controllate**:
  * `NullPointerException`: catturata esplicitamente nel blocco `finally` di `GetoreFile.salva()` qualora `bufferedWriter.close()` venga invocato su un riferimento `null` a seguito di un errore precedente in apertura del file

---

## Prerequisiti di esecuzione

1. **Ambiente**: `JDK 21+` (il progetto utilizza `Thread.currentThread().threadId()` e instance main method `static void main()`)

2. **Directory di salvataggio**: Assicurarsi che nella root di esecuzione sia presente la cartella `GiocaNumeriSecure/` affinché `FileWriter` possa creare correttamente i file `.txt`

3. **Avvio**: Compilare ed eseguire la classe `tpsit.giocanumeri.secure.GiocaNumeri`, seguire le istruzioni a schermo per inserire i giocatori e, al termine del conteggio di ciascun thread, digitare la keyword per visualizzare la parola decifrata (oppure lasciare vuoto per mostrarla cifrata)