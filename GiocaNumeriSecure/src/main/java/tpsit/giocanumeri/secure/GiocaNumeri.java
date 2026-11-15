package tpsit.giocanumeri.secure;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe di avvio principale di tutto il progetto
 * @author TomRiddle901
 * @version 0.1.6
 */
public class GiocaNumeri {
    /**
     * Array di thread Giocatore creati dall'utente
     * @see #lanciaGioco() lanciaGioco()
     */
    static ArrayList<Thread> threads = new ArrayList<>();

    static void main() {
        // Tempo di avvio del Thread main
        long tempoInizio = System.currentTimeMillis();

        try{
            lanciaGioco();
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }

        System.out.println("Info del thread principale:");
        getInfoThread(Thread.currentThread());

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

    /**
     * Crea i thread Giocatore con nome, parola, keyword inseriti dall'utente
     * e gestisce gli ID del giocatore tramite un contatore e il numero
     * dei thread creati in precedenza
     * @throws Exception eh
     */
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

                Cifrario.convalidaParametri(parola, keyword);

                threads.add(new Thread(new Giocatore(nome, parola, keyword, idGiocatore)));
                idGiocatore++;
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