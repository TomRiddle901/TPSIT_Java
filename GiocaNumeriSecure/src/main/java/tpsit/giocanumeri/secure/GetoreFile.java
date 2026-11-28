package tpsit.giocanumeri.secure;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe che gestisce il salvataggio/caricamento dei dati del giocatore su un file
 * @author TomRiddle901
 * @version 0.0.0
 */
public class GetoreFile {
    private DateTimeFormatter formatoGGMMYYYY = DateTimeFormatter.ofPattern("dd M yyyy");
    private String dataFormattata = LocalDate.now().format(formatoGGMMYYYY);
    Giocatore giocatore;

    public GetoreFile(Giocatore giocatore){
        this.giocatore = giocatore;
    }

    public synchronized void salva(){

    }
}
