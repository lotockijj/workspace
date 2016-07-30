package yakov.fain.lesson13;

public class BikeOrder {
	
	
	void validateOrder(String bikeModel, int quantity) throws TooManyBikesException{
		int value = 0; 
		
		switch(bikeModel){
			case "Model-123": value = 3;
			break;
			case "Aist-2" : value = 1;
			break;
			case "Java-3" : value = 2;
			break;
			case "Minsk-2": value = 4;
			break;
			case "Saturn-ss": value = 6;
			break;
		}  
		
		int fullValue = value*quantity;
		if(fullValue > 100){
			throw new TooManyBikesException("Can not ship " +
					quantity + " bikes of the model " + bikeModel);
		}
	}
}