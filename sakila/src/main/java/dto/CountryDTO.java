package dto;

public class CountryDTO {
	private String  country;
	private String city;
	private String ditrict;
	public CountryDTO() {
		super();
	}
	public CountryDTO(String country, String city, String ditrict) {
		super();
		this.country = country;
		this.city = city;
		this.ditrict = ditrict;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDitrict() {
		return ditrict;
	}
	public void setDitrict(String ditrict) {
		this.ditrict = ditrict;
	}
	
}
