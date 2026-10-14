/**
 * Gioca Numeri con classe Runnable!
 * @author TomRiddle901
 */
package tpsit.giocanumeri.runnable;

public class GiocaNumeri {
    static void main() {
        Giocatore g1 = new Giocatore("Giocatore 1");
        Giocatore g2 = new Giocatore("Giocatore 2");

        Thread g1Thread = new Thread(g1);
        Thread g2Thread = new Thread(g2);

        g1Thread.start();
        g2Thread.start();
    }
}