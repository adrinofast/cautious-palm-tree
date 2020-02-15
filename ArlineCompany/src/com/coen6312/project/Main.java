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
		
		System.out.println("hyd has" + " " + arrayList.size()  + arrayList.toString());
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
	   //LocalDateTime plusDays = LocalDateTime.from(dt.atStartOfDay()).plusDays(1);
	   
	   f1.setArrivalTime(LocalTime.now().plusHours(3));
	   f1.setEstimatedArrivalTime(LocalTime.now().plusHours(5));
	   
		Flight f2 = new Flight();
		
		f2.setFlightNumber("A456");
		f2.setSourceAirport(a2);
		f2.setFightCapacity("400");
		LocalTime time1 =  LocalTime.now();
		f2.setDepartureTime(time1);
	   LocalDate dt1 = LocalDate.now();
//	   LocalDateTime plusDays1 = LocalDateTime.from(dt1.atStartOfDay()).plusDays(1);
//	   
//	   System.out.println(plusDays1);
	   
	   f2.setArrivalTime(LocalTime.now().plusHours(5));;
	   f2.setDestinationAirport(a5);
<<<<<<< Updated upstream
=======
	   
	   
	   flightListGlobal = new ArrayList<Flight>();
	   flightListGlobal.add(f1);
	   flightListGlobal.add(f2);
>>>>>>> Stashed changes

		
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
				
				
				
<<<<<<< Updated upstream
		
=======
				pass1.setBookingDetails(b1);
				pass2.setBookingDetails(b2);
				pass3.setBookingDetails(b3);
				//System.out.println(flightListGlobal.toString());
				
		        System.out.println(" the cities list");
			System.out.println(f1.getDepartureTime() + " " + f1.getArrivalTime()+ "Delaysis " + f1.getFlightDelay());
				
				System.out.println("***************-------------**********-----------**************--------");
				printDetails();
				System.out.println("Please select the following optiions");
				System.out.println("1.Add another Booking");
				System.out.println("2.Cancel Booking");
				System.out.println("3.Cancel All Booking");
				System.out.println("4.Flight Delay Status");
				
				Scanner scanOpt = new Scanner(System.in);
				int selectedOption = scanOpt.nextInt();
				switch(selectedOption) {
				  case 1:
					  addBookingDetails((ArrayList<Flight>) flightListGlobal);
					  System.out.println("***************-------------**********-----------**************--------");
						printDetails();
				    break;
				  case 2:
				    System.out.println("Please Enter your Booking Id");
				    int bookingTobeCancelled = scanOpt.nextInt();
				   
				    for(int i=0 ;i<bookingListGlobal.size() ;i++)
				    {System.out.println("asdassacxnj ");
				    
				    	Booking bookng = bookingListGlobal.get(i);
				    	System.out.println(bookng.getBookingId());
				    
				    	if(bookng.getBookingId() == bookingTobeCancelled)
				    	{
				    		
				    		Flight flight = bookng.getFlight();	
				    		System.out.println(flight.getFlightNumber());
				    		flight.cancelBooking(bookng);
				    	
				    		int removal = bookingListGlobal.indexOf(bookng);
				    		bookingListGlobal.remove(removal);
				    		
				    		
				    	}
				    }
				    System.out.println("***************-------------**********-----------**************--------");
					printDetails();
				    break;
				  case 3:
					  System.out.println("Please Enter Flight Number to cancel all bookings");
					  String flightBokingtobeCancelled = scanOpt.nextLine();
					  for(Flight flight :flightListGlobal )
					  {
						  if(flight.getFlightNumber().equals(flightBokingtobeCancelled))
						  {
							  flight.cancelAllBookings();
						  }
					  }
				  case 4:
					  System.out.println("Please enter the Flight Details");
					  Scanner in = new Scanner(System.in);
					  String flightStatusNum = in.nextLine();
					 
					  for(Flight flight :flightListGlobal )
					  {
						  if(flight.getFlightNumber().equals(flightStatusNum))
						  {
							  flight.getFlightDelay();
						  }
					  }
					  
				  default:
				    // code block
				}


	}
	
	
	public static void addBookingDetails(ArrayList<Flight> flights)
	{
		
		System.out.println("The Flights availble are below");
		Scanner flightDet = new Scanner(System.in);
		Flight flightforBooking = null;
>>>>>>> Stashed changes
		
		System.out.println(b1.toString());
	
		
		

	}

}
