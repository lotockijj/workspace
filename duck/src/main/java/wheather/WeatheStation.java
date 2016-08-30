package wheather;

public class WeatheStation {

	public static void main(String[] args) {
		
		WheatherData wheatherData = new WheatherData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(wheatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(wheatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(wheatherData);
		
		wheatherData.setMeasurements(80, 65, 30.4f);
		wheatherData.setMeasurements(82, 70, 29.2f);
		wheatherData.setMeasurements(78, 90, 29.2f);
		wheatherData.setMeasurements(74, 68, 31.3f);
		
	}

}
