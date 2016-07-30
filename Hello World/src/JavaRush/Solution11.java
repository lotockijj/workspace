package JavaRush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution11 {
	public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
    	String s1 = reader.readLine();
    	String s2 = reader.readLine();
    	String s3 = reader.readLine();
    	    Integer i1 = Integer.valueOf(s1);
    	    Integer i2 = Integer.valueOf(s2);
    	    Integer i3 = Integer.valueOf(s3);
    	    int max;
    	    int mid;
    	    int min;
    	    if(i1 > i2 || i1 == i2){
    	        if (i1 > i3 || i1 == i3){
    	            max = i1;
    	            if (i2 > i3 || i2 == i3){
    	                mid = i2;
    	                min = i3;
    	            }else{
    	                mid = i3;
    	                min = i2;
    	            }
    	        } else{
    	            max = i3;
    	            mid = i1;
    	            min = i2;
    	        }
    	    }else if (i1 > i3 || i1 == i3){
    	        max = i1;
    	        mid = i2;
    	        min = i3;
    	    }else{
    	        max = i3;
    	        mid = i1;
    	        min = i2;
    	    }
    	    System.out.println(max);
    	    System.out.println(mid);
    	    System.out.println(min);
    	}
}