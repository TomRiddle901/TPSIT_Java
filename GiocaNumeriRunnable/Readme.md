# Gioca Numeri - Multithreading con `Runnable` in Java


Progetto scolastico che mostra come eseguire attività in parallelo in Java utilizzando l'interfaccia `Runnable` e la
classe `Thread`.
L'applicazione simula due giocatori che contano contemporaneamente, comunicano il proprio punteggio finale e mostrano
alcune informazioni sui thread utilizzati.

---

## Descrizione del progetto

Il programma crea due giocatori (`Giocatore 1` e `Giocatore 2`). Ogni giocatore è un oggetto della classe `Giocatore`,
che implementa `Runnable`; per eseguire il suo codice in un thread separato, l'oggetto viene passato al costruttore di
un oggetto `Thread`.

Ogni giocatore stampa i numeri da `0` a `18`, aspettando due secondi dopo ogni numero. Al termine del conteggio riceve
un punteggio di `100` punti e comunica il risultato insieme alla parola associata, `Runnable!`.

---

## Struttura del progetto

Il progetto appartiene al package `tpsit.giocanumeri.runnable` ed è composto da due classi principali.

### `Gioca Numeri` - Main Class

Coordina l'avvio dei thread e misura il tempo di esecuzione complessivo del programma.

- **Misurazione iniziale:** registra il tempo di inizio con `System.currentTimeMillis()`.
- **Creazione dei giocatori:** crea gli oggetti `g1` e `g2`.
- **Creazione dei thread:** costruisce `g1Thread` e `g2Thread`, passando a ciascuno il relativo oggetto `Runnable`.
- **Avvio:** avvia il primo thread, attende brevemente e avvia il secondo. Queste piccole pause cercano di distanziare
leggermente gli avvii, ma non garantiscono un ordine preciso delle stampe.
- **Sincronizzazione:** usa `join()` su entrambi i thread, in modo che il thread principale aspetti la conclusione di
tutti e due i giocatori.
- **Riepilogo:** mostra ID, nome, priorità e stato dei thread e stampa il tempo complessivo trascorso.

Il metodo `getInfoThread(Thread thread)` centralizza la stampa delle informazioni di un thread.

### `Giocatore` - Implements `Runnable`

Questa classe contiene i dati e le operazioni eseguite da ogni giocatore. Implementa `Runnable` e quindi definisce il
metodo `run()`.

**Attributi principali:**

- `nome` (`String`): identifica il giocatore.
- `parola` (`String`): parola comunicata alla fine della partita, impostata su `"Runnable!"`.
- `punteggio` (`int`): punteggio finale, impostato a `100` dopo il conteggio.
- `tempoInizio` (`long`): istante in cui viene creato l'oggetto `Giocatore`, usato per calcolare il tempo trascorso
prima della comunicazione finale.

**Metodi principali:**

- `run()`: punto d'ingresso del lavoro del giocatore; richiama `gioca()` e poi `comunica()`.
- `gioca()`: stampa le informazioni del thread corrente, conta da `0` a `18` e attende due secondi a ogni iterazione.
Al termine imposta il punteggio a `100`.
- `comunica()`: visualizza nome, punteggio e parola scelta, oltre al tempo trascorso dalla creazione dell'oggetto giocatore.
- `getDettagli()`: mostra ID, nome, priorità e stato del thread che sta eseguendo il giocatore.
- `setPunteggio(int punti)`: assegna il punteggio finale.

## Esecuzione

| Fase | Thread `main`                                                                                     | Thread del Giocatore 1              | Thread del Giocatore 2              |
|------|---------------------------------------------------------------------------------------------------|-------------------------------------|-------------------------------------|
| 1    | Registra il tempo iniziale e crea i giocatori e i thread                                          | Non ancora avviato                  | Non ancora avviato                  |
| 2    | Mostra le proprie informazioni e avvia `g1Thread`                                                 | Inizia `run()` e avvia il conteggio | Non ancora avviato                  |
| 3    | Attende brevemente e avvia `g2Thread`                                                             | Continua il conteggio               | Inizia `run()` e avvia il conteggio |
| 4    | Esegue `g1Thread.join()` e attende                                                                | Continua fino al completamento      | Esegue il conteggio in parallelo    |
| 5    | Dopo la fine di `g1Thread`, esegue `g2Thread.join()` se necessario e attende il secondo giocatore | Termina                             | Continua fino al completamento      |
| 6    | Stampa le informazioni finali e il tempo complessivo                                              | Stato `TERMINATED`                  | Stato `TERMINATED`                  |

I due conteggi si svolgono in concorrenza: le righe stampate dai giocatori possono quindi alternarsi in modo diverso a
ogni esecuzione. `sleep()` introduce una pausa nel thread che lo invoca, senza bloccare gli altri thread.

## Concetti di multithreading utilizzati

1. **`Runnable`:** definisce il lavoro da eseguire tramite il metodo `run()`, separando la logica del giocatore dal
thread che la esegue.
2. **`Thread`:** rappresenta il thread effettivo. Nel costruttore riceve un oggetto `Runnable`.
3. **`start()` e `run()`:** `start()` avvia un nuovo thread e fa sì che la JVM esegua il suo metodo `run()`.
Chiamare direttamente `run()` non avvia un nuovo thread: il metodo verrebbe eseguito nel thread chiamante.
4. **`Thread.sleep(ms)`:** sospende temporaneamente il thread corrente. In questo progetto ogni giocatore attende `2000`
millisecondi dopo ciascun numero.
5. **`join()`:** fa attendere il thread chiamante finché il thread indicato non termina. Il programma usa `join()`
per non stampare il riepilogo finale prima della conclusione dei giocatori.
6. **`Thread.currentThread()`:** restituisce il thread che sta eseguendo il codice in quel momento.
7. **`threadId()`, `getName()`, `getPriority()` e `getState()`:** permettono di visualizzare informazioni sul thread.
8. **Misurazione del tempo:** `System.currentTimeMillis()` viene utilizzato per calcolare il tempo complessivo del
programma e quello trascorso prima della comunicazione di ciascun giocatore.

## Tempi indicativi

Ogni giocatore esegue 19 iterazioni e attende due secondi a ogni iterazione: il conteggio richiede quindi circa **38
secondi per giocatore**. Poiché i due thread lavorano in parallelo, la durata totale del programma dovrebbe essere
vicina a quella di un singolo conteggio, non alla somma dei due. Il tempo effettivo può variare in base al sistema e
alla pianificazione dei thread.

> Nota: il valore chiamato `Tempo di esecuzione del Thread` nel messaggio del giocatore è calcolato a partire dalla
> creazione dell'oggetto `Giocatore`, non dall'istante esatto in cui viene avviato il thread.

## Requisiti

- **JDK 25 o successivo**, perché il metodo di avvio è dichiarato `static void main()` senza parametri,
forma supportata dalle nuove regole di avvio introdotte in Java 25 ([documentazione ufficiale Oracle](https://docs.oracle.com/en/java/javase/25/language/compact-source-files-instance-main-methods.html)).
- Un terminale oppure un IDE Java, ad esempio IntelliJ IDEA, Eclipse o NetBeans.

Per controllare la versione installata:

```bash
java -version
javac -version
```