package main.controller;

import java.util.ArrayList;

/**
 * This is the class which's got the specification of a city:
 * his name, longitude and latitude. Also a specific id.
 * @author Mathieu
 */
public class City 
{
	private String id;
	private String name;
	private float lon;
	private float lat;
	private String country;
	
	

	/**
	 * Constructor
	 */
	public City() {}
	
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getLon() {
		return lon;
	}



	public void setLon(float lon) {
		this.lon = lon;
	}



	public float getLat() {
		return lat;
	}



	public void setLat(float lat) {
		this.lat = lat;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}






}
