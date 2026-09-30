public class GiocaNumeri {
    public static void main(String[] args) {
        System.out.println("Benvenuto!");

        Giocatore g1 = new Giocatore("Tommaso");
        Giocatore g2 = new Giocatore("Alessandro");

        g1.start();
        g2.start();

        System.out.println("Fine gioco!");
    }
}