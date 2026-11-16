package tpsit.giocanumeri.secure;

import java.util.ArrayList;

/**
 * Classe di avvio principale di tutto il progetto
 * @author TomRiddle901
 * @version 0.2.2
 */
public class GiocaNumeri {
    /**
     * Array di thread Giocatore creati dall'utente
     * @see #lanciaGioco() lanciaGioco()
     */
    private static ArrayList<Thread> threads = new ArrayList<>();

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
        Cifrario cifrarioObj = new Cifrario();
        MonitorTastiera tastieraObj = new MonitorTastiera();
        int idGiocatore = threads.size();

        do{
            nome = tastieraObj.inputTastiera("Nome del giocatore: ");

            parola = tastieraObj.inputTastiera("Parola segreta: ");

            keyword = tastieraObj.inputTastiera("Chiave per decifrare: ");

            // Controllo che non ci siano stati errori prima
            if (nome.equals("erroreCatturaInput") || parola.equals("erroreCatturaInput") || keyword.equals("erroreCatturaInput")){
                throw new Exception("Errore nella gestione dell'input della classe MonitorTastiera");
            }

            scelta = tastieraObj.inputTastiera("Vuoi creare un altro giocatore? [y/n]: ").toLowerCase();

            cifrarioObj.convalidaParametri(parola, keyword);

            threads.add(new Thread(new Giocatore(nome, parola, keyword, idGiocatore, cifrarioObj, tastieraObj)));
            idGiocatore++;
        }while (!scelta.equals("n"));

        for (int i = 0; i < threads.size(); i++){
            threads.get(i).start();
        }
    }
}