package tpsit.syncronized.contatoreSyncronized;

public class Main {
    static void main() {
        Counter counter = new Counter();

        // Create multiple threads to increment the counter
        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException interruptedEx) {
            interruptedEx.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}