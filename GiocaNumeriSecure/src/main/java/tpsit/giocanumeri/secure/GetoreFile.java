package tpsit.giocanumeri.secure;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che gestisce il salvataggio/caricamento dei dati del giocatore su un file
 * @see #salva() salva per comprendere il salvataggio
 * @author TomRiddle901
 * @version 1.0.0
 */
public class GetoreFile {
    private DateTimeFormatter formatoGGMMYYYY = DateTimeFormatter.ofPattern("dd M yyyy");
    private Giocatore giocatore;
    private BufferedWriter bufferedWriter;

    /**
     * Costruttore della classe GestoreFile
     * @param giocatore Giocatore che si vuole salvare i dati
     * @param bufferedWriter Puntatore al'oggetto BufferedWriter
     * @see GetoreFile GestoreFile per alte informazioni
     */
    public GetoreFile(Giocatore giocatore, BufferedWriter bufferedWriter){
        this.giocatore = giocatore;
        this.bufferedWriter = bufferedWriter;
    }

    /**
     * Funzione per il salvataggio su file di un giocatore
     */
    public synchronized void salva(){
        long idGiocatore = giocatore.getIdGiocatore();
        String dataFormattata = LocalDate.now().format(formatoGGMMYYYY);
        String nomeFile = idGiocatore + " - gioco del " + dataFormattata + ".txt";

        File file = new File("GiocaNumeri/" + nomeFile);

        try{
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            bufferedWriter.write("Numero: " + giocatore.getNumero() + "\n" +
                    "Punteggio: " + giocatore.getPunteggio() + "\n" +
                    "Parola Cifrata: " + giocatore.getParolaCifrata());
        } catch (IOException ioException) {
            System.err.println("Errore nella comunicazione I/O della RAM con il disco di sistema");
            ioException.printStackTrace();
        }

    }
}
