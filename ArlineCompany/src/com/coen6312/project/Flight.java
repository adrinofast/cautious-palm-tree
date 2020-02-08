package com.coen6312.project;

import java.time.LocalTime;
import java.util.List;

public class Flight {
	
	private String  flightNumber;
	private String  departureDate;
	private LocalTime departureTime;
	private String arrivalDate;
	private LocalTime arrivalTime;
	private String flightDuration;
	private String fightCapacity;
	
	private LocalTime estimatedArrivalTime;
	
	private String flightDelay;
	
    private List<Passenger> passengerDetails;
    
	private List<Employee> employeeList;
	
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	
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

	public String getFlightDelay() {
		return flightDelay;
	}

	public void setFlightDelay(String flightDelay) {
		this.flightDelay = flightDelay;
	}

	public List<Passenger> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<Passenger> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public void addBooking(Booking b)
	{
		
	}
	
	public void cancelBooking()
	{
		
	}
	
	public void cancelAllBookings()
	{
		
	}

	@Override
	public String toString() {
		return "\n Flight [flightNumber=" + flightNumber + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", flightDuration="
				+ flightDuration + ", fightCapacity=" + fightCapacity + ", estimatedArrivalTime=" + estimatedArrivalTime
				+ ", flightDelay=" + flightDelay + ", passengerDetails=" + passengerDetails + ", employeeList="
				+ employeeList + ", sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport
				+ "]";
	}

	
	
	
	
	
	

}
