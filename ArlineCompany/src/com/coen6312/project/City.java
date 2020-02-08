package com.coen6312.project;

import java.util.List;

public class City {
	
	private String cityName;
	private String cityZipcode;
	private List<Airport> airportList;
	
	
	
	

	public City(String cityName, String cityZipcode) {
		super();
		this.cityName = cityName;
		this.cityZipcode = cityZipcode;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", cityZipcode=" + cityZipcode + "]";
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityZipcode() {
		return cityZipcode;
	}

	public void setCityZipcode(String cityZipcode) {
		this.cityZipcode = cityZipcode;
	}

	public List<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}
	
	
	
	

}
