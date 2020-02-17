package com.coen6312.project;

import java.util.List;

public class Employee extends Person{
	
	private static int empID = 4;
	
	private int employeeId;
    private  String role;
    private String Manager;
    
    private List<Flight> FlightDetails;
    
    public void displayAllEmployees(List<Employee> emplist)
    {
    	for(Employee e : emplist)
    	{
    		System.out.println("Employee Id : " +  e.getEmployeeId() + " " + "Employee Name : " + e.getName() + " " + "Employee Address : " + e.getAddress() );
    		
    	
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




	public String getManager() {
		return Manager;
	}




	public void setManager(String manager) {
		Manager = manager;
	}




	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", role=" + role + ", Manager=" + Manager + ", name=" + name
				+ ", address=" + address + ", telephone=" + telephone + ", email=" + email + "]";
	}
    
    
    
	
	

}
