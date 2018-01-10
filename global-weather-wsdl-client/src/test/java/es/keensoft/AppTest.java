package es.keensoft;

import java.net.URL;

import es.keensoft.ws.client.weather.GlobalWeather;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testCities() throws Exception {

		GlobalWeather service = new GlobalWeather(new URL("http://www.webservicex.com/globalweather.asmx?WSDL"));
		String cities = service.getGlobalWeatherSoap().getCitiesByCountry("Spain");

		assertTrue(cities.startsWith("<NewDataSet>"));

	}

	public void testWeather() throws Exception {

		GlobalWeather service = new GlobalWeather(new URL("http://www.webservicex.com/globalweather.asmx?WSDL"));
		String weather = service.getGlobalWeatherSoap().getWeather("Zaragoza", "Spain");

		assertTrue(weather.equals("Data Not Found"));

	}
	
}
