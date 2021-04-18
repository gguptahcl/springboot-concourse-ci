package com.gg.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController
public class HelloController {

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		/**
		 * Following code has been written to generate load on the server. Purpose of
		 * load generation was to test Auto Scaling Commented code has not been
		 * validated
		 **/

		/*
		 * long duration = 20000 ; double load = 0.8; for (int i=0 ; i <= 1000 ; i++){
		 * int sum = 2 * 2 ;
		 * 
		 * }
		 */
		/*
		 * for (int j=0 ; j <= 10 ; j++){ generateLoad(load, duration); }
		 * generateLoad(load, duration);
		 */
		System.out.println("bbbbbbb ");
		return "Greetings from Spring Boot Hello World Service! from build number 59";
	}

	@RequestMapping(value = "/hello/zip/{zipcode}", method = RequestMethod.GET)
	public String getWeatherForZip(@PathVariable("zipcode") String zipcode) {
		String url = "http://" + "weather-service:8080" + "/weather/zip/" + zipcode;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return "In Hello Service : Getting weather from weather service for Zip Code :" + result;
		} catch (Exception e) {
			return url;
		} // end catch
	}// end method

	@RequestMapping(value = "/hello/{zipcode}", method = RequestMethod.GET)
	public String getWeatherByCallingElb(@PathVariable("zipcode") String zipcode) {

		String elbUrl = env.getProperty("ELB_DNS");
		String weatherServicePort = env.getProperty("WEATHER_SERVICE_PORT");
		String url = "http://" + elbUrl + ":" + weatherServicePort + "/weather/zip/" + zipcode;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return result;
		} catch (Exception e) {
			return url;
		} // end catch
	}// end method

	/**
	 * This method is only for kubernetes deployment
	 **/

	@RequestMapping(value = "/hello/k8s/{zipcode}", method = RequestMethod.GET)
	public String getWeatherByCallingK8SOne(@PathVariable("zipcode") String zipcode) {

		String weatherServiceName = env.getProperty("WEATHER_SERVICE_NAME");
		// WEATHER_SERVICE_PORT will be used only if port is other than 80
		// String weatherServicePort = env.getProperty("WEATHER_SERVICE_PORT");
		String url = "http://" + weatherServiceName + "/weather/zip/" + zipcode;
		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			return result;
		} catch (Exception e) {
			return url;
		} // end catch
	}// end method

	/*
	 * @RequestMapping(value="/hello/k8s/{zipcode}", method = RequestMethod.GET)
	 * public String getWeatherByCallingK8S(@PathVariable("zipcode") String zipcode)
	 * {
	 * 
	 * String weatherServiceName = env.getProperty("WEATHER_SERVICE_NAME"); String
	 * weatherServicePort = env.getProperty("WEATHER_SERVICE_PORT"); String url =
	 * "http://"+weatherServiceName+":"+ weatherServicePort+ "/weather/zip/"+
	 * zipcode; try { RestTemplate restTemplate = new RestTemplate(); String result
	 * = restTemplate.getForObject(url, String.class); return result; } catch
	 * (Exception e) { return url ; }// end catch }// end method
	 */

	/**
	 * Following code has been written to generate load on the server. Purpose of
	 * load generation was to test Auto Scaling Commented code has not been
	 * validated
	 **/

	/*
	 * private void generateLoad(double load, long duration) { long startTime =
	 * System.currentTimeMillis(); try { // Loop for the given duration while
	 * (System.currentTimeMillis() - startTime < duration) { // Every 100ms, sleep
	 * for the percentage of unladen time if (System.currentTimeMillis() % 100 == 0)
	 * { Thread.sleep((long) Math.floor((1 - load) * 100)); } } } catch
	 * (InterruptedException e) { e.printStackTrace(); } }// end generateLoad
	 */
}// end class
