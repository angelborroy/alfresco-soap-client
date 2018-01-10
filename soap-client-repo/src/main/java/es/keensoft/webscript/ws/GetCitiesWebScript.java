package es.keensoft.webscript.ws;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;

import es.keensoft.ws.client.weather.GlobalWeather;

public class GetCitiesWebScript extends DeclarativeWebScript {

	private String url;

	protected Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache) {
		
		try {
			
			String country = req.getServiceMatch().getTemplateVars().get("country");
			
			GlobalWeather service = new GlobalWeather(new URL(url));
			String cities = service.getGlobalWeatherSoap().getCitiesByCountry(country);
	
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("cities", cities);
			return model;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void setUrl(String url) {
		this.url = url;
	}

}