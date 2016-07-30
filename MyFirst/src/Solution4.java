import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution4 {
	 public static void main(String[] args) throws Exception{
	    	BufferedReader reader = new BufferedReader(new InputStreamReader (System.in)); 
	    	String s1 = reader.readLine();
	    	String s2 = reader.readLine();
	    	String s3 = reader.readLine();
	    	String s4 = reader.readLine();
	    	 try {
	    	    Integer i1 = Integer.valueOf(s1);
	    	    Integer i2 = Integer.valueOf(s2);
	    	    Integer i3 = Integer.valueOf(s3);
	    	    Integer i4 = Integer.valueOf(s4);
	    	    if (i1>i2 && i1>i3 && i1>i4){
	    	    System.out.print(i1);
	    	    }else if(i2>i1 && i2>i3 && i2>i4){
	    	    System.out.print(i2);
	    	    }else if(i3>i2 && i3>i1 && i3>i4){
	    	    	System.out.print(i3);
	    	    } 
	    	    else if(i4>i2 && i4>i1 && i4>i3){
	    	    	System.out.print(i4);
	    	    } 
	    	    }catch (NumberFormatException e) {
	    	    System.err.println("Ќеверный формат строки!");
	        //напишите тут ваш код
	    	    }
	    	}	
	   }