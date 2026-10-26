package tpsit.giocanumeri.secure;

public class Main {
    static void main() {
        int a = 10;
        int b = 0;
        int c;

        try{
            c = a/b;
            System.out.println(c); // Questo output non verrà mostrato
        }catch (ArithmeticException arithmeticEx){
            System.err.println("Attenzione! Divisione per 0.");
        }
    }
}