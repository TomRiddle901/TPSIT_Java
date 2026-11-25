package tpsit.syncronized.contaDieci;

public class Main {
    static void main(){
        Contatore contatore = new Contatore();
        ContaDieci user1 = new ContaDieci(contatore);
        ContaDieci user2 = new ContaDieci(contatore);

        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);

        t1.start();
        t2.start();
    }
}