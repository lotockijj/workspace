import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FriendsAndFamily{
	
	static Path path = Paths.get("C:\\Пользователи\\Роман Лотоцький\\workspace\\Hello World\\src\\PlayingDeck.java");

	public static void main(String[] args) {
		
		System.out.println(path);
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.printf("getName(1): %s%n", path.getName(1));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("Enter list price:");
			double listPrice = input.nextDouble();
			System.out.println("Enter discount %: ");
			int discount = input.nextInt();
			System.out.printf("Your price is %s. Your discount is - %s", listPrice, discount);
			System.out.println();
		} while(true);
		
	}
}