package com.coen6312.project;


import java.util.ArrayList;

/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/


import java.util.List;

public class Employee extends Person{
	
	private static int empID = 0;
	
	private int employeeId;
    private  String role;
    private List<Employee> superWises = new ArrayList<Employee>(10);
    
    
    private List<Flight> FlightDetails;
    
    public void displayAllEmployees(List<Employee> emplist)
    {
    	for(Employee e : emplist)
    	{
    		System.out.println("Employee Id : " +  e.getEmployeeId() + " " + "Employee Name : " + e.getName() + " " + "Employee Address : " + e.getAddress() + " " + "Employee Role : " + e.getRole() );
    		
    	
    	}
    }
     
	public List<Employee> getSuperWises() {
		return superWises;
	}




	public void setSuperWises(List<Employee> superWises) {
		if(this.superWises.size()< 11 && this.role=="Manager")
		{
			this.superWises = superWises;
		}
		else
		{
			System.out.println("Crossed maximum limit to superwise");
		}
		
	}
	public List<Flight> getFlightDetails() {
		return FlightDetails;
	}

	public void setFlightDetails(List<Flight> flightDetails) {
		FlightDetails = flightDetails;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId() {
		this.employeeId = ++empID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "Employee [employeeId=" + employeeId + ", role=" + role +  ", name=" + name
				+ ", address=" + address + ", telephone=" + telephone + ", email=" + email + "]";
	}
    
   

}
