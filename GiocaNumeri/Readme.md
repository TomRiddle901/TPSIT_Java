# GiocaNumeri - Applicazione Multithreading in Java

Progetto scolastico che illustra la gestione del multithreading in Java attraverso la simulazione di un gioco a punteggio eseguito da più giocatori in parallelo.

---

## Descrizione del Progetto

L'applicazione simula l'esecuzione concorrente di due giocatori (`g1` e `g2`). Ogni giocatore è rappresentato da un thread indipendente che effettua un conteggio numerico a intervalli regolari, cede periodicamente il controllo della CPU e, al termine, comunica il proprio punteggio finale e una frase associata.

---

## Struttura del Codice

Il progetto fa parte del pacchetto `tpsit.giocanumeri` ed è composto da due classi principali:

### 1. `GiocaNumeri` (Main Class)
Coordina l'esecuzione generale e gestisce la sequenza temporale di avvio e sincronizzazione dei thread:
* **Inizio**: Stampa a schermo l'avvio del gioco.
* **Avvio `g1`**: Istanzia e avvia il thread per il primo giocatore ("Tommaso").
* **Pausa nel Main**: Mette in pausa il thread principale (`main`) per 5 secondi (5000 ms).
* **Avvio `g2`**: Istanzia e avvia il thread per il secondo giocatore ("Alessandro").
* **Sincronizzazione `join()`**: Sospende il thread principale in attesa che `g1` completi la sua esecuzione.
* **Chiusura**: Stampa il messaggio di fine gioco.

### 2. `Giocatore` (Estende `java.lang.Thread`)
Rappresenta il thread dedicato a ciascun giocatore:
* **Attributi**:
  * `nome` (`String`): Nome del giocatore.
  * `parola` (`String`): Parola chiave associata (impostata su `"Buongiorno"` durante il gioco).
  * `punteggio` (`int`): Punteggio finale totalizzato.
* **Metodi principali**:
  * `run()`: Metodo sovrascritto dalla classe `Thread`. Viene eseguito all'avvio del thread e invoca in ordine `gioca()` e `comunica()`.
  * `gioca()`: Esegue un ciclo da 0 a 18. Ad ogni passo stampa l'avanzamento, attende 2 secondi (`sleep(2000)`), cede volontariamente la CPU tramite `yield()` e infine assegna il punteggio finale.
  * `comunica()`: Stampa a console il nome del giocatore, il punteggio ottenuto e la parola scelta.

---

## Flusso di Esecuzione dei Thread

| Fase | Thread `main` | Thread `g1` (Tommaso) | Thread `g2` (Alessandro) |
| :--- | :--- | :--- | :--- |
| **1** | Esegue `g1.start()` | Passa in stato *Runnable* e avvia `gioca()` | Non ancora creato |
| **2** | Entra in `sleep(5000)` | Prosegue il conteggio (circa 2-3 cicli) | Non ancora creato |
| **3** | Si risveglia e avvia `g2` | Continua la sua esecuzione | Passa in stato *Runnable* e avvia `gioca()` |
| **4** | Invoca `g1.join()` (in attesa) | Completa i suoi 19 cicli e termina | Esegue in parallelo a `g1` |
| **5** | Si sblocca dopo `g1` e termina | Stato *Terminated* | Continua in autonomia fino a fine ciclo |

---

## Concetti di Multithreading Utilizzati

1. **Estensione della classe `Thread`**: Sovrascrittura del metodo `run()` per definire le operazioni svolte in parallelo.
2. **Differenza tra `start()` e `run()`**: L'uso di `start()` crea un nuovo stack di memoria ed esegue il thread in modo asincrono.
3. **`Thread.sleep(ms)`**: Sospende temporaneamente l'esecuzione del thread portandolo nello stato di *Timed Waiting*.
4. **`Thread.yield()`**: Suggerisce allo scheduler di sistema di concedere l'uso della CPU ad altri thread con pari priorità.
5. **`join()`**: Sincronizza il thread chiamante (`main`) con il thread bersaglio (`g1`), bloccando il `main` fino alla conclusione di `g1`.

---

## Come Compilare ed Eseguire

Posizionandosi nella cartella principale del progetto da terminale:

```bash
# Compilazione
javac -d . GiocaNumeri.java Giocatore.java

# Esecuzione
java tpsit.giocanumeri.GiocaNumeri
```