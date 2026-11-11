package tpsit.giocanumeri.secure;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe di avvio principale di tutto il progetto
 * @author TomRiddle901
 * @version 0.1.6
 */
public class GiocaNumeri {
    // Array dei thread presenti nel gioco
    static ArrayList<Thread> threads = new ArrayList<Thread>();

    static void main() {
        // Tempo di avvio del Thread main
        long tempoInizio = System.currentTimeMillis();

        try{
            lanciaGioco();
        }catch (Exception exception){
            System.err.println(exception.getMessage());
            for (int i = 0; i < threads.size(); i++){
                threads.get(i).start();
            }
        }

        getInfoThread(Thread.currentThread());

        /*
        // Inizializzazione delle variabili
        String parola, keyword;
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        Giocatore g1 = null;
        Giocatore g2 = null;

        // Richiesta della parola e della keyword (questo è temporaneo, verrà sostituito con un cliclo)
        try{
            // Giocatore1
            System.out.print("Giocatore1, inserisci la tua parola segreta: ");
            parola = tastiera.readLine();
            System.out.print("Giocatore1, inserisci la tua keyword: ");
            keyword = tastiera.readLine();
            g1 = new Giocatore("Giocatore 1", parola, keyword);

            // Giocatore2
            System.out.print("Giocatore2, inserisci la tua parola segreta: ");
            parola = tastiera.readLine();
            System.out.print("Giocatore2, inserisci la tua keyword: ");
            keyword = tastiera.readLine();
            g2 = new Giocatore("Giocatore 2", parola, keyword);
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM");
        }

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

         */

        long tempoFine = System.currentTimeMillis() - tempoInizio;
        System.out.println("Tempo trascorso per l'esecuzione del programma (s): " + (tempoFine/1000.0));
    }

    /**
     * Visualizza id, nome, priorità e stato del Thread corrente
     * @param thread Thread in esecuzione
     */
    private static void getInfoThread(Thread thread){
        System.out.println("ID: " + thread.threadId());
        System.out.println("Nome: " + thread.getName());
        System.out.println("Priorità: " + thread.getPriority());
        System.out.println("Stato: " + thread.getState());
        System.out.println("------------------------------");
    }

    private static void lanciaGioco() throws Exception{
        String nome, parola, keyword, scelta;
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        int idGiocatore = threads.size();

        try{
            do{
                System.out.print("Nome del giocatore: ");
                nome = tastiera.readLine();
                System.out.print("Parola segreta: ");
                parola = tastiera.readLine();
                System.out.print("Chiave per decifrare: ");
                keyword = tastiera.readLine();
                System.out.print("Vuoi creare un altro giocatore? [y/n]: ");
                scelta = tastiera.readLine().toLowerCase();

                if (scelta.isEmpty() || (!scelta.equals("y") && !scelta.equals("n"))){
                    throw new Exception("La scelta inserita non è valida, il seguente giocatore non verrà creato e verrà avviato il gioco.");
                }else{
                    threads.add(new Thread(new Giocatore(nome, parola, keyword, idGiocatore)));
                    idGiocatore++;
                }
            }while (!scelta.equals("n"));

            for (int i = 0; i < threads.size(); i++){
                threads.get(i).start();
            }

        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della stastiera con la RAM");
        }catch (NullPointerException nullPointerEx) {
            System.err.println("Input non rilevato");
        }
    }
}