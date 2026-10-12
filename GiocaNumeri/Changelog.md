# Changelog

Tutte le modifiche rilevanti a questo progetto saranno documentate in questo file.

---

## [1.0.0]

### Aggiunto
- Sincronizzazione della CPU tramite il metodo `yield()` all'interno del ciclo di gioco nella classe `Giocatore`
- Gestione del coordinamento per consentire l'esecuzione alternata dei thread `g1` e `g2` prima del termine del `main`

### Documentazione
- Studio e analisi della documentazione ufficiale Oracle relativa al funzionamento e all'uso del metodo `yield()`.

## [0.3.0]

### Aggiunto
- Implementazione del metodo `join()` nella classe `GiocaNumeri` per sincronizzare i thread del main con il completamento di `g1`
- Gestione della logica di esecuzione concorrente: `main` -> `g1` e `g2` in parallelo `main`

### Documentazione
- Studiata la documentazione ufficiale Oracle sul funzionamento del metodo `join()`

## [0.2.0]

### Aggiunto
- Inserimento di una sospensione di 5s (`Thread.sleep(5000)`) nel thread `main` subito dopo l'avvio del primo thread (`g1`)
- Inserimento di una sospensioni di 2s (`Thread.sleep(2000)`) all'interno del metodo `gioca()` nella classe `Giocatore`

### Documentazione
- Studiata la documentazione ufficiale Oracle sul funzionamento del metodo `sleep()`
- Esecuzione del codice e analisi del'ordine di esecuzione dei thread

## [0.1.0]

### Aggiunto
- Creazione della struttura iniziale del progetto multithreading con le classi `GiocaNumeri` e `Giocatore`

### Documentazione
- Inserimento delle descrizioni e dei commenti JavaDoc per le classi e metodi
- Studio della logia di funzione dei thread tramite documentazione
- Prime osservazione dell'output da console per la comprensione del ciclo di vita dei thread