package tpsit.giocanumeri.secure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        int a = 10;
        int b;
        int c;

        System.out.print("Inscerisci un numero: ");
        b = scanner.nextInt();

        try{
            c = a/b;
            System.out.println("Risultato divisione: " + c); // Questo output non verrà mostrato
        }catch (ArithmeticException arithmeticEx){
            System.err.println("Attenzione! Errore nel calcolo della divisione.");
            arithmeticEx.printStackTrace();
        }catch (InputMismatchException inputMismatchEx){
            System.err.println("Errore: valore inserito non valido, deve essere un numero.");
            inputMismatchEx.printStackTrace();
        }

        scanner.close();
    }
}