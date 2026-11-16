package tpsit.giocanumeri.secure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonitorTastiera {
    private String testoTastiera;

    public MonitorTastiera(){}

    public static synchronized String inputTastiera(){
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try{
            tastiera.readLine();
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM");
        }

        return tastiera;
    }
}
