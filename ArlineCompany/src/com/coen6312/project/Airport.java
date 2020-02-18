package com.coen6312.project;


/*
-----------Subitted By----------
Vishnu PhaniTeja Devarapu  Id: 40118286
Prathyusha Lngaladinne     Id: 40116307

*/


import java.util.List;

public class Airport {
	private static int  aId = 0;
	
	private int airportId;
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
	
	
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId() {
		this.airportId = ++aId;
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
	public void displayAllAirports(List<Airport> airportList) {
		
		for(Airport aa :airportList )
		{
			System.out.println("Airport Id:" + aa.getAirportId() + " "+  "Airport Name: " + aa.getAirportName() + " " + "Airport Code: " + aa.getAirportCode() + " " 
					  + "Aiport City: " + aa.getCityDetails().getCityName());
		}
	}
	
	
	
	

}
