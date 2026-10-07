/**
 * <h1>Applicazione multithreading</h1>
 * @author TomRiddle901
 */

package tpsit.giocanumeri;

public class GiocaNumeri{
    public static void main(String[] args) {
        System.out.println("Inizio gioco");

        Giocatore g1 = new Giocatore("Tommaso");
        g1.start();

        try{
            Thread.currentThread().sleep(5000);
        }catch (InterruptedException e){
            System.err.println("Errore nella transizione del thread da running a sleeping");
        }

        Giocatore g2 = new Giocatore("Alessandro");
        g2.start();

        /**
         * Aspetta che il thread g1 finisca per eseguire main
         */
        try {
            g1.join();
        } catch (InterruptedException e) {
            System.err.println("Errore nella transizione del thread da rugging a waiting");
        }

        /**
         * Dopo che g1 e g2 finiscono viene rieseguido il thread main
         */
        System.out.println("Fine gioco!");
    }
}