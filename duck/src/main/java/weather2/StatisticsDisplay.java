package weather2;

import java.util.Observable;
import java.util.Observer;
import wheather.DisplayElement;

public class StatisticsDisplay implements DisplayElement, Observer {
	
	Observable observable;
	private float temperature;
	
	private float avg;
	private float max;
	private float min;
	private int count;
	
	public StatisticsDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherData){
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			display();
		}
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
