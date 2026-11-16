package tpsit.giocanumeri.secure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe monitor per gestire l'input da tastiera durante il multithreading
 * @see #inputTastiera() inputTastiera() per comprendere meglio in senso della classe
 * @author TomRiddle901
 * @version 1.0.0
 */
public class MonitorTastiera {
    private String testoTastiera;

    public MonitorTastiera(){}

    /**
     * Cattura l'input della tastiera e lo restituisce come String.<br>
     * Questo metodo contiene synchronized per gestire l'input nel caso più Thread
     * richiedono l'input da tastiera
     * @return String: testo di input dato dalla tastiera
     */
    public synchronized String inputTastiera(){
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try{
            testoTastiera = tastiera.readLine();
            return testoTastiera;
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM");
            return "erroreCatturaInput";
        }
    }
}