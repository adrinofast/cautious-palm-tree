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
	
	private  static  int numberSuffix= 1;
	private String flightState = "PLANNED";
	
	private String  flightNumber;
	private String  departureDate;
	private LocalTime departureTime;
	private String arrivalDate;
	private LocalTime arrivalTime;
	private String flightDuration;
	private String fightCapacity;
	
	private ArrayList<String> arrangment ;
	
	
	private AirlineComapny airlineBelongsto;

	
	private LocalTime estimatedArrivalTime;
	
	private long flightDelay;
	
    private List<Booking> Bookingdetails  = new ArrayList<Booking>();
    	
	private List<Employee> employeeList;
	
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	
	
	
	
	public String getFlightState() {
		return flightState;
	}

	public void setFlightState(String flightState) {
		this.flightState = flightState;
	}

	public ArrayList<String> getArrangment() {
		return arrangment;
	}

	public void setArrangment(ArrayList<String> arrangment) {
		this.arrangment = arrangment;
	}

	public AirlineComapny getAirlineBelongsto() {
		return airlineBelongsto;
	}

	public void setAirlineBelongsto(AirlineComapny airlineBelongsto) {
		this.airlineBelongsto = airlineBelongsto;
	}

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

	public void setFlightNumber() {
		String generateFlightNumber = this.generateFlightNumber();
		this.flightNumber = generateFlightNumber;
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
		int bookingExist =0;
		for(Booking bbb : this.Bookingdetails)
		{
			if((bbb.getFlight().getFlightNumber() == b.getFlight().getFlightNumber())&&(bbb.getPassnger().getName() == b.getPassnger().getName()))
			{
				bookingExist =1;
				break;
			}
		}
		
		if(bookingExist==1)
		{
			this.Bookingdetails.add(b);
		}
		
		
	}
	
	public void cancelBooking(Booking b)
	{
		int size  = Bookingdetails.size();
		Bookingdetails.forEach(bd->{
			if(bd.equals(b))
			{
				int indexOf = this.Bookingdetails.indexOf(b);
				System.out.println("the index is " + " " + indexOf);
				this.Bookingdetails.remove(indexOf);
			}
		});
		
		if(size > Bookingdetails.size() )
		{
			System.out.println("Sucessfully canxcelled the booking");
		}
		else
		{
			System.out.println("You have NO Booking avaible to cancel");
		}
		
	}
	
	public void cancelAllBookings()

	{
		
		if(Bookingdetails.size() > 0)
		{
			int listBookings = this.Bookingdetails.size();
			for(int i =1 ; i<listBookings ; i++)
			{
				this.Bookingdetails.remove(0);
			}
			
			
			  
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

	public String generateFlightNumber()
	{
		String flightNumberPrefix = null;
		 flightNumberPrefix = this.getSourceAirport().getAirportCode().substring(0, 2) + this.getDestinationAirport().getAirportCode().substring(0, 2);
		 String suffix  = Integer.toString(++numberSuffix).format("%02d", numberSuffix);
		 String flightNumber = flightNumberPrefix+suffix;
		 System.out.println("the fial number is"  + " " + flightNumber);
		 
		return flightNumber;
		
	}
	
	
	public ArrayList<String> generateSeatingArrangement()
	{
		int cap = Integer.parseInt(this.getFightCapacity());
		int capPat = cap/26;
		int capRem = cap%26;
		System.out.println("the cappat is " + " "  +capPat);
		System.out.println("the caprem is " + " "  +capRem);
		
		String strr;
		ArrayList<String> arrange =  new ArrayList<String>();
		ArrayList<Integer> numarr = new ArrayList<Integer>();
		
		int a =65;
		
		for(int i =0;i<capPat;i++) 
		{
			++a;
			numarr.add(a);
		}
		for(int j=0;j<numarr.size(); j++)
		{
			int c = 65;
			c = c+j;
			char ch =  (char)c;
			
			 strr = Character.toString(ch);
			
			for(int k =1 ;k<=26 ; k++)
			{
				String seatsArr = null;
				
				String sufffix = Integer.toString(k).format("%02d", k);
				String finalar = strr+sufffix;
				arrange.add(finalar);
			}
			
		}
		
		System.out.println(arrange.toString());
		return arrange;
	}
	
	

}
