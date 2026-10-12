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
}
