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
        Random importoOperazioneRandom = new Random();
        int indiceCasuale = numeroRandom.nextInt(operazioni.length);
        double importoRandom = importoOperazioneRandom.nextDouble(0, 500);

        switch (operazioni[indiceCasuale]){
            case "preleva":
                preleva(importoRandom);
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

    public synchronized void preleva(double importo){
        if (saldo <= 0){
            System.out.println("Impossibile prelevare.\nIl tuo saldo attuale è: €" + saldo);
        }else {
            saldo -= importo;
            System.out.println("Operazione effettuata con successo.");
            System.out.println("Importo prelevato: €" + importo);
            System.out.println("Saldo attuale: €" + saldo);
        }
    }
}
