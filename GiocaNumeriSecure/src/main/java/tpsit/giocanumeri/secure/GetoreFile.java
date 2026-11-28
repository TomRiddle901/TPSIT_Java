package tpsit.giocanumeri.secure;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che gestisce il salvataggio/caricamento dei dati del giocatore su un file
 * @see #salva(Giocatore giocatore) salva() per comprendere il salvataggio
 * @author TomRiddle901
 * @version 1.0.2
 */
public class GetoreFile {
    private DateTimeFormatter formatoGGMMYYYY = DateTimeFormatter.ofPattern("dd M yyyy");

    /**
     * Costruttore della classe GestoreFile
     * @see GetoreFile GestoreFile per alte informazioni
     */
    public GetoreFile(){}

    /**
     * Funzione per il salvataggio su file di un giocatore
     * @param giocatore Giocatore di cui si deve salvare il file
     */
    public synchronized void salva(Giocatore giocatore){
        long idGiocatore = giocatore.getIdGiocatore();
        String dataFormattata = LocalDate.now().format(formatoGGMMYYYY);
        String nomeFile = idGiocatore + " - gioco del " + dataFormattata + ".txt";
        BufferedWriter bufferedWriter;

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
