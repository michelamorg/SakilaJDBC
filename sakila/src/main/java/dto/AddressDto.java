package dto;

public class AddressDto {
private String last_name;
private String email;
private String address;
private String city;

public AddressDto() {

}

public AddressDto(String last_name, String email, String address, String city) {
	
	this.last_name = last_name;
	this.email = email;
	this.address = address;
	this.city = city;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}




}
