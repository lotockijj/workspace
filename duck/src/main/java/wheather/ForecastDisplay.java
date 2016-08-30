package wheather;

public class ForecastDisplay implements Observer{
	
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherData;
	private int count;
	private float currentPressure;

	public ForecastDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	public void display() {
		if(currentPressure < pressure){
			System.out.println("Forecast: improving weather on the way...");
			currentPressure = pressure;
		} else if(currentPressure > pressure){
			System.out.println("Forecast: Watch out for cooler, rainy weather...");
			currentPressure = pressure;
		} else if(currentPressure == pressure){
			System.out.println("Forecast: More of the same");
			currentPressure = pressure;
		}
	}
	
}
