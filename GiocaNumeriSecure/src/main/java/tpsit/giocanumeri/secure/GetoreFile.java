package tpsit.giocanumeri.secure;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che gestisce il salvataggio/caricamento dei dati del giocatore su un file
 * @author TomRiddle901
 * @version 0.0.0
 */
public class GetoreFile {
    private DateTimeFormatter formatoGGMMYYYY = DateTimeFormatter.ofPattern("dd M yyyy");
    private Giocatore giocatore;
    private InputStream inputStreamFile;
    private BufferedReader bufferFile;

    public GetoreFile(Giocatore giocatore, InputStream inputStreamFile, BufferedReader bufferFile){
        this.giocatore = giocatore;
        this.inputStreamFile = inputStreamFile;
        this.bufferFile = bufferFile;
    }

    public synchronized void salva(){
        long idGiocatore = giocatore.threadId();
        String dataFormattata = LocalDate.now().format(formatoGGMMYYYY);
        String nomeFile = idGiocatore + " - gioco del " + dataFormattata + ".txt";

        File file = new File("GiocaNumeri/" + nomeFile);

        try{
            inputStreamFile = new FileInputStream(file);

            bufferFile =
        }catch (FileNotFoundException fileNotFoundEx){
            System.err.println("Errore: file non trovato in /GiocaNumeri/" + nomeFile);
            fileNotFoundEx.printStackTrace();
        }

    }
}
