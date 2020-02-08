package com.coen6312.project;

public class Passenger extends Person {
	
	
	private Flight flightDetails;
	

	
	public Flight getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(Flight flightDetails) {
		this.flightDetails = flightDetails;
	}
	@Override
	public String toString() {
		return "\n Passenger [\n name=" + name + ", \n address=" + address + ", \n telephone="
				+ telephone + ", \n email=" + email + "]  ";
	}
	
	

	
	
	
  
}
