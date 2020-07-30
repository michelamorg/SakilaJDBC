package model;

import java.io.Serializable;

public class Customer implements Serializable { //rende un oggetto persistente

	private int customer_id;
	private int store_id;
	private String first_name;
	
	private String last_name;
	private String email;
	private int address_id;
	private String active;
	private String create_date;
	private String last_update;
	
	public Customer() {
		super();
	}
	
	
	public Customer(int customer_id, int store_id, String last_name,String first_name, String email, int address_id, String active,
			String create_date, String last_update) {
		super();
		this.customer_id = customer_id;
		this.store_id = store_id;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
	}


	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String time_update) {
		this.last_update = time_update;
	}
	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
}

