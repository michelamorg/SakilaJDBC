package model;

import java.io.Serializable;

public class Country  implements Serializable{

	private int country_id;
	private String country;
	private String last_update;
	
	public Country() {
		super();
	}

	public Country(int country_id, String country, String last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
	
	
}


