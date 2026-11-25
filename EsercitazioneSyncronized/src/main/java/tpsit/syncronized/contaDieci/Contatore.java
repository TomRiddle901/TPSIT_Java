package tpsit.syncronized.contaDieci;

public class Contatore {
    private int count = 0;

    public synchronized void increment(){count++;}

    public synchronized int getCount(){
        return count;
    }
}