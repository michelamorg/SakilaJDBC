package serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;

import dao.CategoryDao;
import daoImpl.CategoryDaoImpl;
import dto.CategoryDto;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private static final Logger log = Logger.getLogger(CategoryServiceImpl.class);
	
private CategoryDao categoryDao=new CategoryDaoImpl();

	public List<CategoryDto> dataCat(String categoryName) {
		List<CategoryDto> dataCat=categoryDao.dataCategory(categoryName);
		for (CategoryDto c : dataCat) {
			log.info(c.getTitle()+c.getFirst_name()+c.getLast_name());
		}
		return dataCat;
	}

}
