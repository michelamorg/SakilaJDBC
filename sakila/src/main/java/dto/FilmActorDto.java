package dto;

public class FilmActorDto {
private String title;
private String description;
private String last_update;

public FilmActorDto() {
	
}

public FilmActorDto(String title, String description, String last_update) {
	
	this.title = title;
	this.description = description;
	this.last_update = last_update;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getLast_update() {
	return last_update;
}

public void setLast_update(String last_update) {
	this.last_update = last_update;
}


}
