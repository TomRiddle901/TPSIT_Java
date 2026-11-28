/**
 * Documentazione usata:
 * <a href="https://www.freecodecamp.org/italian/news/generatore-di-numeri-casuali-in-java-come-generare-interi-con-math-random/">Random</a>
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#now--">LocalDate.now()</a>
 * @author TomRiddle901
 * @version 2.0.0
 */
package tpsit.syncronized.contoCorrente;

public class Main {
    static void main(){
        ContoCorrente contoCorrente = new ContoCorrente(2000);
        Correntista correntista1 = new Correntista("Mario", "Rossi", contoCorrente);
        Correntista correntista2 = new Correntista("Rossi", "Mario", contoCorrente);

        Thread corr1 = new Thread(correntista1);
        Thread corr2 = new Thread(correntista2);

        corr1.start();
        corr2.start();
    }
}
