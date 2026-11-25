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
        try {
            while (i < n) {
                Thread.currentThread().sleep(2000);
                contatore.increment();

                System.out.println(Thread.currentThread().getName() +
                        "\ni: " + i +
                        " contatore: " + contatore.getCount());

                i++;
            }
        }catch (InterruptedException interruptedEx){
            System.err.println("Errone nel passaggio da running a sleeping");
            interruptedEx.printStackTrace();
        }
    }
}
