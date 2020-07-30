package service;

import java.util.List;

import dto.CategoryDto;
import dto.FilmDto2;

public interface CategoryService {

	
	List<CategoryDto> dataCat(String categoryName);
}
