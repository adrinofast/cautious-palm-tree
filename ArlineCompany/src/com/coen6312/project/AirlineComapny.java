package com.coen6312.project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


<<<<<<< Updated upstream
public abstract class AirlineComapny {
=======
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
>>>>>>> Stashed changes
	
	private List<Flight> Flights;
	
	private List<String> airportList;
	
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
