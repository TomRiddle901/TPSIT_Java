package tpsit.syncronized.contoCorrente;

import java.util.ArrayList;
import java.util.Random;

public class ContoCorrente {
    private double saldo;
    private String[] operazioni = {"Preleva", "Deposita", "Controlla"};
    ArrayList<Double> movimenti = new ArrayList<>();

    public ContoCorrente(double saldo){
        this.saldo = saldo;
    }

    public synchronized void operazioneRandom(){
        Random numeroRandom = new Random();
        int indiceCasuale = numeroRandom.nextInt(operazioni.length);


    }
}
