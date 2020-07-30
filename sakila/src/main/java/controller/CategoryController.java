package controller;

import service.CategoryService;
import serviceImpl.CategoryServiceImpl;

public class CategoryController {

	CategoryService categoryService = new CategoryServiceImpl();

	public void joinDataCat(String categoryName) {
		categoryService.dataCat(categoryName);
	}
}
