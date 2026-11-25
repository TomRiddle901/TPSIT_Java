package tpsit.syncronized.contaDieci;

public class Contatore implements Runnable{
    private int contatore;

    public Contatore(){

    }

    public synchronized void increment(){
        contatore++;
    }
}
