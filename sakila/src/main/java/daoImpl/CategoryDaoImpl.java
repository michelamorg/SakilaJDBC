package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.CategoryDao;
import dto.CategoryDto;
import dto.FilmDto2;
import model.Category;
import utilis.DbConn;

public class CategoryDaoImpl implements CategoryDao {
	private static final Logger log = Logger.getLogger(CategoryDaoImpl.class);
	
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private List<CategoryDto> listDto;
	
	public List<CategoryDto> dataCategory(String categoryName) {
		try {
			conn = DbConn.getInstance().getConnection();

			String SQL = "select f.title , a.first_name, a.last_name " + 
					"from actor a " + 
					"inner join film_actor fa " + 
					"on a.actor_id=fa.actor_id " + 
					"inner join film f " + 
					"on f.film_id=fa.film_id " + 
					"inner join film_category fc " + 
					"on fc.film_id=f.film_id " + 
					"inner join category c " + 
					"on c.category_id=fc.category_id " + 
					"where c.name=?";

			pstm = conn.prepareStatement(SQL);

			pstm.setString(1, categoryName);
			rs = pstm.executeQuery();
			listDto = new ArrayList<CategoryDto>();
			while (rs.next()) {
				CategoryDto c= new CategoryDto();

				c.setTitle(rs.getString("title"));
				c.setFirst_name(rs.getString("first_name"));
				c.setLast_name(rs.getString("last_name"));

				listDto.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e.getCause());
			}
			log.info("lettura tramite join (data una categoria) effettuata");
		}
		return listDto;

	}

}
