# Changelog

Tutte le modifiche rilevanti a questo progetto saranno documentate in questo file.

---

## [0.1.2] 10/11/2026
### Aggiunto
- Utilizzo del cifrario di Vigenère
- Cifratura di una parola utilizzando una keyword personalizzata
- Decifratura di una parola utilizzando la keyword scelta dall'utente per cifrare la parola stessa
- Recuperato l'ID del giocatore tramite il thread con `this.threadID()`

### Aggiornato
- Inseriti parametri `keyword` nel costruttore e nei metodi `cifra()` e `decifra()`
- Aggiornati commenti `JavaDoc`
- La classe `Giocatore` estende la classe `Tread` come da UML

### Rimosso
- Implementazione della classe `Runnable`

### Documentazione
- Materiale del docente di TPSIT
- [Informazioni cifrario di Vigenère](https://brilliant.org/wiki/vigenere-cipher/)
- [Codice Python del cifrario](https://inventwithpython.com/cracking/chapter19.html)

## [0.1.1] 09/11/2026
### Aggiunto
- Classe `Cifrario` per cifrare la parola inserita dall'utente
- Classe `GestoreFile` per salvare i dati del `Gioatore`

### Aggiornato
- Il giocatore ha 2 getter per il nome e per la parola cifrata
- Il costruttire di `Giocatore` richiede la parola come parametro
- Rinominato attributo `parola` in `parolaCifrata` perché viene cifrata prima di essere salvata

### Documentazione
- Materiale del docente di TPSIT

## [0.1.0] 07/11/2026
### Aggionto
- Recuperato il codice del vecchio progetto `GiocaNumeri`
- Creato diagramma UML della nuova esercitazione

### Documentazione
- Materiale del docente di TPSIT

## [0.0.4] 05/11/2026

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

## [0.0.3] 04/11/2026
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

## [0.0.2] 28/10/2026
### Aggiunto
- Lettura di input di testo da tastiera utilizzando le classi `BufferedReader` e `InputStreamReader`
- Lettura di un file di testo semplice _(prova.txt)_ utilizzando `InputStream` e `BufferedReader`
- Gestite le eccezioni nell'apertura del file
- Gestite le chiusure del `BufferedReader` e di `InputSteram`
- Sostituita la classe `Scanner` con `BufferedReader`

### Documentazione
- Presentazioni PowerPoint della docente di TPSIT
- Documentazione ufficiale Java di Oracle


## [0.0.1] 26/10/2026

### Aggiunto
- Prova per testing gestione delle eccezioni

### Documentazione
- Materiale del docente di TPSIT