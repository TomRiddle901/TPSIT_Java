package tpsit.giocanumeri;

public class Giocatore extends Thread{
    private String nome;
    private String parola;
    private int punteggio;

    public Giocatore(String nome){
        this.nome = nome;
    }

    public void gioca(){
        int numero = 19;
        String parola = "Buongiorno";
        for (int i = 0; i < numero; i++){
            System.out.println("Giocatore " + nome + ": " + i);
        }

        punteggio = 10;
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