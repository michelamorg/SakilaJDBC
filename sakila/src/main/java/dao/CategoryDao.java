package dao;

import java.util.List;

import dto.CategoryDto;


public interface CategoryDao {
	
public List<CategoryDto> dataCategory(String categoryName);
}
