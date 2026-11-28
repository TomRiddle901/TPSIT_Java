package tpsit.syncronized.contoCorrente;

public class Main {
    static void main(){
        ContoCorrente contoCorrente = new ContoCorrente(2000);
        Correntista correntista1 = new Correntista("Mario", "Rossi", contoCorrente);
        Correntista correntista2 = new Correntista("Rossi", "Mario", contoCorrente);

        Thread corr1 = new Thread(correntista1);
        Thread corr2 = new Thread(correntista2);

        for (int i = 0; i < 10; i++){
            corr1.start();
            corr2.start();
        }
    }
}
