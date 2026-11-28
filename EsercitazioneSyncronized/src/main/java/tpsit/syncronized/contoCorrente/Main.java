package tpsit.syncronized.contoCorrente;

public class Main {
    static void main(){
        ContoCorrente contoCorrente = new ContoCorrente(2000);
        Correntista correntista1 = new Correntista("Mario", "Rossi", contoCorrente);
        Correntista correntista2 = new Correntista("Rossi", "Mario", contoCorrente);


    }
}
