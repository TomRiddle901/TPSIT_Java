package tpsit.giocanumeri;

public class Giocatore extends Thread{
    private String nome;
    private String parola;
    private int punteggio;

    /**
     *
     * @param nome nome del giocatore
     */

    public Giocatore(String nome){
        this.nome = nome;
    }

    // Getter
    public String getParola() {
        return parola;
    }

    public int getPunteggio(){
        return punteggio;
    }

    // Setter
    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    /**
     * gioca() implementa la logica del gioco e calcola il punteggio
     */
    public void gioca(){
        int numero = 19;
        parola = "Buongiorno";

        for (int i = 0; i < numero; i++){
            System.out.println("Giocatore " + nome + ": " + i);
            try{
                sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Errore nella transizione del thread da running a sleeping");
            }
            currentThread().yield();
        }

        setPunteggio(100);
    }

    public void comunica(){
        System.out.println("Giocatore " + nome + ": " + punteggio + " ha scelto la parola: " + parola);
    }

    @Override
    public void run(){
        gioca();
        comunica();
    }
}