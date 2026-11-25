package tpsit.syncronized.contaDieci;

public class ContaDieci implements Runnable{
    private int i;
    private Contatore contatore;

    public ContaDieci(Contatore contatore){
        this.contatore = contatore;
    }

    @Override
    public void run(){
        for (i = 0; i < 11; i++){
            contatore.increment();
        }
    }
}
