package tpsit.giocanumeri.secure;

public class DemoException {
    public int somma(int a, int b) throws Exception{
        int somma = a + b;
        if (somma > 10) throw new Exception("DemoException: " + somma + " la somma deve essere > 10.");
        return somma;
    }
}
