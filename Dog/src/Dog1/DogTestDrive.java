package Dog1;

public class DogTestDrive {
	public static void main(String[] args){
		Dog dog1 = new Dog();
		dog1.weight = 70;
		Dog dog2 = new Dog();
		dog2.weight = 40;
		Dog dog3 = new Dog();
		dog3.weight = 20;
		
		dog1.bark();
		dog2.bark();
		dog3.bark();
	}

}
