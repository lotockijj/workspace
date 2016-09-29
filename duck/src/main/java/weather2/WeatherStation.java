package weather2;

public class WeatherStation {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		weatherData.setMeasurements(82, 60, 770);
		weatherData.setMeasurements(86, 80.2f, 870);

	}

}
