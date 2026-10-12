package tpsit.giocanumeri.runnable;

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
     * Metodo Run presente nella classe Runnable
     */
    @Override
    public void run(){

    }

    /**
     * Metodo che implementa la logica del gioco
     */
    public void gioca(){
        int numero = 19;
        parola = "Runnable!";

        for (int i = 0; i < numero; i++){
            System.out.println("Giocatore: " + nome + ": " + i);

            try {
                Thread.sleep(2000);
            }catch (InterruptedException interruptedEx){
                System.err.println("Errore nella transizione del Thread da running a sleeping");
            }
        }

        setPunteggio(100);
    }
}
