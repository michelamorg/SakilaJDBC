package dto;

public class ActorDto2 {

	private String title;
	private String languageName;
	private String categoryName;
	public ActorDto2() {
		
		super();
	}
	public ActorDto2(String title, String languageName, String categoryName) {
		super();
		this.title = title;
		this.languageName = languageName;
		this.categoryName = categoryName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
