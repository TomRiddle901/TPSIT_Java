package tpsit.giocanumeri.esercitazione;

public class DemoException {
    public int somma(int a, int b) throws Exception{
        int somma = a + b;
        if (somma < 10) throw new Exception("DemoException: " + somma + " la somma deve essere > 10.");
        return somma;
    }

    public int prodotto(int a) throws Exception{
        int prodotto = a * 2;
        if (prodotto < 10) throw new Exception("DemoException: " + prodotto + " il prodotto deve essere > 10.");
        return prodotto;
    }
}
