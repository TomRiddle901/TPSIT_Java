package tpsit.giocanumeri.secure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner inputStream = new Scanner(System.in);
        int a, b, c;

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