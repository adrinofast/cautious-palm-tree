package com.coen6312.project;


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



}
