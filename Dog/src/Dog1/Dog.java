package Dog1;

public class Dog {
	String name;
	int weight; 
	
	void bark(){
		if (weight>60){
			System.out.println("���! ���!! ���!!");
		}
		if (weight>30){
			System.out.println("���, ���.");
		} else{
			System.out.println("���");
		}
	}

}
