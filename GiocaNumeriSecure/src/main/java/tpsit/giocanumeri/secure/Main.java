package tpsit.giocanumeri.secure;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in); // classe scanner utilizzata per l'input dei numeri
        int a, b, c;
        String testo, riga;
        File file = new File("prova.txt");

        // Input da tastiera per inserire una parola/frase/lettera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            testo = tastiera.readLine();
        } catch (IOException e) {
            System.err.println("Errore di comunicazione della tastiera con la RAM.");
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
                    System.err.println("Errore nella chiusura dello Stream.");
                }
            }
        }

        try{
            System.out.print("Inscerisci il numeratore: ");
            a = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer di input

            System.out.print("Inserisci il denominatore: ");
            b = scanner.nextInt();
            scanner.nextLine();

            c = a/b;
            System.out.println("Risultato divisione: " + c); // Questo output non verrà mostrato se ci sono errori
        }catch (ArithmeticException arithmeticEx){
            System.err.println("Errore: si è verificato un problema durante il calcolo della divisione.");
            arithmeticEx.printStackTrace();
        }catch (InputMismatchException inputMismatchEx){
            System.err.println("Errore: valore inserito non valido, deve essere un numero.");
            inputMismatchEx.printStackTrace();
        }

        scanner.close();
    }
}