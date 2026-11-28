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
    private InputStream inputStreamFile = null;
    private BufferedReader bufferFile;

    public GetoreFile(Giocatore giocatore){
        this.giocatore = giocatore;
    }

    public synchronized void salva(){
        long idGiocatore = giocatore.threadId();
        String dataFormattata = LocalDate.now().format(formatoGGMMYYYY);

        File file = new File(idGiocatore + " - gioco del " + dataFormattata);

        inputStreamFile = new InputStreamReader(new BufferedInputStream())
    }
}
