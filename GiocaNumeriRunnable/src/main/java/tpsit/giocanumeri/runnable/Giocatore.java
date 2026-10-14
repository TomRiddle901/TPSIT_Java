package tpsit.giocanumeri.runnable;

/**
 * Classe del giocatore
 * @implNote java.lang.Runnable Implementazione della classe Runnable
 */
public class Giocatore implements Runnable{
    private String nome;
    private String parola;
    private int punteggio;

    /**
     * Costruttore classe Giocatore
     * @param nome Nome del giocatore
     */
    public Giocatore(String nome){
        this.nome = nome;
    }

    /**
     * Setter per impostare il punteggio
     * @param punti Punteggio passato (int)
     */
    public void setPunteggio(int punti){
        punteggio = punti;
    }

    /**
     * Logica del gioco
     */
    public void gioca(){
        int numero = 19;
        parola = "Runnable!";

        getDettagli();

        for (int i = 0; i < numero; i++){
            System.out.println(nome + ": " + i);

            try {
                Thread.sleep(2000);
            }catch (InterruptedException interruptedEx){
                System.err.println("Errore nella transizione del Thread da running a sleeping");
            }
        }

        setPunteggio(100);
        getDettagli();
    }

    /**
     * Comunica nome, punteggio e parola del giocatore
     */
    public void comunica(){
        System.out.println(nome + ": " + punteggio + "pt ha scelto la parola: " + parola);
    }

    public void getDettagli(){
        System.out.println("ID: " + Thread.currentThread().threadId());
        System.out.println("Nome: " + Thread.currentThread().getName());
        System.out.println("Priorità: " + Thread.currentThread().getPriority());
        System.out.println("Stato: " + Thread.currentThread().getState());
        System.out.println("------------------------------");
    }

    /**
     * Metodo Run presente nella classe Runnable
     */
    @Override
    public void run(){
        gioca();
        getDettagli();
        comunica();
    }
}