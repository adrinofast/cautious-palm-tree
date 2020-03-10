package com.coen6312.project;

/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/

import java.util.ArrayList;

/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/

import java.util.List;

public class Booking {
	
	private int bookingId;
	private String seatNumber;
	private Passenger passnger;
	private Flight flight;
	
	
	private String bookingState = "INTIATED";

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Passenger getPassnger() {
		return passnger;
	}

	public void setPassnger(Passenger passnger) {
		this.passnger = passnger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	

	public String getBookingState() {
		return bookingState;
	}

	public void setBookingState(String bookingState) {
		this.bookingState = bookingState;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seatNumber=" + seatNumber + ", passnger=" + passnger + ", flight="
				+ flight + "] ";
	}

	public void displayAllBookings(List<Booking> bookingListGlobal) {
		for(Booking book : bookingListGlobal)
		{
			System.out.println("Booking Id: " + book.getBookingId() + "  " + "Booking Passenger Name: " + book.getPassnger().getName() + " " + "Booking Flight: " + book.getFlight().getFlightNumber()
					+ " " + "Booked Seat number " + book.seatNumber + " " + "Flight Arrival: " + book.getFlight().getSourceAirport() + " " + "Flight Destination: " + book.getFlight().getDestinationAirport()
					
					
					);
		}
		
	}
	
	public int checkBooking(Flight f, Booking bookng)
	{
		int status = 0;
		int count = f.getBookingdetails().size();
		if(count >1)
		{
			List<Booking> bookingdetails = f.getBookingdetails();
			
			for(Booking bb : bookingdetails)
			{
			
				if((bb.getPassnger().getName().equals(bookng.getPassnger().getName())) &&(bb.getPassnger().getTelephone().equals(bookng.getPassnger().getTelephone())))
				{
					status=1;
				System.out.println("You have already booking for this flight !! You CANNOT book" );
				break;
				}
			}
		}
		
	return status;
	}
	
	public  String seatAllotment(Flight f)
	{
		int noOfBookings=  f.getBookingdetails().size();
		ArrayList<String> arrangmentBook = f.getArrangment();
		 String string = arrangmentBook.get(noOfBookings);
		 System.out.println("the seat allotment is " + " " +string);
		 return string;
	}


}
