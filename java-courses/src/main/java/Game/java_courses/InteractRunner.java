package Game.java_courses;

import java.util.Scanner;

public class InteractRunner{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		try{
			Calculator calc = new Calculator();
			String exit = "no";
			
			while(!exit.equals("yes")){
				System.out.println("Enter first arg :");
				String first = reader.next();
				System.out.println("Enter second arg :");
				String second = reader.next();
				//calc.add(Integer.valueOf(first), Integer.valueOf(second));
				
				try {
					calc.div(Integer.valueOf(first), Integer.valueOf(second));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (UserException e) {
					System.out.println(e.getMessage());
					System.out.println("Please enter two argument!!!");
				}
				
				System.out.println("Result : " + calc.getResult());
				calc.clearResult();
				System.out.println("Exit : yes/no ");
				exit = reader.next();
			}
		}
		finally{
			reader.close();
			}	
	}
}