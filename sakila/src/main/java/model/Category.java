package model;

public class Category {
private int category_id;
private String name;
private String last_update;


public Category() {
	super();
}


public Category(int category_id, String name, String last_update) {
	super();
	this.category_id = category_id;
	this.name = name;
	this.last_update = last_update;
}


public int getCategory_id() {
	return category_id;
}


public void setCategory_id(int category_id) {
	this.category_id = category_id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getLast_update() {
	return last_update;
}


public void setLast_update(String last_update) {
	this.last_update = last_update;
}


}
