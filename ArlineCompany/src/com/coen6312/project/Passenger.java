package com.coen6312.project;

public class Passenger extends Person {
	
	
	private Booking BookingDetails;
	

	public Booking getBookingDetails() {
		return BookingDetails;
	}


	public void setBookingDetails(Booking bookingDetails) {
		BookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		return "\n Passenger [\n name=" + name + ", \n address=" + address + ", \n telephone="
				+ telephone + ", \n email=" + email + "]  ";
	}
	
	

	
	
	
  
}
