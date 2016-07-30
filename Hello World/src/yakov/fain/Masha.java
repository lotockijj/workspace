package yakov.fain;

public class Masha {

	public static void main(String[] args) {
		String gfriend = "Masha";
		if(gfriend == "Masha"){
			System.out.println("gfriend == Masha");
		} else { System.out.println("gfriend no == Masha");
		}
		
		String gf1 = new String("Natasha");
		String gf2 = new String("Natasha");
		System.out.println("gf1 == gf2 " + gf1 == gf2);
	}

}
