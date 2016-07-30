package JavaRush;
import java.io.*;
import java.util.Scanner;

public class Svetlofor{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	int time = Integer.parseInt(s1);
        int days = 366;
        
        double res = time % 5;

        if (res >= 0 && res <3)
            System.out.println("çåëåíûé");
        else if (res >= 3 && res <4)
            System.out.println("æåëòûé");
        else if (res >= 4 && res <5)
            System.out.println("êğàñíûé");
    }
}

