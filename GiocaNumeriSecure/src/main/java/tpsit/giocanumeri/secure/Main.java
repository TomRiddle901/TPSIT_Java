package tpsit.giocanumeri.secure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner inputStream = new Scanner(System.in);
        int a, b, c;
        String testo;

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        try {
            testo = tastiera.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            System.out.print("Inscerisci il numeratore: ");
            a = inputStream.nextInt();
            inputStream.nextLine(); // Pulisce il buffer di input

            System.out.print("Inserisci il denominatore: ");
            b = inputStream.nextInt();
            inputStream.nextLine();

            c = a/b;
            System.out.println("Risultato divisione: " + c); // Questo output non verrà mostrato se ci sono errori
        }catch (ArithmeticException arithmeticEx){
            System.err.println("Errore: si è verificato un problema durante il calcolo della divisione.");
            arithmeticEx.printStackTrace();
        }catch (InputMismatchException inputMismatchEx){
            System.err.println("Errore: valore inserito non valido, deve essere un numero.");
            inputMismatchEx.printStackTrace();
        }

        inputStream.close();
    }
}