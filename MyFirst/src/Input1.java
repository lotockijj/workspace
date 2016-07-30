	/* —понсор - это звучит гордо
	¬вести с клавиатуры два имени и вывести надпись:
	name1 проспонсировал name2, и она стала известной певицей.
	ѕример:
	 ол€ проспонсировал Ћену, и она стала известной певицей.
	*/

	import java.util.Scanner;

	public class Input1{
	    public static void main(String[] args) throws Exception
	    {
	    	Scanner r = new Scanner(System.in); 
	    	String name1 = r.nextLine(); 
	    	String name2 = r.nextLine();
	    	System.out.println(name1 + "проспонсировал " + name2 + " и она стала известой певицей.");
	        r.close();
	    	//напишите тут ваш код

	    }
	}
