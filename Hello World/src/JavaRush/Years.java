package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Years{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	int m = Integer.parseInt(s1);
        int days = 366;

        int res1 = m % 4;
        int res2 = m % 100;
        int res3 = m % 400;

        if (res1 == 0){
            if (res2 == 0 && res3 != 0)
                days = 365;
        }else
            days = 365;

        System.out.println("количество дней в году: " + days);
    }
}