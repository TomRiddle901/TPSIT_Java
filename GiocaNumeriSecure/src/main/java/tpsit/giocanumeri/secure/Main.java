package tpsit.giocanumeri.secure;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        String testo;
        File file = new File("prova.txt");

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            testo = tastiera.readLine();
        } catch (IOException e) {
            System.err.println("Errore di comunicazione della tastiera con la RAM.");
        }

        InputStream inputStreamFile;
        try {
            inputStreamFile = new FileInputStream(file);

            BufferedReader bufferFile = new BufferedReader(new InputStreamReader(inputStreamFile));
        } catch (FileNotFoundException fileNotFoundEx) {
            System.err.println("Errore: file non trovato.");
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