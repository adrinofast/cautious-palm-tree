package com.coen6312.project;

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

	

	
	

}
