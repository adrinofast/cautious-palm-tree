package com.coen6312.project;

import java.util.List;

public class Employee extends Person{
	
	private int employeeId;
    private  String role;
    private String Manager;
    
    private List<Flight> FlightDetails;
    
    
    
    
	public List<Flight> getFlightDetails() {
		return FlightDetails;
	}




	public void setFlightDetails(List<Flight> flightDetails) {
		FlightDetails = flightDetails;
	}




	public int getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
