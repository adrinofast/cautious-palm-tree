package com.coen6312.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.DateTimeSyntax;

public class Main {
	
	static List<Flight> flightListGlobal ;
	
	static List<Passenger> passengerListGlobal ;
	static List<Booking>    bookingListGlobal;
	static List<Employee>  employeeListGlobal;
	static List<City> cityListGlobal;
	

	public static void main(String[] args) {
		
		
		employeeListGlobal = new ArrayList<Employee>();
		cityListGlobal = new ArrayList<City>();
		//Cities Info
		City c1 = new City("Montreal","CA-QUB");c1.setCityId();
		City c2 = new City("Vancover", "CA-BC");c1.setCityId();
		City c3 = new City("Hyderabad", "IN-AND");c1.setCityId();
		City c4 = new City("Bangalore", "IN-KAR");c1.setCityId();
		
		 
	
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
				Passenger pass1 = new Passenger();
				 List<Passenger> passList = new ArrayList<Passenger>();
				
				 pass1.setName("Sreekar");
				 pass1.setAddress("montreal");	
				passList.add(pass1);
		
				Passenger pass2 = new Passenger();
				 List<Passenger> passList2 = new ArrayList<Passenger>();
				
				 pass2.setName("Madem Porche");
				 pass2.setAddress("Nellore");	
				passList2.add(pass2);
				
				Passenger pass3 = new Passenger();
				
				 pass3.setName("Phani");
				 pass3.setAddress("RRL");	
				 
				 passengerListGlobal = new ArrayList<Passenger>();
				 passengerListGlobal.add(pass1);
				 passengerListGlobal.add(pass2);
				 passengerListGlobal.add(pass3);
		
				
				
		// FLight Details
		
		Flight f1 = new Flight();
		f1.setFlightNumber("A123");
		f1.setSourceAirport(a1);
		f1.setFightCapacity("200");
		f1.setDestinationAirport(a3);
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
		f2.setDestinationAirport(a4);
	   LocalDate dt1 = LocalDate.now();
//	   LocalDateTime plusDays1 = LocalDateTime.from(dt1.atStartOfDay()).plusDays(1);
//	   
//	   System.out.println(plusDays1);
	   
	   f2.setArrivalTime(LocalTime.now().plusHours(5));;
	   f2.setDestinationAirport(a5);
	   
	   
	   flightListGlobal = new ArrayList<Flight>();
	   flightListGlobal.add(f1);
	   flightListGlobal.add(f2);

		
		//Employee or Crew Details
	   
		List<Employee>  employeeList = new ArrayList<Employee>();
		Employee e1= new Employee();
		e1.setEmployeeId();
		e1.setAddress("India");
		e1.setName("Harry Porter");
		
		Employee e2 = new Employee();
		e2.setEmployeeId();
		e2.setName("Ian Maddox");
		e2.setAddress("Australia");
		
		Employee e3 = new Employee();
		e3.setEmployeeId();
		e3.setName("Willam Henry");
		e3.setAddress("England");
		
		employeeList.add(e2);
		employeeList.add(e1);
		
		employeeListGlobal.add(e1);
		employeeListGlobal.add(e2);
		employeeListGlobal.add(e3);
		
		
		f1.setEmployeeList(employeeList);
		
		
		// Booking Details
				Booking b1 = new Booking();
				b1.setBookingId(1);
				b1.setPassnger(pass1);
				b1.setFlight(f1);
				b1.setSeatNumber("D4");
				
				
				Booking b2 = new Booking();
				b2.setBookingId(2);
				b2.setPassnger(pass2);
				b2.setFlight(f1);
				b2.setSeatNumber("C4");
				
				
				Booking b3 = new Booking();
				b3.setBookingId(3);
				b3.setPassnger(pass3);
				b3.setFlight(f2);
				b3.setSeatNumber("A4");
				
				bookingListGlobal = new ArrayList<Booking>();
				
				bookingListGlobal.add(b3);
				bookingListGlobal.add(b2);
				bookingListGlobal.add(b1);
				
				
				
				List<Booking> bookingList = new ArrayList<Booking>();
				bookingList.add(b1);
				bookingList.add(b2);
				
				List<Booking> bookingList2 = new ArrayList<Booking>();
				bookingList2.add(b3);
				
				//Adding booking to flight
				f1.setBookingdetails(bookingList);
				//f1.addBooking(b3);
				
				f2.setBookingdetails(bookingList2);
				
				
				//Adding booking to passenger
				
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
				System.out.println("5.Add an Employee");
				System.out.println("6.To display items ");
				
				
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
					  
				  case 5:
					  Employee empadd = new Employee();
					  Scanner inp = new Scanner(System.in);
					  System.out.println("Enter the Employee name");
					  
					  empadd.setName(inp.nextLine());
					  empadd.setEmployeeId();
					  System.out.println("Enter the Employee email");
					  empadd.setEmail(inp.nextLine());
					  System.out.println("Enter the Employee Phone");
					  empadd.setEmail(inp.nextLine());
					  System.out.println("Enter the Employee Address");
					  empadd.setEmail(inp.nextLine());
					  employeeListGlobal.add(empadd);
					  empadd.displayAllEmployees(employeeListGlobal);
				  case 6:
					  displayItems();
				  default:
				    // code block
				}


	}
	
	
	private static void displayItems() {
		
		System.out.println("Please select the followig option");
		System.out.println("1.To do display all Cities");
		System.out.println("2.To do display all Airports");
		System.out.println("3.To do display all Flights");
		System.out.println("4.To do display all Employees");
		System.out.println("5.To do display all Bookings");
		
		Scanner disItem = new Scanner(System.in);
		int selectedOptionDis = disItem.nextInt();
		switch(selectedOptionDis) {
		  case 1:
			  City cty = new City();
			  cty.displayAllCities(cityListGlobal);
		  case 2:
			  Airport aa = new Airport();
			  aa.displayAllAirports();
		  case 3:
			  Flight ff = new Flight();
			  ff.displayAllFlights(flightListGlobal);
		  case 4:
			  Employee ee= new Employee();
			  ee.displayAllEmployees(employeeListGlobal);
		  case 5:
			  Booking bb =new Booking();
			  bb.displayAllBookings(bookingListGlobal);
		
	}
}


	public static void addBookingDetails(ArrayList<Flight> flights)
	{
		
		System.out.println("The Flights availble are below");
		Scanner flightDet = new Scanner(System.in);
		Flight flightforBooking = null;
		
		for(Flight fli : flights)
		{
			System.out.println(fli.toString());
			System.out.println(fli.getFlightNumber());
			System.out.println(fli.getDestinationAirport().getAirportCode());
			System.out.println(fli.getSourceAirport().getAirportCode());
			
			System.out.println(fli.getFlightNumber() + "  " + fli.getSourceAirport().getAirportCode() + " " + fli.getDestinationAirport().getAirportCode());
		}
		
		System.out.println("Enter the Flight NUmber");
		String flightNum =flightDet.nextLine();
		for(Flight fli : flights)
		{
			if(fli.getFlightNumber().equals(flightNum))
			{
				flightforBooking = fli;
			}
				
		}
		
		Passenger addingPassengerDetails = addingPassengerDetails();
		
		Booking B1 = new Booking();
		B1.setBookingId(01);
			B1.setPassnger(addingPassengerDetails);
		   B1.setFlight(flightforBooking);
		
		   
		   System.out.println("Pleaase Confim the Booking by typing Y character");
		   if(flightDet.nextLine().equals("Y"))
		   {
			   B1.setSeatNumber("K5");
			   flightforBooking.addBooking(B1);
			   addingPassengerDetails.setBookingDetails(B1);
			   passengerListGlobal.add(addingPassengerDetails);
			   flightListGlobal.add(flightforBooking);
			   bookingListGlobal.add(B1);
			   
			   System.out.println("Booking has been sucessful");
			   System.out.println("Please fine the Iernary");
			   System.out.println("Pasenger Name : " + " " + B1.getPassnger().getName() + " " + "Flight Number : " + " " + B1.getFlight().getFlightNumber());
			   
			   
		   }
		   
		   
	}
	
	
	
	public static Passenger addingPassengerDetails()
	{
		Scanner passKey = new Scanner(System.in);
		Passenger P1 = new Passenger();
		System.out.println("Enter the Passenger Details");
		System.out.println("Enter the Passenger Name");
		P1.setName(passKey.nextLine());
		System.out.println("Enter the Passenger Email");
		P1.setEmail(passKey.nextLine());
		System.out.println("Enter the Passenger Telephone");
		P1.setTelephone(passKey.nextLine());
		System.out.println("Enter the Passenger Address");
		P1.setAddress(passKey.nextLine());
		
		return P1;
		
	}
	
	public static void printDetails()
	{
		System.out.println("No of Flights : " + " " +flightListGlobal.size() );
		System.out.println("No of Total passengers in all flights : " + " " + passengerListGlobal.size());
		System.out.println("No of Bookings in total : " + " " +bookingListGlobal.size() );
	}

}
