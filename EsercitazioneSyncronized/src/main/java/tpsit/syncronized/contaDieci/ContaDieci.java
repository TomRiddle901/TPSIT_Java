package tpsit.syncronized.contaDieci;

public class ContaDieci implements Runnable{
    private int i;
    int n = 10;
    private Contatore contatore;

    public ContaDieci(Contatore contatore){
        this.contatore = contatore;
    }

    @Override
    public void run(){
        while (i < n) {
            contatore.increment();

            System.out.println(Thread.currentThread().getName() +
                    "\ni: " + i +
                    " contatore: " + contatore.getCount());

            i++;
        }
    }
}