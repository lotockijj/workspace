package weather2;

import java.util.Observable;
import wheather.DisplayElement;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
	
	private float currentPressure = 29.92f;
	private float lastPressure;
	private Observable observable;
	
	public ForecastDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData =
					(WeatherData)observable;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	public void update(float temperature, float humidity, float pressure) {
	}
	
	public void display() {
		System.out.println("Current pressure: " + currentPressure +
				" Last pressure: " + lastPressure);
	}
}
