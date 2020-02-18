package com.coen6312.project;


/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/
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
