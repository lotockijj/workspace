import java.io.*;
import java.util.Scanner;
public class Scannner {
	/* Скромность украшает человека
	Ввести с клавиатуры имя и вывести надпись:
	name зарабатывает $5,000. Ха-ха-ха!
	Пример: Тимур зарабатывает $5,000. Ха-ха-ха!
	*/

	    public static void main(String[] args) throws Exception
	    {
	        Scanner scanner = new Scanner(System.in);
	        
	        String name = scanner.nextLine(); 
	        String age = scanner.nextLine();
	        //напишите тут ваш код
	        System.out.println(name +" захопить світ за " + age + " років. Му-ха-ха!");
	        scanner.close();
	    }
	}

