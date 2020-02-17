package com.coen6312.project;

public class Airport {
	
	private String airportName;
	private String airportCode;
	private City cityDetails;
	private boolean sourceFlag;
	
	
	
						
	public Airport() {
		super();
	}
	public Airport(String airportName, String airportCode, City cityDetails) {
		super();
		this.airportName = airportName;
		this.airportCode = airportCode;
		this.cityDetails = cityDetails;
	}
	public City getCityDetails() {
		return cityDetails;
	}
	public void setCityDetails(City cityDetails) {
		this.cityDetails = cityDetails;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	
	public boolean isSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(boolean sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	@Override
	public String toString() {
		return "Airport [airportName=" + airportName + ", airportCode=" + airportCode + ", cityDetails=" + cityDetails
				+ ", sourceFlag=" + sourceFlag + "]";
	}
	public void displayAllAirports() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
