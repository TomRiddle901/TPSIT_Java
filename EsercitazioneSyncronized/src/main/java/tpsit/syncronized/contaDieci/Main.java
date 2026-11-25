package tpsit.syncronized.contaDieci;

public class Main {
    static void main(){
        Contatore contatore = new Contatore();
        ContaDieci user1 = new ContaDieci(contatore);
        ContaDieci user2 = new ContaDieci(contatore);

        user1.run();
        user2.run();
    }
}
