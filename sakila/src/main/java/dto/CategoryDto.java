package dto;

public class CategoryDto {
private String title;
private String first_name;
private String Last_name;


public CategoryDto() {
	super();
}


public CategoryDto(String title, String first_name, String last_name) {
	super();
	this.title = title;
	this.first_name = first_name;
	Last_name = last_name;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getFirst_name() {
	return first_name;
}


public void setFirst_name(String first_name) {
	this.first_name = first_name;
}


public String getLast_name() {
	return Last_name;
}


public void setLast_name(String last_name) {
	Last_name = last_name;
}


}
