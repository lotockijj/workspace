package ClassOracle;

public class ACMEBicycle implements Bicycle{
	int cadence = 0; 
	int speed = 0; 
	int gear = 0;
	public void changeCadence(int newValue){
		cadence = newValue; 
	}
	public void changeGear(int newGear){
		gear = newGear; 
	}
	public void speedUp(int increment){
		speed = speed + increment;
	}
	public void applyBrakes(int decrement) {
        speed = speed - decrement;
   }
	void printState(){
		System.out.println("cadence =" + cadence + "; gear =" + gear + "; speed =" + speed);
	}

}
