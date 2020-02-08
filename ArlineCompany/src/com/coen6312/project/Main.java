package com.coen6312.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.DateTimeSyntax;

public class Main {

	public static void main(String[] args) {
		
		
		
		//Cities Info
		City c1 = new City("Montreal","CA-QUB");
		City c2 = new City("Vancover", "CA-BC");
		City c3 = new City("Hyderabad", "IN-AND");
		City c4 = new City("Bangalore", "IN-KAR");
		
		 
	
		Airport a1 = new Airport("Montréal-Pierre Elliott Trudeau International Airport", "YUL", c1);
		
		Airport a2 = new Airport("Vancouver International Airport", "YVR", c2);
		Airport a3 = new Airport("Rajeev Gandhi International Airport", "HYD", c3);
		Airport a4 = new Airport("Begumpet Airport", "BGM", c3);
		Airport a5 = new Airport("Kempegowda International Airport", "BLR", c4);
		
		ArrayList<Airport> arrayList = new ArrayList<Airport>();
		arrayList.add(a1);
		c1.setAirportList(arrayList);
		arrayList.remove(0);
		arrayList.add(a2);
		c2.setAirportList(arrayList);
		arrayList.remove(0);
		arrayList.add(a3);
		arrayList.add(a4);
		c3.setAirportList(arrayList);
		
		arrayList.remove(0);
		
		arrayList.remove(0);
		arrayList.add(a5);
		c4.setAirportList(arrayList);
		
		
		
		// Passenger Details
				Passenger pass = new Passenger();
				 List<Passenger> passList = new ArrayList<Passenger>();
				
				pass.setName("Sreekar");
				pass.setAddress("montreal");	
				passList.add(pass);
		
				
		// FLight Details
		
		Flight f1 = new Flight();
		f1.setFlightNumber("A123");
		f1.setSourceAirport(a1);
		f1.setFightCapacity("200");
		LocalTime time =  LocalTime.now();
		f1.setDepartureTime(time);
	   LocalDate dt = LocalDate.now();
	   LocalDateTime plusDays = LocalDateTime.from(dt.atStartOfDay()).plusDays(1);
	   f1.setDepartureTime(plusDays.toLocalTime());
	   
		Flight f2 = new Flight();
		
		f2.setFlightNumber("A456");
		f2.setSourceAirport(a2);
		f2.setFightCapacity("400");
		LocalTime time1 =  LocalTime.now();
		f2.setDepartureTime(time1);
	   LocalDate dt1 = LocalDate.now();
	   LocalDateTime plusDays1 = LocalDateTime.from(dt1.atStartOfDay()).plusDays(1);
	   f2.setDepartureTime(plusDays1.toLocalTime());
	   f2.setDestinationAirport(a5);

		
		//Employee or Crew Details
	   
		List<Employee>  employeeList = new ArrayList<Employee>();
		Employee e1= new Employee();
		e1.setAddress("India");
		e1.setName("Con");
		Employee e2 = new Employee();
		e2.setName("boby");
		e2.setAddress("AUS");
		
		employeeList.add(e2);
		employeeList.add(e1);
		
		f1.setEmployeeList(employeeList);
		
		
		// Booking Details
				Booking b1 = new Booking();
				b1.setBookingId(1);
				b1.setPassnger(pass);
				b1.setFlight(f1);
				b1.setSeatNumber("D4");
				
				
				
		
		
		System.out.println(b1.toString());
	
		
		

	}

}
