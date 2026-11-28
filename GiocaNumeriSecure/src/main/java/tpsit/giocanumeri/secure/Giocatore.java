package tpsit.giocanumeri.secure;

import java.io.*;

/**
 * Thread Giocatore
 * @see #Giocatore(String nome, String parola, String keyword, int idGiocatore, Cifrario cifrario, MonitorTastiera tastiera, GetoreFile salva) Giocatore()
 * per visualizzare i parametri richiesti per creare l'oggetto
 * @author TomRiddle901
 * @version 1.0.1
 */
public class Giocatore extends Thread{
    private String nome;
    private String parolaCifrata;
    private int punteggio;
    private int idGiocatore;
    private int numero = 20;
    Cifrario cifrario;
    MonitorTastiera tastiera;
    GetoreFile salva;

    /**
     * Costruttore della classe Giocatore
     * @param nome Nome del giocatore
     * @param parola Parola/frase che verrà cifrata
     * @param keyword Parola chiave per cifrare la parola
     * @param cifrario puntatore all'oggetto cifrario
     * @param tastiera puntatore all'oggetto tastiera
     * @param salva puntatore all'oggetto GestoreFile
     * @see Cifrario Cifrario.java per vedere il metodo di crittografia utilizzato
     */
    public Giocatore(String nome, String parola, String keyword, int idGiocatore, Cifrario cifrario, MonitorTastiera tastiera, GetoreFile salva){
        this.nome = nome;
        this.cifrario = cifrario;
        this.tastiera = tastiera;
        this.parolaCifrata = this.cifrario.cifra(parola, keyword);
        this.idGiocatore = idGiocatore;
        this.salva = salva;
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
     * @return java.lang.String nome
     */
    public String getNome(){
        return nome;
    }

    /**
     * Getter che restituisce la parolaCifrata cifrata
     * @return java.lang.String parolaCifrata
     */
    public String getParolaCifrata(){
        return parolaCifrata;
    }

    /**
     * Getter per ottenere l'ID del giocatore
     * @return long idGiocatore
     */
    public long getIdGiocatore(){
        return idGiocatore;
    }

    /**
     * Getter per ottenere il punteggio del giocatore
     * @return int punteggio
     */
    public int getPunteggio(){
        return punteggio;
    }

    /**
     * Getter per ottenere il numero di arrivo che deve raggiungere il giocatore
     * @return int numero
     */
    public int getNumero(){
        return numero;
    }

    /**
     * Logica del gioco
     */
    private void gioca(){
        getDettagli();

        for (int i = 0; i < numero; i++){
            System.out.println(nome + ": " + i);

            try {
                Thread.sleep(500);
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
        salva.salva();

        String keyword, parolaDecifrata;

        System.out.println("Per visualizzare la parola decifrata, digita la keyword altrimenti alscia vuoto");

        keyword = tastiera.inputTastiera("Keyword " + nome + ": ");

        if (keyword.isEmpty()){
            System.out.println(nome + ": " + punteggio + "pt la tua parola cifrata è: " + parolaCifrata);
        }else if (keyword.equals("erroreCatturaInput")){
            System.err.println("Errore nella cattura dell'input, vedere sopra il messaggio di errore.");
            System.out.println("La chiave non verrà visualizzata per questo errore.");
        }else{
            parolaDecifrata = cifrario.decifra(parolaCifrata, keyword);
            System.out.println(nome + ": " + punteggio + "pt, la tua parola decifrata è: " + parolaDecifrata);
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