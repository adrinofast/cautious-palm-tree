package com.coen6312.project;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
// edied by phni in prsthyusha
=======
import java.time.Duration;
>>>>>>> Stashed changes
=======
import java.time.Duration;
>>>>>>> Stashed changes
import java.time.LocalTime;
import java.util.List;

public class Flight {
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
	
	
>>>>>>> Stashed changes
	private String  flightNumber;
	private String  departureDate;
	private LocalTime departureTime;
	private String arrivalDate;
	private LocalTime arrivalTime;
	private String flightDuration;
	private String fightCapacity;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
	private AirlineComapny airlineBelongsto;

>>>>>>> Stashed changes
	
	private LocalTime estimatedArrivalTime;
	
	private long flightDelay;
	
    private List<Booking> Bookingdetails;
    
	private List<Employee> employeeList;
	
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
	

	public List<Booking> getBookingdetails() {
		return Bookingdetails;
	}

	public void setBookingdetails(List<Booking> bookingdetails) {
		Bookingdetails = bookingdetails;
	}

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	}

	public List<Passenger> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<Passenger> passengerDetails) {
		this.passengerDetails = passengerDetails;
=======
>>>>>>> Stashed changes
	}

	public void addBooking(Booking b)
	{
		
	}
	
	public void cancelBooking()
	{
		
	}
	
	public void cancelAllBookings()
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	{
		
=======
=======
>>>>>>> Stashed changes

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
		 
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
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
