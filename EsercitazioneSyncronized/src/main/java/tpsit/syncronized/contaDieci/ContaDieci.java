package tpsit.syncronized.contaDieci;

public class ContaDieci implements Runnable{
    private int i;
    private int n;
    private Contatore contatore;

    public ContaDieci(Contatore contatore){
        this.contatore = contatore;
    }

    @Override
    public void run(){
        try {
            while (i < n) {
                Thread.currentThread().sleep(2000);
                contatore.increment();
            }
        }catch (InterruptedException interruptedEx){
            System.err.println("Errone nel passaggio da running a sleeping");
            interruptedEx.printStackTrace();
        }
    }
}
