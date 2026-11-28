package tpsit.syncronized.contoCorrente;

import java.util.ArrayList;
import java.util.Random;

public class ContoCorrente {
    private double saldo;
    private String[] operazioni = {"preleva", "deposita", "controlla"};
    ArrayList<Double> movimenti = new ArrayList<>();

    public ContoCorrente(double saldo){
        this.saldo = saldo;
    }

    public synchronized void operazioneRandom(){
        Random numeroRandom = new Random();
        int indiceCasuale = numeroRandom.nextInt(operazioni.length);

        switch (operazioni[indiceCasuale]){
            case "preleva":
                break;
            case "deposita":
                break;
            case "controlla":
                break;
            default:
                System.err.println("Errore: Operazione non valida");
                break;
        }
    }
}
