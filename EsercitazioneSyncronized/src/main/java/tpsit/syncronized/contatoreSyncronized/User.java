package tpsit.syncronized.contatoreSyncronized;

public class User implements Runnable{
    Counter counter = new Counter();

    @Override
    public void run(){
        for (int i = 0; i < 5000; i++){
            counter.increment();
        }
    }
}
