/**
 * <h1>Applicazione multithreading</h1>
 * @author TomRiddle901
 */

package tpsit.giocanumeri;

public class GiocaNumeri{
    public static void main(String[] args) {
        System.out.println("Inizio gioco");

        try{
            Giocatore g1 = new Giocatore("Tommaso");
            g1.start();

            Thread.currentThread().sleep(5000);

        }catch (InterruptedException e){
            System.err.println("Errore nella transizione del thread da running a sleeping");
        }

        Giocatore g2 = new Giocatore("Alessandro");
        g2.start();

        System.out.println("Fine gioco!");
    }
}