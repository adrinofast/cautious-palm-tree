package com.coen6312.project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public  class AirlineComapny {
	
	private static AirlineComapny singleObject = null; 
	
	private  AirlineComapny()
	{
		
	}
	
	 public static AirlineComapny getInstance() 
	    { 
	        if (singleObject == null) 
	        	singleObject = new AirlineComapny(); 
	  
	        return singleObject; 
	    } 		
	
	private List<Flight> Flights;
	
	private List<String> airportList;
	
	private List<City> cities;
	
	public long flightDelay(Flight flight)
	{
		Duration  delay = Duration.between(flight.getEstimatedArrivalTime(), flight.getArrivalTime());
		
		
		return delay.toMinutes();
		
	}
	
	public void  getAirports()
	{
		
	}
	
	public void getCities()
	{
		
	}

}
