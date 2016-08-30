package wheather;

public class StatisticsDisplay implements Observer, DisplayElement{
	
	private float temperature;
	private Subject weatherData;
	
	private float avg;
	private float max;
	private float min;
	private int count;
	
	public StatisticsDisplay(Subject weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		display();
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + getAvarege() + 
				"/" + getMax() + "/" + getMin());
	}
	
	private float getAvarege(){
		count++;
		avg = (avg*(count - 1) + temperature)/count;
		return avg;
	}
	
	private float getMax(){
		if(max <= temperature){
			max = temperature;
		} 
		return max;
	}
	
	private float getMin(){
		if(min >= temperature){
			min = temperature;
		} 
		return min;
	}
	
}
