package com.coen6312.project;

/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/


import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
	
	
	
	private String  flightNumber;
	private String  departureDate;
	private LocalTime departureTime;
	private String arrivalDate;
	private LocalTime arrivalTime;
	private String flightDuration;
	private String fightCapacity;
	
	private AirlineComapny airlineBelongsto;

	
	private LocalTime estimatedArrivalTime;
	
	private long flightDelay;
	
    private List<Booking> Bookingdetails  = new ArrayList<Booking>();
    	
	private List<Employee> employeeList;
	
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	
	

	public List<Booking> getBookingdetails() {
		return Bookingdetails;
	}

	public void setBookingdetails(List<Booking> bookingdetails) {
		Bookingdetails = bookingdetails;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getFightCapacity() {
		return fightCapacity;
	}

	public void setFightCapacity(String fightCapacity) {
		this.fightCapacity = fightCapacity;
	}

	public LocalTime getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}

	public void setEstimatedArrivalTime(LocalTime estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}

	public long getFlightDelay() {
		 long minutesDelay = Duration.between( this.getArrivalTime(),this.getEstimatedArrivalTime()).toMinutes();
		  
				  this.setFlightDelay(minutesDelay);
				  return minutesDelay;
	}

	public long setFlightDelay(long flightDelay) {
		return this.flightDelay = flightDelay;
	}

	
	public void addBooking(Booking b)
	{
		this.Bookingdetails.add(b);
		System.out.println(this.Bookingdetails.toString());
	}
	
	public void cancelBooking(Booking b)
	{
		int indexOf = this.Bookingdetails.indexOf(b);
		System.out.println("the index is " + " " + indexOf);
		this.Bookingdetails.remove(indexOf);
	}
	
	public void cancelAllBookings()

	{
		int listBookings = this.Bookingdetails.size();
		for(int i =1 ; i<listBookings ; i++)
		{
			this.Bookingdetails.remove(0);
		}
		
		
	}
	
	public long flightDelay(Flight flight)
	{
		
		 long minutesDelay = Duration.between(flight.getEstimatedArrivalTime(), flight.getArrivalTime()).toMinutes();
		  return flight.setFlightDelay(minutesDelay);
		 
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", flightDuration="
				+ flightDuration + ", fightCapacity=" + fightCapacity 
				+ ", estimatedArrivalTime=" + estimatedArrivalTime + ", flightDelay=" + flightDelay
				+ ", employeeList=" + employeeList + ", sourceAirport="
				+ sourceAirport + ", destinationAirport=" + destinationAirport + "]  + \"/n\"+";
	}

	public void displayAllFlights(List<Flight> flightListGlobal) {
		for(Flight fgt: flightListGlobal) 
		{
			System.out.println("Flight Number: " + fgt.getFlightNumber() + " " + "Flight Source Airport: " + fgt.getSourceAirport().getAirportName()
					+ " " + "Flight Destination Airport: " + fgt.getDestinationAirport().getAirportName()
					+ " " + "Flight Capacity: " + fgt.getFightCapacity()
					+ " " + "Flight arvial time " + fgt.getArrivalTime()
					+ " " + "Fligt dest time: " + fgt.getDepartureTime()
					+ " " + "Flight Status: " + fgt.getFlightDelay() + " " + "in Minutes"
					
					);
		}
		
	}

	
	
	
	
	
	

}
