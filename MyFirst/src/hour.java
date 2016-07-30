
public class hour {
	
	     public static int convertToSeconds(int hour){
	        hour = hour *3600; 
	         return hour; 
	     }

	    public static void main(String[] args) {
	        int a = convertToSeconds(10);
	        int b = convertToSeconds(1); 
	        System.out.println(a);
	        System.out.println(b);
	        }
}