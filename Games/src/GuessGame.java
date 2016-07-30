import java.util.Scanner;

public class GuessGame{
	public static Scanner m;
	
	public void startGame(){
		
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
		
		int targetNumber = (int)(Math.random()*10);
		System.out.println("Я задаю число від 0 до 9 ");
		do{
		m = new Scanner(System.in);
		guessp1 = m.nextInt();
		guessp2 = m.nextInt(); 
		guessp3 = m.nextInt(); 
		}while(guessp1==targetNumber || guessp2==targetNumber || guessp3==targetNumber);
		if(guessp1==targetNumber || guessp2==targetNumber || guessp3==targetNumber){
			System.out.println("Перший гравець думає це число  " + guessp1);
			System.out.println("Другий гравець думає це число  " + guessp2);
			System.out.println("Третій гравець думає це число  " + guessp3);
			if(guessp1==targetNumber){
				p1isRight = true;
			}
			if(guessp2==targetNumber){
				p2isRight = true;
			}
			if(guessp3==targetNumber){
				p3isRight = true;
			}
			if(p1isRight||p2isRight||p3isRight){
				System.out.println("В нас є переможець!");
				System.out.println("Перший гравець вгадав?" + p1isRight);
				System.out.println("Другий гравець вгадав?" + p2isRight);
				System.out.println("Третій гравець вгадав?" + p3isRight);
			}
		}
	}
}
