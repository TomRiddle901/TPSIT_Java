package tpsit.giocanumeri.secure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonitorTastiera {
    private static String testoTastiera;

    public MonitorTastiera(){}

    public static synchronized String inputTastiera(){
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        try{
            testoTastiera = tastiera.readLine();
            return testoTastiera;
        }catch (IOException ioException){
            System.err.println("Errore di comunicazione della tastiera con la RAM");
            return "erroreCatturaInput";
        }
    }
}