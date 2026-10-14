/**
 * Gioca Numeri con classe Runnable!
 * @author TomRiddle901
 */
package tpsit.giocanumeri.runnable;

public class GiocaNumeri {
    static void main() {
        // Tempo di avvio del Thread main
        long tempoInizio = System.currentTimeMillis();
        // Creazione degli oggetti Giocatore
        Giocatore g1 = new Giocatore("Giocatore 1");
        Giocatore g2 = new Giocatore("Giocatore 2");

        // Creazione degli oggetti Thread
        Thread g1Thread = new Thread(g1);
        Thread g2Thread = new Thread(g2);

        // Ottieni le informazioni sul Thread corrente (main)
        getInfoThread(Thread.currentThread());

        // Rallenta i Thread per avere un output più pulito sulle informazioni dei Thread
        try {
            Thread.sleep(1);
            g1Thread.start();
            Thread.sleep(2);
            g2Thread.start();
        } catch (InterruptedException interruptedEx) {
            System.err.println("Errore nella transizione del Thread da running a sleeping");
        }

        // Aspetto che i Thread dei giocatori siano terminati
        try{
            g1Thread.join();
            g2Thread.join();
        } catch (InterruptedException interruptedEx) {
            System.out.println("Errore nella transizione del Thread da running a waiting");
        }

        // Ottieni le informazioni sui Thread
        getInfoThread(g1Thread);
        getInfoThread(g2Thread);
        getInfoThread(Thread.currentThread());

        long tempoFine = System.currentTimeMillis() - tempoInizio;

        System.out.println("Tempo trascorso per l'esecuzione del programma (s): " + (tempoFine/1000.0));
    }

    /**
     * Visualizza id, nome, priorità e stato del Thread corrente
     * @param thread Thread in esecuzione
     */
    public static void getInfoThread(Thread thread){
        System.out.println("ID: " + thread.threadId());
        System.out.println("Nome: " + thread.getName());
        System.out.println("Priorità: " + thread.getPriority());
        System.out.println("Stato: " + thread.getState());
        System.out.println("------------------------------");
    }
}