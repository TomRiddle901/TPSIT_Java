package tpsit.syncronized.contoCorrente;

public class Correntista implements Runnable{
    private String nome;
    private String cognome;
    private ContoCorrente contoCorrente;

    public Correntista(String nome, String cognome, ContoCorrente contoCorrente){
        this.nome = nome;
        this.cognome = cognome;
        this.contoCorrente = contoCorrente;
    }

    @Override
    public void run() {
        System.out.println("Correntista " + nome + " " + cognome);
        System.out.println("Esecuzione di 5 operazioni random...");
        for (int i = 0; i < 5; i++) {
            contoCorrente.operazioneRandom();
        }
    }
}
