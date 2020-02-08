package com.coen6312.project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public abstract class AirlineComapny {
	
	
	
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
