package tpsit.syncronized.contatoreSyncronized;

public class User implements Runnable{
    Counter counter;

    public User(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5000; i++){
            counter.increment();
        }
    }
}
