package tpsit.giocanumeri.secure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonitorTastiera {
    private String testoTastiera;

    public MonitorTastiera(){}

    public static synchronized String inputTastiera(){
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        tastiera.readLine();
        return tastiera;
    }
}
