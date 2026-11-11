package tpsit.giocanumeri.secure;

import java.io.*;

/**
 * Thread Giocatore
 * @author TomRiddle901
 * @version 0.2.1
 */
public class Giocatore extends Thread{
    private String nome;
    private String parolaCifrata;
    private int punteggio;
    long idGiocatore = this.threadId();
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Costruttore classe Giocatore
     * @param nome Nome del giocatore
     * @param parola Parola/frase da cifrare
     * @param keyword Parola chiave
     */
    public Giocatore(String nome, String parola, String keyword){
        this.nome = nome;
        this.parolaCifrata = Cifrario.cifra(parola, keyword);
    }

    /**
     * Setter per impostare il punteggio
     * @param punti Punteggio passato (int)
     */
    public void setPunteggio(int punti){
        punteggio = punti;
    }

    /**
     * Getter che restituisce il come del giocatore
     * @return java.lang.String
     */
    public String getNome(){
        return nome;
    }

    /**
     * Getter che restituisce la parolaCifrata cifrata
     * @return java.lang.String
     */
    public String getParolaCifrata(){
        return parolaCifrata;
    }

    /**
     * Getter per ottenere l'ID del giocatore
     * @return long
     */
    public long getIdGiocatore(){
        return idGiocatore;
    }

    /**
     * Logica del gioco
     */
    private void gioca(){
        int numero = 20;

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
    }

    /**
     * Visualizza nome, punteggio e parolaCifrata del giocatore
     */
    private void comunica(){
        String keyword, parolaDecifrata;
        try{
            System.out.println("Per visualizzare la parola decifrata, digita la keyword altrimenti alscia vuoto");
            System.out.print("Keyword: ");
            keyword = tastiera.readLine();

            if (keyword.isEmpty()){
                System.out.println(nome + ": " + punteggio + "pt la tua parola cifrata è: " + parolaCifrata);
            }else{
                parolaDecifrata = Cifrario.decifra(parolaCifrata, keyword);
                System.out.println(nome + ": " + punteggio + "pt, la tua parola decifrata è: " + parolaDecifrata);
            }
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM");
        }
    }

    /**
     * Stampa dei dettagli del Thread corrente
     */
    private void getDettagli(){
        System.out.println("ID Giocatore: " + idGiocatore);
        System.out.println("ID Thread: " + Thread.currentThread().threadId());
        System.out.println("Nome: " + Thread.currentThread().getName());
        System.out.println("Priorità: " + Thread.currentThread().getPriority());
        System.out.println("Stato: " + Thread.currentThread().getState());
        System.out.println("------------------------------");
    }

    /**
     * Metodo Run presente nella classe Thread
     * Qeusto metodo avvia il gioco appena viene creato il thread Giocatore
     */
    @Override
    public void run(){
        long tempoInizio = System.currentTimeMillis();

        gioca();
        comunica();

        long tempoFine = System.currentTimeMillis() - tempoInizio;
        System.out.println("Tempo di esecuzione del Thread " + nome + ": " + (tempoFine/1000.0) + "s");
    }
}