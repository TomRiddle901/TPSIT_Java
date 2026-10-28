package tpsit.giocanumeri.secure;

import java.io.*;
import java.util.InputMismatchException;

public class Main {
    static void main() {
        int a, b, c;
        String testo = "", riga = "";
        File file = new File("GiocaNumeriSecure/prova.txt");

        // Input da tastiera per inserire una parola/frase/lettera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Inserisci una lettera/parola/frase: ");
            testo = tastiera.readLine();
        } catch (IOException e) {
            System.err.println("Errore di comunicazione della tastiera con la RAM.");
        }finally {
            try {
                tastiera.close();
            } catch (IOException e) {
                System.err.println("Errore nella chiusura dello stream di input della tastiera");
            }
        }

        // Input del file prova.txt
        InputStream inputStreamFile = null;
        BufferedReader bufferFile;
        try {
            inputStreamFile = new FileInputStream(file);

            bufferFile = new BufferedReader(new InputStreamReader(inputStreamFile));

            riga = bufferFile.readLine();
        } catch (FileNotFoundException fileNotFoundEx) {
            System.err.println("Errore: file non trovato.");
        }catch (IOException ioException){
            System.err.println("Errore nella lettura del file.");
        }finally {
            if (inputStreamFile != null){
                try {
                    inputStreamFile.close();
                } catch (IOException e) {
                    System.err.println("Errore nella chiusura dello stream di input del file prova.txt");
                }
            }
        }

        try{
            System.out.print("Inscerisci il numeratore: ");
            a = Integer.parseInt(tastiera.readLine());

            System.out.print("Inserisci il denominatore: ");
            b = Integer.parseInt(tastiera.readLine());

            c = a/b;
            System.out.println("Risultato divisione: " + c);
            System.out.println("Testo o parola: " + testo);
            System.out.println("Prima riga del file prova.txt: " + riga);
        }catch (ArithmeticException arithmeticEx){
            System.err.println("Errore: si è verificato un problema durante il calcolo della divisione.");
            arithmeticEx.printStackTrace();
        }catch (InputMismatchException inputMismatchEx){
            System.err.println("Errore: valore inserito non valido, deve essere un numero.");
            inputMismatchEx.printStackTrace();
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM.");
            ioException.printStackTrace();
        }
    }
}