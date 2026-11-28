# Changelog

Tutte le modifiche rilevanti a questo progetto saranno documentate in questo file.

---

## {1.0.0} 28-11-2026
### Aggiunto
- `Giocatore`: Puntatore alla classe `GestoreFile`
- `GiocaNumeri`: crea l'oggetto `GestoreFile` e passa il puntatore alla classe `Giocatore`
- `GestoreFile`: chiusura del buffer di scrittura

### Aggiornato
- `Giocatore`: il metodo `comunica()` salva il file prima di comunicare il risultato
- `GestoreFile`, `Giocatore`, `GiocaNumeri`: JavaDoc

### Rimosso
- `GestoreFile`: il costruttore ora è senza parametri perché erano ridondanti
- `GestoreFile`: tutti gli attributi tranne il dateTimeFormatter

## {0.1.9} 28-11-2026
### Aggiunto
- `GestoreFile`: aggiunta cattura della data corrente e formattata in `gg M yyyy`
- `GestoreFile`: aggiunto il metodo `salva()` per salvare le informazioni del giocatore
- `Giocatore`: aggiunto `getNumero()` che restituisce il numero che deve raggiungere il giocatore
- `Giocatore`: aggiunto `getPunteggio` che restituisce il puteggio del giocatore
- `GestoreFile`: JavaDoc

### Aggiornato:
- `Giocatore`: il numero che deve arrivare il giocatore ora è un attributo
- `Giocatore`: JavaDoc

### Fixed:
- `Giocatore`: aggiunti modificatori di accesso per `idGiocatore` e `numero`

### Documentazione
- [StackOverlow: How to format a `LocalDate` variable as a `String`](https://stackoverflow.com/questions/28177370/how-can-i-format-a-localdate-variable-as-a-string)

### Todo
- Salvataggio su file dei dati dei giocatori quando finiscono di giocare, prima di comunicare il risultato all'utente
- *Migliorare la stampa per richiedere la keyword*

## {0.1.8} 16/11/2026
### Aggiunto
- `MonitorTastiera`: parametro `messaggio` per visualizzare un messaggio personalizzato prima dell'input da tastiera
- `GiocaNumeri`: eccezione personalizzata nel caso si rilevano errori nella classe `MonitorTastiera`

### Aggiornato
- `Giocatore`: La classe `MonitorTastiera` è un puntatore all'oggetto creato dal `GiocaNumeri` così si gestisce il semaforo
- `GiocaNumeri`: crea gli oggetti `Cifrario` e `MonitorTastiera` condivisi tra i vari thread con in puntatori
- JavaDoc del progetto

### Fixed
- `GiocaNumeri`: l'oggetto cifrario non si crea più volte nel while ma si crea 1 volta valido per tutti i thread

### Rimosso
- Utilizzo di `BufferedReader` in `GiocaNumeri`, ora l'input da tastiera viene completamente gestito dalla classe monitor
- `Giocatore`: creazione della classe `MonitorTastiera`, ora utilizza il puntatore
- `GiocaNumeri`: rimossa stampa dei messaggi prima dell'input, lo fa la classe monitor tastiera

### Documentazione
- Materiale del docente di TPSIT

### Todo
- *Scelta personalizzata del'utente del numero che deve raggiungere il giocatore (input tramite classe Giocatore)*
- Salvataggio su file dei dati dei giocatori quando finiscono di giocare, prima di comunicare il risultato all'utente
- *Migliorare la stampa per richiedere la keyword*

## {0.1.7} 16/11/2026
### Aggiornato
- `Giocatore`: il costruttorre ha come parametro il puntatore alla classe `Cifrario` 
- `GiocaNumeri`: l'oggetto cifrario viene creato dal thread princiaple e viene passato il puntatore alla classe `Giocatore`
- Diagramma UML

### Rimosso
- Metodi static all'interno del cifrario
- Metodi e attributi statci all'interno della classe monitor

## {0.1.6} 16/11/2026
### Aggiunto
- Classe monitor `MonitorTastiera` per controllare l'input da tastiera durante il multithreading per evitare sovrapposizioni
- `MonitorTastiera`: metodo che restituisce l'input della tastiera

### Aggiornato
- `Giocatore`: rimosso try catch e aggiunta classemonitor dell' input da testiera

## {0.1.5} 15/11/2026
### Aggiunto
- `Cifrario`: metodo `convalidaParametri()` per convalidare i parametri che non sono vuoti o caratteri non ammessi

### Fixed
- Metodo `cifra()`: corretto il calcolo dello spostamento del carattere
- Metodo `decifra()`: corretto calcolo dello spostamento con una sottrazione e aggiunta somma di 26 per non far restituire numeri negativi

### Aggornato
- JavaDoc della classe `Cifrario`

### Rimosso
- `GiocaNumeri`: condizione che restituiva un Exception inutile sulla convalida dell'input della scelta
- `GiocaNumeri`: ciclo dopo il catch del metodo `lanciaGioco()` perché se i parametri non sono validi non si crea l'oggetto
- `GiocaNumeri`: rimosso il vecchio codice commentato

### Documentazione
- [Cifrario di Vigenére in Java](https://www.baeldung.com/java-vigenere-cipher)
- [Cifrario di Vigenére in Java (StackOverflow)](https://stackoverflow.com/questions/28737300/confused-about-vigenère-cipher-implementation-in-java)
- [Tabella dei caratteri ASCII](https://www.brescianet.com/appunti/vari/tabellaascii/ascii.htm)
- [ArrayList explicit type argument](https://stackoverflow.com/questions/43018802/arraylist-explicit-type-argument-string-can-be-replaced-with)

## {0.1.4} 11/11/2026
### Aggiunto
- Array list di thread dinamico in base a quanti giocatori l'utente vuole inserire
- Funzione `lanciaGioco()` per permettere di creare all'utente n giocatori

### Fixed
- Gestione dell'ID del giocatore con la lunghezza dell'array e un contatore

### Problems
- `Cifrario`: i metodi `cifra()` e `decifra()` non funzionano correttamente 

### Todo
- Gestione della richiesta della chiave per decifrare la parola segreta quando il thread finisce l'esecuzione
- Scelta personalizzata del'utente del numero che deve raggiungere il giocatore (input tramite classe Giocatore)
- Correggere il cifrario (non funziona)

## {0.1.3} 11/11/2026
### Aggiunto
- Gettter per l'ID del giocatore
- Richiesta della `keyword` per visualizzare la parola decifrata del giocatore
- Richiesta della parola segreta e keyword per creare i giocatori `g1` e `g2`

### Aggiornato
- Il giocatore per stampare le informazioni del Thread, l'ID viene preso da `idGiocatore` (id assegnato da quando parte il thread), al posto che recuperarlo alla fine con `Thread.currentThread().threadId()`
- Metodo `getDettagli()`: inserita stampa dell'ID del giocatore (ancora non gestito)

### Fixed
- Metodo `decifra()`: spostata operazione `- 'A'` fuori `charAt()` altrimenti ritornava sempre `StringIndexOutOfBoundsException` oppure veniva eseguito un calcolo errato dello spostamento per decifrare la parola

## {0.1.2} 10/11/2026
### Aggiunto
- Utilizzo del cifrario di Vigenère
- Cifratura di una parola utilizzando una keyword personalizzata
- Decifratura di una parola utilizzando la keyword scelta dall'utente per cifrare la parola stessa
- Recuperato l'ID del giocatore tramite il thread con `this.threadID()`

### Aggiornato
- Inseriti parametri `keyword` nel costruttore e nei metodi `cifra()` e `decifra()`
- Aggiornati commenti `JavaDoc`
- La classe `Giocatore` estende la classe `Tread` come da UML
- Diagramma UML con i metodi giust per le classi `Cifrario` e `Giocatore`

### Rimosso
- Implementazione della classe `Runnable`

### Documentazione
- Materiale del docente di TPSIT
- [Informazioni cifrario di Vigenère](https://brilliant.org/wiki/vigenere-cipher/)
- [Codice Python del cifrario](https://inventwithpython.com/cracking/chapter19.html)

## {0.1.1} 09/11/2026
### Aggiunto
- Classe `Cifrario` per cifrare la parola inserita dall'utente
- Classe `GestoreFile` per salvare i dati del `Gioatore`

### Aggiornato
- Il giocatore ha 2 getter per il nome e per la parola cifrata
- Il costruttire di `Giocatore` richiede la parola come parametro
- Rinominato attributo `parola` in `parolaCifrata` perché viene cifrata prima di essere salvata

### Documentazione
- Materiale del docente di TPSIT

## {0.1.0} 07/11/2026
### Aggionto
- Recuperato il codice del vecchio progetto `GiocaNumeri`
- Creato diagramma UML della nuova esercitazione

### Documentazione
- Materiale del docente di TPSIT

## {0.0.4} 05/11/2026

### Aggiunto
- Aggiunti `printStackTrace()` mancanti

### Fixed
- `BufferedWriter`: ora non viene più chiuso fino a che non serve più
- Rinominati alcuni attributi delle eccezioni: pirma: `e`, ora: `ioException`, `fileNotFoundEx`, ecc...
- Versione all'interno di `pom.xml` da 0.0.2 a 0.0.4 (coerente con la versione del progetto)

### Aggiornamenti
- Aggiornata versione di `Java` da `Amazon Corretto 26` e `Amazon Corretto 27.0.1`

### Documentazione
- Presentazion PowerPoint della docente di TPSIT
- Google :/

## {0.0.3} 04/11/2026
### Aggiunto
- Srittura del file di testo `BufferedWriter` e `FileWriter`
- Gestite le eccezioni nella scrittura del file
- Gestite le chiusure del `BufferedWriter` e di `FileWriter`
- Creata classe `DemoException` per esercitazione all'utilizzo di `throws Exception`
- Aggiunta somma di 2 numeri con eccezione personalizzata
- Agguinto prodotto di un numero con eccezione personalizzata

### Fixed
- Rimosso blocco `finally` alla fine del primo input da tastiera
- Aggiunta gestione di `NullPointerException` su alcune variabili

### Documentazione
- Presentazion PowerPoint della docente di TPSIT

## {0.0.2} 28/10/2026
### Aggiunto
- Lettura di input di testo da tastiera utilizzando le classi `BufferedReader` e `InputStreamReader`
- Lettura di un file di testo semplice _(prova.txt)_ utilizzando `InputStream` e `BufferedReader`
- Gestite le eccezioni nell'apertura del file
- Gestite le chiusure del `BufferedReader` e di `InputSteram`
- Sostituita la classe `Scanner` con `BufferedReader`

### Documentazione
- Presentazioni PowerPoint della docente di TPSIT
- Documentazione ufficiale Java di Oracle


## {0.0.1} 26/10/2026

### Aggiunto
- Prova per testing gestione delle eccezioni

### Documentazione
- Materiale del docente di TPSIT